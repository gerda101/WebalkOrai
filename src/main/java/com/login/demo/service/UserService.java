package com.login.demo.service;

import org.springframework.stereotype.Service;

import com.login.demo.model.User;

@Service
public interface UserService {
	public User getUser(String userName, String password) throws Exception;
	public void createUser(User user) throws Exception;
}
