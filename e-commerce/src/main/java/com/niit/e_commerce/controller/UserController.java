package com.niit.e_commerce.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

@SuppressWarnings("unused")
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
	public ModelAndView register(@RequestParam("no") long mobno, @RequestParam("fname") String name, @RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		User i=new User();
		i.setName(name);
		i.setEmail(email);
		i.setPwd(pwd);
		i.setRole("ROLE_USER");
		i.setMobno(mobno);
		UserDao.saveProduct(i);
		ModelAndView mv = new ModelAndView("signin");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cat);
	
		return mv;
	}
	
	@RequestMapping("/user")
	public ModelAndView index()
	{
	
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		ArrayList<Product> p=(ArrayList<Product>)productDao.getallProduct();
		mv1.addObject("off",p);
	    return mv1;
	}
	
	@RequestMapping("/user/{categoryid}")
	public ModelAndView ca(@PathVariable("categoryid") int ca) {
		ArrayList<Product> p=new ArrayList<Product>();
		p=productDao.getprbycatid(ca);
		ModelAndView mv1 = new ModelAndView("ProductList");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		mv1.addObject("pro",p);
		return mv1;
		
	}
}


