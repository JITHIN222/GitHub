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
import com.niit.e_commercebackend.models.Product;

@Controller
public class CartController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	CartDao cartDao;
	
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;
	
	/*adding category to db*/
@RequestMapping("/cart")
	public ModelAndView catr(@RequestParam("id") int id ){
		
		ModelAndView mv1 = new ModelAndView("Product");
		Cart c=new Cart();
		Product ll=new Product();
		ll=productDao.getprbyid(id);
		int pid=ll.getId();
		String pname=ll.getName();
		String pimg=ll.getImg();
		int price=ll.getPrice();
		
		Product pp=new Product();
		pp.setId(pid);
		pp.setName(pname);
		pp.setImg(pimg);
		pp.setPrice(price);
		
		c.setPid(pp);
		
		c.setStatus("NP");
		c.setQuantity(1);
		c.setPrice(price);
	
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		
		c.setUsername(username);
		cartDao.saveCart(c);
		return mv1;
	}

/*cart page*/
@RequestMapping("/car")
public ModelAndView car(){
	
	ModelAndView mv1 = new ModelAndView("cart");
	
	
	ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
	
			
			mv1.addObject("cate",l);
			String Username=SecurityContextHolder.getContext().getAuthentication().getName();
			
			ArrayList<Cart> ll=(ArrayList<Cart>)cartDao.getcartbyuserid(Username);
			
			
			
			

			mv1.addObject("ca",ll);
			return mv1;
	
	
}

}