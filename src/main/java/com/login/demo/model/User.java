package com.login.demo.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String username;
	private String password;
	private String email;
	
	public User() {
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
