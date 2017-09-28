package com.niit.e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Supplier;
 
@SuppressWarnings("unused")
@Controller
public class HelloworldController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
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
	public ModelAndView index()
	{
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("index");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		System.out.println("hai after retrieve");
		for(Category c:cat)
		{
			System.out.println(c);
		}
		mv.addObject("cate",cat);
		System.out.println("after adding object");
	
		return mv;
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
	@RequestMapping("/ad")
	public ModelAndView ad()
	{
		ModelAndView mv = new ModelAndView("add");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		ArrayList<Supplier> ss=(ArrayList<Supplier>)supplierDao.getallSupplier();
		System.out.println("product category");
	
		
		mv.addObject("categ",cc);
		mv.addObject("catego",ss);
		return mv;
		
	}
	
}
