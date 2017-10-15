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
	public ModelAndView addcart(@RequestParam("id") int id)
	{ 
		
		 org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	     Cart cart=new Cart();
		
int count=0,cartid=0;
	ArrayList<Cart> car=new ArrayList<Cart>();
	
	car=cartDao.getcartbyusernmae(name);
	for(Cart c:car )
	{
		Product ppp=c.getPid();
		if(ppp.getId()==id)
		{
			count=1;
			cartid=c.getId();
		}
	}
	if(count==1)
	{
		
		Cart c=cartDao.getcartbyid(cartid);
		int quantity=c.getQuantity();
		quantity=quantity+1;
		cartDao.updatequantity(cartid,quantity);
	}
	else
	{
		cart.setUsername(name);
cart.setQuantity(1);
		
		
		Product p=new Product();
		p=cartDao.getprbyid(id);
		if(p.getOfferprice()!=0)
		{
		cart.setPrice(p.getOfferprice());	
		}
		else
		{
			cart.setPrice(p.getPrice());
		}
		
		cart.setPid(p);
		cart.setStatus("NP");
		
		cartDao.saveCart(cart);
			
		
	}
		
		
		
		ModelAndView mv1 = new ModelAndView("Product");
		Product ll=new Product();
		ll=productDao.getprbyid(id);
		
		mv1.addObject("pr",ll);
		
		
ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		
		 
		
		mv1.addObject("catego",l);
	
	
		return mv1;
	}

/*cart page header*/
@RequestMapping("/car")
public ModelAndView car(){
	
	ModelAndView mv1 = new ModelAndView("cart");
	
	
	ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
	
			
			mv1.addObject("cate",l);
			String Username=SecurityContextHolder.getContext().getAuthentication().getName();
			
			ArrayList<Cart> ll=(ArrayList<Cart>)cartDao.getcartbyusernmae(Username);
			
			
			mv1.addObject("ca",ll);
			int total=0;
			for(Cart cart:ll)
			{
			int sum=cart.getPrice()*cart.getQuantity();
			total=total+sum;	
			}
			
			mv1.addObject("t",total);
			return mv1;
	
	
}

}