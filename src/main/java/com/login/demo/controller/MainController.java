package com.login.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.login.demo.model.User;
import com.login.demo.service.UserService;

@Controller
public class MainController {
	
	private static final Logger LOGGER = LogManager.getLogger(MainController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private User user;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView loadMainPage() {
		ModelAndView mav = new ModelAndView("Login");
		LOGGER.info("MAIN METHOD CALLED");
		
		return mav;
	}
	
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public ModelAndView loginProcess(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password
			) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		user = userService.getUser(username, password);
		
		if (!(user.getUserName() .equals(""))) {
			mav.setViewName("Welcome");
		} else {
			mav.setViewName("Login");
		}
		
		return mav;
	}
}
