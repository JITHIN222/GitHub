package com.niit.e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.ReviewDao;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;
import com.niit.e_commercebackend.models.Review;

@Controller
public class ReviewController {

	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	@RequestMapping("/review")
	public ModelAndView rev(@RequestParam("id") int id, @RequestParam("name") String name,@RequestParam("rev") String rev){
		ModelAndView mv1 = new ModelAndView("redirect:/product?id="+id);
		Review r= new Review();
		r.setPrid(id);
		r.setUsername(name);
		r.setRev(rev);
		reviewDao.saveReview(r);
		
		
		ArrayList<Review> l= new ArrayList<Review>();
		l=reviewDao.getrevbyprid(id);
		mv1.addObject("review",l);
		
		return mv1;
	}
	
	/*@RequestMapping("/user/review")
	public ModelAndView urev(@RequestParam("id") int id, @RequestParam("name") String name,@RequestParam("rev") String rev){
		ModelAndView mv1 = new ModelAndView("ProductList");
		Review r= new Review();
		r.setPrid(id);
		r.setUsername(name);
		r.setRev(rev);
		reviewDao.saveReview(r);
		Product p=new Product();
		p=productDao.getprbyid(id);
		mv1.addObject("pr",p);
		
		ArrayList<Review> l= new ArrayList<Review>();
		l=reviewDao.getrevbyprid(id);
		mv1.addObject("review",l);
		
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		return mv1;
	}*/
	
}
