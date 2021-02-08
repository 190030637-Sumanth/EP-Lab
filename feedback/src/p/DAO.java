package p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	public int insert(Bean b) throws SQLException, ClassNotFoundException
	{
		Connection con=DBUtil.DBConnection();
		String sql = "INSERT INTO user (username, email, gender, password) VALUES (?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, b.getUsername());
		statement.setString(2, b.getEmail());
		statement.setString(3, b.getGender());
		statement.setString(4, b.getPassword());
		int rows = statement.executeUpdate();
		statement.close();
		con.close();
		return rows;
	}
	
    public boolean check(Bean b) throws SQLException, ClassNotFoundException {
    	Connection con=DBUtil.DBConnection();
    	String sql = "SELECT * FROM user";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while(result.next())
		{
			String email= result.getString("email");
			String password = result.getString("password");
			if(email.equals(b.getEmail()) && password.equals(b.getPassword()))
			{
				return true;
			}
		}
		statement.close();
		con.close();
		return false;
    }
    
    public int insert_fback(String n,String f) throws ClassNotFoundException, SQLException
    {
    	Connection con=DBUtil.DBConnection();
		String sql = "INSERT INTO feedback (name, feedback) VALUES (?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, n);
		statement.setString(2, f);
		int rows = statement.executeUpdate();
		statement.close();
		con.close();
		return rows;
    }
}