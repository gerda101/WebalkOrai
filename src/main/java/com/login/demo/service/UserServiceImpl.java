package com.login.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.demo.model.User;
import com.login.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(String userName, String password) throws Exception {
		return this.userRepository.getUser(userName, password);
	}

	@Override
	public void createUser(User user) throws Exception {
		this.userRepository.createUser(user);
	}

}
