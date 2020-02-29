package metaparking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.PropertySource;

/**
 * Class to implement SQL JDBC connection
 *
 */
@PropertySource("classpath:application.properties")
public class ConnectionUtility {

	private String driverPath = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/meta_parking";
	private String userName = "root";
	private String password = "root";
	private Connection connection = null;

	/**
	 * Provides connection to sql database
	 * @return Connecction
	 */
	public Connection createConnection() {
		System.out.println(driverPath + " " + url + " " + userName + " " + password);
		try {
			Class.forName(driverPath);
			if(connection==null) {
				connection = DriverManager.getConnection(url, userName, password);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Closes connection to database if any
	 * @param connection
	 * @return true if connection is closed or false otherwise
	 */
	public boolean closeConnection(Connection connection) {
		boolean isConnectionClosed = false;
		try {
			connection.close();
			isConnectionClosed = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isConnectionClosed;
	}
}