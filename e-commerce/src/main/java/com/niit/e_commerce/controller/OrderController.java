package com.niit.e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CartDao;
import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Order;
import com.niit.e_commercebackend.dao.OrderDao;

@Controller
public class OrderController {

	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	CartDao cartDao;
	
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@RequestMapping("/user/ship")
	public ModelAndView buy(){
	
		ModelAndView mv1 = new ModelAndView("ship");
	
		return mv1;
	}
	
	@RequestMapping("/user/bill")
	public ModelAndView bill(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("address") String address, @RequestParam("state") String state, @RequestParam("city") String city, @RequestParam("mob") String mob, @RequestParam("pin") String pin)
	{
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String ship=first+","+last+","+address+","+state+","+city+","+mob+","+pin;
		Order o = new Order();
		o.setShip(ship);
		o.setBill(ship);
		o.setUsername(name);
		orderDao.saveOrder(o);
		ModelAndView mv1 = new ModelAndView("bill");
		Order p= new Order();
		p=orderDao.getorbyusername(name);
		mv1.addObject("ord",p.getBill());
ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
		return mv1;
	}
	
	@RequestMapping("/user/order")
	public ModelAndView order(){
		ModelAndView mv1 = new ModelAndView("order");
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
		Order o=new Order();
		o=orderDao.getorbyusername(Username);
		mv1.addObject("bill",o.getBill());
		mv1.addObject("ship",o.getShip());
		ArrayList<Cart> ll=(ArrayList<Cart>)cartDao.getcartbyusernmae(Username);
		
		
		mv1.addObject("ca",ll);
		int total=0;
		for(Cart cart:ll)
		{
		int sum=cart.getPrice()*cart.getQuantity();
		total=total+sum;	
		}
		
		mv1.addObject("t",total);

ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
		return mv1;
	}
	
	@RequestMapping("/user/payment")
	public ModelAndView payment(){
		ModelAndView mv1 = new ModelAndView("payment");

ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
		return mv1;
	}
	
	@RequestMapping("/user/thank")
	public ModelAndView thank(){
		ModelAndView mv1 = new ModelAndView("thanku");
ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
		return mv1;
	}
	
	
	
	
}
