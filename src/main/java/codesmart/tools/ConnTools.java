package codesmart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTools {

	public static Connection getConnection(String driverName, String user, String url, String pwd)
			throws ClassNotFoundException, SQLException {
		
		Class.forName(driverName);
		Connection connection = DriverManager.getConnection(url, user, pwd);
		return connection;
	}

	public static void free(Connection connection) throws SQLException{
		if(connection != null){
			connection.close();
		}
	}
	
}
