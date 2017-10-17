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
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.models.Category;
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
	
	
	/*admin page loading*/
	@RequestMapping("/admin/ad")
	public ModelAndView ad()
	{
		ModelAndView mv = new ModelAndView("add");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		ArrayList<Supplier> ss=(ArrayList<Supplier>)supplierDao.getallSupplier();
		mv.addObject("categ",cc);
		mv.addObject("catego",ss);
		mv.addObject("cate",cc);
		return mv;
		
	}
	
	@RequestMapping("/ad")
	public ModelAndView admin()
	{
		ModelAndView mv = new ModelAndView("redirect:/admin/ad");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		ArrayList<Supplier> ss=(ArrayList<Supplier>)supplierDao.getallSupplier();
		mv.addObject("categ",cc);
		mv.addObject("catego",ss);
		mv.addObject("cate",cc);
		return mv;
		
	}
	@RequestMapping("/admin")
	public ModelAndView index()
	{
	
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		ArrayList<Product> p=(ArrayList<Product>)productDao.getallProduct();
		mv1.addObject("off",p);
	    return mv1;
	}
	
	
}
