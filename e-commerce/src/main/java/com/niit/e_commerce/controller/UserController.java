package com.niit.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.UserDao;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.User;

@Controller
public class UserController {

	@Autowired
	UserDao UserDao;
	
	@Autowired
	CategoryDAO categoryDao;

	@RequestMapping("/reg")
	public ModelAndView register(@RequestParam("uname") String name) {
		System.out.println("in controller");
		System.out.println(name);
		User i=new User();
		i.setName(name);
		UserDao.saveProduct(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
	@RequestMapping("/addC")
	public ModelAndView addC(@RequestParam("uname") String name) {
		System.out.println("in controller");
		System.out.println(name);
		Category i=new Category();
		i.setName(name);
		categoryDao.saveCategory(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
}

