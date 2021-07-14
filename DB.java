package My_Classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DB {

	// create a connection between the project & mysql database
	private static String serverName = "localhost";
	private static String username = "root";
	private static String dbname = "mydb";
	private static Integer portNumber = 3306;
	private static String password = "Aqwzsx71593"; // no passoword

	// create a a function to create & return the connection

	public static Connection getConnection() {

		Connection connection = null;

		MysqlDataSource datasource = new MysqlDataSource();

		datasource.setServerName(serverName);
		datasource.setUser(username);
		datasource.setDatabaseName(dbname);
		datasource.setPortNumber(portNumber);
		datasource.setPassword(password);

		try {
			connection = datasource.getConnection();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		return connection;
	}

}
