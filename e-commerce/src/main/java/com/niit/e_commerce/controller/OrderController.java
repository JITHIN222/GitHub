package com.niit.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CartDao;
import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
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
	
	@RequestMapping("/user/buy")
	public ModelAndView buy(){
	
		ModelAndView mv1 = new ModelAndView("ship");
	
		return mv1;
	}
	
	@RequestMapping("/user/bill")
	public ModelAndView bill(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("address") String address, @RequestParam("state") String state, @RequestParam("city") String city, @RequestParam("mob") int mob, @RequestParam("pin") int pin)
	{
		String ship=first+" "+last+" "+address+" "+state+" "+city+" "+mob+" "+pin;
		Order o = new Order();
		o.setShip(ship);
		orderDao.saveOrder(o);
		ModelAndView mv1 = new ModelAndView("bill");
		return mv1;
	}
	
	@RequestMapping("/user/order")
	public ModelAndView order(){
		ModelAndView mv1 = new ModelAndView("order");
		return mv1;
	}
	
	@RequestMapping("/user/payment")
	public ModelAndView payment(){
		ModelAndView mv1 = new ModelAndView("payment");
		return mv1;
	}
	
	@RequestMapping("/user/thank")
	public ModelAndView thank(){
		ModelAndView mv1 = new ModelAndView("thanku");
		return mv1;
	}
	
	
	
	
}
