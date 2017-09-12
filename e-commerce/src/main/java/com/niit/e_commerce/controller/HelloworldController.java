package com.niit.e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloworldController {
	String message = "Welcome to Spring MVC!";
 
	@RequestMapping("/hello/{name}")
	public ModelAndView showMessage(@PathVariable("name") String n) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("msg", "Success");
		mv.addObject("name", n);
		
		return mv;
	}
	@RequestMapping("/")
	public String index()
	{
		System.out.println("hai");
		return "index";
		
	}
	@RequestMapping("/in")
	public String in()
	{
		return "signin";
		
	}
	@RequestMapping("/up")
	public String up()
	{
		return "signup";
		
	}
	@RequestMapping("/car")
	public String car()
	{
		return "cart";
		
	}
	
}
