package com.springboot.curd.FirstDemo.MainController;

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

import com.springboot.curd.FirstDemo.Model.User;
import com.springboot.curd.FirstDemo.ServiceLayer.DemoServiceIntf;

@RestController
public class MainController {

	
	@Autowired
	DemoServiceIntf ser;
	
	@GetMapping(value="/first" )
   public ModelAndView first(User user,Model model){
		model.addAttribute("first", user);
		return new ModelAndView("index");
	}
	
	@GetMapping(value="/register")
	   public ModelAndView registration( User user){
			return new ModelAndView("registrationPage");
		}
	
	@PostMapping(value="/addUser" )
	   public ModelAndView addUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ModelAndView("registrationPage");
		}
		ser.save(user);
		
			return new ModelAndView("loginPage");
		}
	
	
	@GetMapping(value="/welcome" )
	   public ModelAndView welcome(@ModelAttribute("summa") User user, Model model){
	
		List<User> l=ser.findAll(user);
		
			return new ModelAndView("welcome","viewList",l);
			
			
		}
	
	@GetMapping(value="/delete" )
	   public ModelAndView delete(@RequestParam("id")int id,@ModelAttribute("welcome") User user,HttpServletRequest request){
		
	//String id=request.getParameter("id");
		ser.delete(id);
		List<User> l=ser.findAll(user);
			return new ModelAndView("welcome","viewList",l);
			
			
		}
	/*@GetMapping(value="/findByUserName/${name}" )
	   public ModelAndView findByName(@RequestParam("name")String name,@ModelAttribute("welcome") User user,HttpServletRequest request){
		
	//String name=request.getParameter("names");
		//ser.delete(id);
		List<User> l=ser.findByUserName(name);
			return new ModelAndView("welcome","viewList",l);
			
			
		}*/
	
	@RequestMapping(value="/findByUserId/{id}" )
	   public ModelAndView findByID(@PathVariable("id")int id,@ModelAttribute("summa") User user,HttpServletRequest request){
		
	//String name=request.getParameter("names");
		//ser.delete(id);
		System.out.println("hi");
		User l=ser.findByUserId(id);
		
			return new ModelAndView("welcome","viewById",l);
			
			
		}
	
	@RequestMapping(value="/findByUserName/{name}" )
	   public ModelAndView findByUserName(@PathVariable("name")String name,@ModelAttribute("summa") User user,HttpServletRequest request){
		
	//String name=request.getParameter("names");
		//ser.delete(id);
		System.out.println("hi");
		List<User> l=ser.findByUserName(name);
		
			return new ModelAndView("after deletion","viewList",l);
			
			
		}
	

		
	
}
