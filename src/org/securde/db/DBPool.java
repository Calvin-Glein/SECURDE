package org.securde.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBPool {

	public static String schema = "libsysdb";
	public static String username = "root";
	public static String password = "1234";
	public static String url = "jdbc:mysql://localhost:3307/";
	public static String driver = "com.mysql.jdbc.Driver";
	// an instance of itself

	private static DBPool singleton = null;

	private static BasicDataSource basicDataSource;

	private DBPool() {
		// initialze database connection

		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);

		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setUrl(url + schema);

		// jdbc:mysql://localhost:3306/clothingdb

	}

	// getInstance

	public static DBPool getInstance() {
		if (singleton == null) {
			singleton = new DBPool();
		}

		return singleton;
	}

	public Connection getConnection() {
		try {
			return basicDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return null;

	}
}
