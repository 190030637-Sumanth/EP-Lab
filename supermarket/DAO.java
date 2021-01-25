package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	public void insert(Bean b) throws SQLException
	{
		Connection con=DBUtil.DBConnection();
		String sql = "INSERT INTO market (itemname, cost) VALUES (?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, b.getItemName());
		statement.setFloat(2, b.getCost());
		int rows = statement.executeUpdate();
		if(rows>0) {
			System.out.println("a row has been inserted");
		}
		statement.close();
		con.close();
	}
	
    public void Display() throws SQLException {
    	Connection con=DBUtil.DBConnection();
    	String sql = "SELECT * FROM market";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		int count = 0;
		float total=0;
		while(result.next())
		{
			String n= result.getString("itemname");
			float c = result.getFloat("cost");
			count++;
			total=total+c;
			System.out.println("item "+ count +":"+"Item Name : "+ n +" cost of item :"+ c);
		}
		System.out.println("total cost : "+total);
		statement.close();
		con.close();
    }
}
