package com.niit.e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CartDao;
import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;
import com.niit.e_commercebackend.models.Supplier;
 
@SuppressWarnings("unused")
@Controller
public class HomeController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	SupplierDao supplierDao;

	/*Home Page*/
	@RequestMapping("/")
	public ModelAndView index()
	{
	
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		ArrayList<Product> p=(ArrayList<Product>)productDao.getallProduct();
		mv1.addObject("off",p);
	    return mv1;
	}
	
	/*login page*/
	@RequestMapping("/in")
	public ModelAndView signin()
	{
		ModelAndView mv = new ModelAndView("signin");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cc);
		return mv;
		
	}
	
	/*error invalid username*/
	@RequestMapping("/invalid")
	public ModelAndView error()
	{
		ModelAndView mv = new ModelAndView("authentication");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cc);
		return mv;
		
	}
	
	/*error access denied*/
	@RequestMapping("/authFa")
	public ModelAndView err()
	{
		ModelAndView mv = new ModelAndView("invalid");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cc);
		return mv;
		
	}
	
	/*Signup page*/
	@RequestMapping("/up")
	public ModelAndView signup()
	{
		ModelAndView mv = new ModelAndView("signup");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cc);
		return mv;
		
	}
	
	
}
