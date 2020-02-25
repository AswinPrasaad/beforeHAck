package com.mockathon.mainController;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mockathon.modelPojo.Users;
import com.mockathon.service.ServiceIntf;

@RestController
public class MainController {

	
	@Autowired
	ServiceIntf ser;
	
	@GetMapping(value="/first" )
   public ModelAndView first(Users user,Model model){
		model.addAttribute("first", user);
		return new ModelAndView("index");
	}
	
	@GetMapping(value="/register")
	   public ModelAndView registration( Users user){
			return new ModelAndView("registrationPage");
		}
	
	@PostMapping(value="/addUser" )
	   public ModelAndView addUser(@Validated @ModelAttribute("user") Users user, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ModelAndView("registrationPage");
		}
		ser.save(user);
		
			return new ModelAndView("loginPage");
		}
	


	
}
