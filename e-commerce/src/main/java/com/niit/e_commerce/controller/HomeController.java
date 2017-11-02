package com.niit.e_commerce.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CartDao;
import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.dao.UserDao;
import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;
import com.niit.e_commercebackend.models.Supplier;
import com.niit.e_commercebackend.models.User;
 
@SuppressWarnings("unused")
@Controller
public class HomeController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	private MailSender sendmail;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	UserDao  userDao;

	/*Home Page*/
	@RequestMapping("/")
	public ModelAndView index()
	{
		Random random= new Random();
		Random random1= new Random();
	
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
        ArrayList<Product> r=new ArrayList<Product>();
		 r=(ArrayList<Product>)productDao.getallProduct();
		//for displaying special offers randomly from the Product list
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
		 ArrayList<Product> o=new ArrayList<Product>();
		 o=(ArrayList<Product>)productDao.offerlist();
		int ind1 = random1.nextInt(o.size());
		 Product p11=o.get(ind1);
		 mv1.addObject("ofp11",p11);
		 r.remove(p11);
		int index21 = random1.nextInt(o.size());
		 Product p21=o.get(index21);
		 mv1.addObject("ofp21",p21);
		 r.remove(p21);
		int index31 = random.nextInt(o.size());
		 Product p31=o.get(index31);
		 mv1.addObject("ofp31",p31);
		 r.remove(p31);
		 int index41 = random.nextInt(o.size());
		 Product p41=o.get(index41);
		 mv1.addObject("ofp41",p41);
		 r.remove(p41);
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
	
	//forget page
	@RequestMapping("/fo")
	public ModelAndView forget(@RequestParam("msg") int msg)
	{
		ModelAndView mv = new ModelAndView("forget");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cc);
		mv.addObject("msg",msg);
		return mv;
}
	
	//check mail
	@RequestMapping("/for")
	public String forgot(@RequestParam("name") String name)
	{
		int flag=0;
		
		ArrayList<User> use=userDao.getalluser();

		for(User uuu:use)
		{
			if(uuu.getEmail().equals(name))
			{
				flag++;
			}
		}
			
		if(flag==0)
		{
		
			return "redirect:/fo?msg="+1;
		}
		else
		{
		ArrayList<User> u=userDao.getuserbyusername(name);
		for(User uu:u)
		{
			
			
			 SimpleMailMessage email = new SimpleMailMessage();
		        email.setTo(name);
		        email.setSubject("Password Recovery");
		        email.setText("Your password is "+uu.getPwd()+"Try to remember your password");
		         
		        // sends the e-mail
		        sendmail.send(email);
		}
		return "redirect:/in";
		}
	}
}
