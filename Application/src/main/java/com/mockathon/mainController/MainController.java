package com.mockathon.mainController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class MainController {

	 @RequestMapping(value="/index")
	 public String index(){
		return "Welcome";
		 
	 }
	 
	
	
	
	
}
