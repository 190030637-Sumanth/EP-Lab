package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection DBConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/inlab";
		String username = "root";
		String password = "1234";
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
