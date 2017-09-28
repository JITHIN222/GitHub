package com.niit.e_commerce.controller;

import java.util.*;
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
	public ModelAndView register(@RequestParam("fname") String name, @RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		System.out.println("in controller");
		System.out.println(name);
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		User i=new User();
		i.setName(name);
		i.setEmail(email);
		i.setPwd(pwd);
	
		UserDao.saveProduct(i);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("cate",cat);
		
	
		return mv;
	}
	@RequestMapping("/addC")
	public ModelAndView addC(@RequestParam("name") String name) {
		System.out.println("in controller"+name);
		
		Category i=new Category();
		i.setName(name);
		categoryDao.saveCategory(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}

	@RequestMapping("/addS")
	public ModelAndView addS(@RequestParam("name") String name) {
		System.out.println("in controller");
		System.out.println(name);
		Supplier i=new Supplier();
		i.setName(name);
		supplierDao.saveSupplier(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
	
	@RequestMapping("/addP")
	public ModelAndView addP(@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("stock") int stock, @RequestParam("short") String shortDesc  ) {
		System.out.println("in controller");
		System.out.println(name);
		Product i=new Product();
		i.setName(name);
		i.setPrice(price);
		i.setStock(stock);
		i.setShortDesc(shortDesc);
		productDao.saveProduct(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
}


