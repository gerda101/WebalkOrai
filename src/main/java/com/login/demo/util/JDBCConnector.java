package com.login.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	public static Connection getConnection(String dbUrl) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName(JDBC_DRIVER);
		
		conn = DriverManager.getConnection(dbUrl, USERNAME, PASSWORD);
		
		return conn;
	}
	
}
