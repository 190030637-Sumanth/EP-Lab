package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection DBConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/inlab";
		String username = "root";
		String password = "1234";
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
