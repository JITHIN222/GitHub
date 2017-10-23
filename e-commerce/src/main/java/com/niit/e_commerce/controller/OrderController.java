package com.niit.e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
import com.niit.e_commercebackend.models.Product;
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
	
	@Autowired
	private MailSender sendmail;
	
	//product buy to ship
	@RequestMapping("/user/buy")
		public ModelAndView buy(@RequestParam("id") int id){
		ModelAndView mv1 = new ModelAndView("redirect:/user/ship");
		
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
		cart.setPname(p.getName());
		cartDao.saveCart(cart);
			
		
	}
		
		ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
		return mv1;
	}
	
	//ship
	@RequestMapping("/user/ship")
	public ModelAndView ship(){
	
		ModelAndView mv1 = new ModelAndView("ship");
		 ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
			mv1.addObject("cate",l);
		return mv1;
	}
	
	//billing address
	@RequestMapping("/user/bill")
	public ModelAndView bill(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("address") String address, @RequestParam("state") String state, @RequestParam("city") String city, @RequestParam("mob") String mob, @RequestParam("pin") String pin)
	{
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String ship=first+","+last+","+address+","+state+","+city+","+mob+","+pin;
		Order o = new Order();
		o.setShip(ship);
		o.setBill(ship);
		o.setDeliver(0);
		o.setOrder_detail("null");
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
	
	//order confirmation
	@RequestMapping("/user/order")
	public ModelAndView order(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("address") String address, @RequestParam("state") String state, @RequestParam("city") String city, @RequestParam("mob") String mob, @RequestParam("pin") String pin){
		ModelAndView mv1 = new ModelAndView("order");
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
		String bill=first+","+last+","+address+","+state+","+city+","+mob+","+pin;
		Order b=orderDao.getorbyusername(Username);
		b.setBill(bill);
		orderDao.updateOrder(b);
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
	
	//payment
	@RequestMapping("/user/payment")
	public ModelAndView payment(){
		
		
		ModelAndView mv1 = new ModelAndView("payment");
		return mv1;
	}
	
	
	//
	@RequestMapping("/user/thank")
	public ModelAndView thank(){
		ModelAndView mv1 = new ModelAndView("thanku");
		int total=0;
		String order="";
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
        ArrayList<Cart> ll=(ArrayList<Cart>)cartDao.getcartbyusernmae(Username);
	    for(Cart c: ll)
	    {
	    	int tot=c.getPrice()*c.getQuantity();
			order=order+"    "+c.getPname()+"         "+"Price:"+"$"+c.getPrice()+"       "+"Quantity:"+c.getQuantity()+"       "+"Total:"+tot+"\n";
			cartDao.deletecart(c.getId());
	    	total= total+tot;
	    }
        
	    Order s= (Order)orderDao.getorbyusername(Username);
			s.setOrder_detail(order);
			s.setDeliver(0);
			orderDao.updateOrder(s);

		
		
		SimpleMailMessage email = new SimpleMailMessage();
	    email.setTo(Username);
	    email.setSubject("ORDER CONFIRMATION");
	    email.setText("Your Order\n"+order+"\n is placed successfully and the total payment of $"+ total+"has been Approved by Seller");
	    // sends the e-mail
	    sendmail.send(email);
	    
	    ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
  
		return mv1;
	}
	
	
	
	
}
