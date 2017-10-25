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
	public String register(@RequestParam("no") long mobno, @RequestParam("fname") String name, @RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		try{
		User i=new User();
		i.setName(name);
		i.setEmail(email);
		i.setPwd(pwd);
		i.setRole("ROLE_USER");
		i.setMobno(mobno);
		UserDao.saveProduct(i);
		return "redirect:/in?f=";
		}
		catch(Exception e){
			String c="";
			c="already registered";
			return "redirect:/up?f="+c;
		}

	
		
	}
	
	@RequestMapping("/user")
	public ModelAndView index()
	{
		ModelAndView mv1 = new ModelAndView("redirect:/");
	    return mv1;
	}
	
	@RequestMapping("/user/{categoryid}")
	public ModelAndView ca(@PathVariable("categoryid") int ca) {
		ModelAndView mv1 = new ModelAndView("redirect:/{categoryid}?id="+ca);
		return mv1;
		
	}
	
	@RequestMapping("/user/product")
	public ModelAndView product(@RequestParam("id") int id){
		ModelAndView mv = new ModelAndView("redirect:/product?id="+id);
		return mv;
		
	}
}


