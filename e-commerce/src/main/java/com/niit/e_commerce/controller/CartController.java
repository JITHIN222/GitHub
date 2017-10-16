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
	
	/*adding cart to db*/
	@RequestMapping("/cart")
	public ModelAndView addcart(@RequestParam("id") int id)
	{ 
		
	     String name = SecurityContextHolder.getContext().getAuthentication().getName();
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
	if(count==1) //actually quantity update if want same product more than one
	{
		
		Cart c=cartDao.getcartbyid(cartid);
		int quantity=c.getQuantity();
		quantity=quantity+1;
		cartDao.updatequantity(cartid,quantity);
	}
	else //else condition for adding one quantity for one product
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
		
		
		
		ModelAndView mv1 = new ModelAndView("cart");
		ArrayList<Cart> ll=(ArrayList<Cart>)cartDao.getcartbyusernmae(name);
		
		
		mv1.addObject("ca",ll);
		int total=0;
		for(Cart ca1:ll)
		{
		int sum=ca1.getPrice()*ca1.getQuantity();
		total=total+sum;	
		}
		
		mv1.addObject("t",total);
		
		
ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		
		 
		
		mv1.addObject("cate",l);
	
	
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

/*redirecting to Cartupdate page*/
@RequestMapping("/cartup")
	public ModelAndView cartupdate(@RequestParam("cartid") int cartid) {
		
		ModelAndView mv1 = new ModelAndView("Cartupdate");
		ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
		Cart c= new Cart();
		c=cartDao.getcartbyid(cartid);
		mv1.addObject("ca",c);
		return mv1;
}

/*cart update done & redirecting to cart page*/
@RequestMapping("/updatecart")
public ModelAndView cart(@RequestParam("id") int cartid, @RequestParam("quantity") int quantity) {
	ModelAndView mv1 = new ModelAndView("cart");
	ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
	mv1.addObject("cate",l);
	Cart c= new Cart();
	String Username=SecurityContextHolder.getContext().getAuthentication().getName();
	c.setUsername(Username);
	c.setQuantity(quantity);
	Product pr=new Product();
	pr=cartDao.getprbyid(cartid);
	c.setPid(pr);
	c.setPrice(pr.getPrice());
	c.getStatus();
	cartDao.updatecart(c);
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


/*delete cart*/
@RequestMapping("/cartdel")
	public ModelAndView cartdelete(@RequestParam("cartid") int cartid) {
		
		cartDao.deletecart(cartid);
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

@RequestMapping("/buy")
public ModelAndView buy(){
	ModelAndView mv1 = new ModelAndView("order");
	return mv1;
}

}