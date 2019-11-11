package com.login.demo.repository;

import org.springframework.stereotype.Repository;

import com.login.demo.model.User;

@Repository
public interface UserRepository {

	public User getUser(String username, String password) throws Exception;
	public void createUser(User user) throws Exception;
}
