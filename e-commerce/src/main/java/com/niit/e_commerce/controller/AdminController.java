package com.niit.e_commerce.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.OrderDao;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Order;
import com.niit.e_commercebackend.models.Supplier;
import com.niit.e_commercebackend.models.Product;

@Controller
public class AdminController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	private MailSender sendmail;
	
	
	/*admin page loading*/
	@RequestMapping("/admin/ad")
	public ModelAndView ad()
	{
		ModelAndView mv = new ModelAndView("add");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		ArrayList<Supplier> ss=(ArrayList<Supplier>)supplierDao.getallSupplier();
		mv.addObject("categ",cc);
		mv.addObject("catego",ss);
		return mv;
		
	}
	
	@RequestMapping("/ad")
	public ModelAndView admin()
	{
		ModelAndView mv = new ModelAndView("redirect:/admin/ad");
		
		return mv;
		
	}
	@RequestMapping("/admin")
	public ModelAndView index()
	{
	
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Product> p=(ArrayList<Product>)productDao.getallProduct();
		mv1.addObject("off",p);
	    return mv1;
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
		
		return mv1;
	
	}
	
	@RequestMapping("/admin/order")
	public ModelAndView order() 
	{
		ModelAndView mv1 = new ModelAndView("Pending");
		ArrayList<Order> o=orderDao.getallundeliveredprods();
		 mv1.addObject("order",o);
return mv1;	
}
	
	@RequestMapping("/admin/shipped")

	public ModelAndView shipped(@RequestParam("id") int id)
{
		ModelAndView mv1 = new ModelAndView("redirect:/admin/order");
		Order os=orderDao.getorbyid(id);
		
		os.setDeliver(1);
	orderDao.updateOrder(os);
	
	
		SimpleMailMessage email = new SimpleMailMessage();
	    email.setTo(os.getUsername());
	    email.setSubject("PRODUCT SHIPPED");
	    
	    email.setText("Product shipped and will reach you soon.\nThanks for shopping from TechGuru");
	    // sends the e-mail
	    sendmail.send(email);

		Order or=orderDao.getorbyid(id);
		orderDao.deleteorder(or);
		return mv1;
}
}
