package com.niit.e_commerce.controller;

import java.util.ArrayList;
import java.util.Random;

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
		/*Random random= new Random();*/
	
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		ArrayList<Product> p=(ArrayList<Product>)productDao.getallProduct();
		mv1.addObject("off",p);
/*		ArrayList<Product> r=new ArrayList<Product>();
		 r=(ArrayList<Product>)productDao.offerlist();
		//for displaying special offers randomly from the offer list
		int index1 = random.nextInt(r.size());
		 Product p1=r.get(index1);
		 mv1.addObject("ofp1",p1);
		 r.remove(p1);
		 int index2 = random.nextInt(r.size());
		 Product p2=r.get(index2);
		 mv1.addObject("ofp2",p2);
		 r.remove(p2);
		 int index3 = random.nextInt(r.size());
		 Product p3=r.get(index3);
		 mv1.addObject("ofp3",p3);
		 r.remove(p3);
		 int index4 = random.nextInt(r.size());
		 Product p4=r.get(index4);
		 mv1.addObject("ofp4",p4);
		 r.remove(p4);*/
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
	public ModelAndView signup(@RequestParam("f") String ca)
	{
		ModelAndView mv = new ModelAndView("signup");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cc);
		if(ca == " " ){
			mv.addObject("c"," ");
		}
		else{
			mv.addObject("c",ca);
		}
		return mv;
		
	}
	
	
}
