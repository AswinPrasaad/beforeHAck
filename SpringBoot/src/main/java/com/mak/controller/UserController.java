package com.mak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mak.configuration.SecurityService;
import com.mak.model.Users;
import com.mak.service.UserService;

@RestController
public class UserController {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService securityService;
	
	@RequestMapping("/showRegistration")
	public ModelAndView showRegisterForm(){
		return new ModelAndView("registration-page","users",new Users());
	}
	@PostMapping("saveRegistrationForm")
	public ModelAndView saveRegistrationForm(@Validated @ModelAttribute("users")Users users, HttpServletRequest request, BindingResult result){
		if(result.hasErrors()){
			System.out.println("registration");	
			return new ModelAndView("registration-page");
		}
		else{
			System.out.println("saveRegistration");	
			users.setEnabled(1);
			users.setPassword(passwordEncoder.encode(users.getPassword()));
			userService.saveUser(users);
			securityService.autoLogin(request.getParameter("userName"), request.getParameter("password"));
			return new ModelAndView("home");
		}
		
		
	}
}
