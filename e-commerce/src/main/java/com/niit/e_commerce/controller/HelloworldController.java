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
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;
import com.niit.e_commercebackend.models.Supplier;
 
@SuppressWarnings("unused")
@Controller
public class HelloworldController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	/*Home Page*/
	@RequestMapping("/")
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cat);
		System.out.println("after adding object");
	
		return mv;
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
	
	/*error*/
	@RequestMapping("/error")
	public ModelAndView error()
	{
		ModelAndView mv = new ModelAndView("signin");
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
	
	/*cart page*/
	@RequestMapping("/car")
	public ModelAndView cart()
	{
		ModelAndView mv = new ModelAndView("cart");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cc);
		return mv;
		
	}
	
	/*offer page*/
	@RequestMapping("/admin/offer")
	public ModelAndView offer()
	{
		ModelAndView mv1 = new ModelAndView("offer");
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)productDao.getallProduct();
		 mv1.addObject("pr",p);	
		 ArrayList<Product> pf=(ArrayList<Product>)productDao.offerlist();
		 mv1.addObject("offpr",pf);
ArrayList<Category> c =(ArrayList<Category>)categoryDao.getallCategories();
mv1.addObject("cate",c);
		return mv1;
		
		
	}
	
	/*offer setting*/
	@RequestMapping("/admin/setoffer")
	public ModelAndView offerprice(@RequestParam("prid") int pr,@RequestParam("offerprice") int offpr,@RequestParam("actp") int actp) 
	{ 
		ModelAndView mv1 = new ModelAndView("offer");
		productDao.setoffers(pr,offpr,actp);
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)productDao.getallProduct();
		 mv1.addObject("prods",p);	
		 ArrayList<Product> pf=(ArrayList<Product>)productDao.offerlist();
		 mv1.addObject("offpr",pf);
		ArrayList<Category> c =(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",c);
		
		
		return mv1;
	
	}
	
	/*delete offer*/
	@RequestMapping("/admin/offerdelete")
	public ModelAndView offerdelete(@RequestParam("pr") int id) 
	{
		ModelAndView mv1 = new ModelAndView("offer");
		productDao.deleteoffer(id);
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)productDao.getallProduct();
		 mv1.addObject("prods",p);	
		 ArrayList<Product> pf=(ArrayList<Product>)productDao.offerlist();
		 mv1.addObject("offpr",pf);
		ArrayList<Category> c =(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",c);
		
		
		return mv1;
	
	}
	
	
}
