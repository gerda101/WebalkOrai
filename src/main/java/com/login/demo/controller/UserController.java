package com.login.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.login.demo.model.User;
import com.login.demo.service.UserService;

public class UserController {
	
	@Autowired
	private User user;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="addUser", method=RequestMethod.GET)
	public ModelAndView getUserPage() throws Exception {
		return new ModelAndView("User");
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public ModelAndView addUser(
		@RequestParam(value="username", required=true) String username,
		@RequestParam(value="email", required=true) String email,
		@RequestParam(value="password", required=true) String password
		) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		user.setUserName(username);
		user.setEmail(email);
		user.setPassword(password);
		
		userService.createUser(user);
		
		mav.setViewName("User");
		
		return mav;	
	}

}
