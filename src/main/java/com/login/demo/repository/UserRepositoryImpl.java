package com.login.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.demo.model.User;
import com.login.demo.util.JDBCConnector;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private static final String DB_URL = "jdbc:mysql://localhost/login";
	
	@Autowired
	private User user;
	
	@Override
	public User getUser(String username, String password) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = JDBCConnector.getConnection(DB_URL);
			
			stmt = conn.createStatement();
			String query = "SELECT username, password FROM user WHERE " +
			"username = '" + username + "' AND password = '" + password + "'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}
		return user;
	}

	@Override
	public void createUser(User user) throws Exception {
		Connection conn = null;
		Statement stmt = null; 
		
		try {
			conn = JDBCConnector.getConnection(DB_URL);
			
			stmt = conn.createStatement();
			String query = "INSERT INTO user (username, password, email) VALUES (?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, user.getUserName());
			preparedStmt.setString(2, user.getPassword());
			preparedStmt.setString(3, user.getEmail());
			preparedStmt.execute();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}
}

}
