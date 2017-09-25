package com.niit.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.dao.UserDao;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Supplier;
import com.niit.e_commercebackend.models.User;
import com.niit.e_commercebackend.models.Product;

@Controller
public class UserController {

	@Autowired
	UserDao UserDao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;
	

	@RequestMapping("/reg")
	public ModelAndView register(@RequestParam("fname") String name, @RequestParam("mail") String email, @RequestParam("pwd") String pwd, @RequestParam("cpwd") String cpwd) {
		System.out.println("in controller");
		System.out.println(name);
		User i=new User();
		i.setName(name);
		i.setEmail(email);
		i.setPwd(cpwd);
		i.setCpwd(cpwd);
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
	
	@RequestMapping("/addS")
	public ModelAndView addS(@RequestParam("uname") String name) {
		System.out.println("in controller");
		System.out.println(name);
		Supplier i=new Supplier();
		i.setName(name);
		supplierDao.saveSupplier(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
	
	@RequestMapping("/addP")
	public ModelAndView addP(@RequestParam("uname") String name, @RequestParam("price") String price, @RequestParam("stock") String stock, @RequestParam("short") String shortDesc  ) {
		System.out.println("in controller");
		System.out.println(name);
		Product i=new Product();
		i.setName(name);
		productDao.saveProduct(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
}


