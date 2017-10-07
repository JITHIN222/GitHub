package com.niit.e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;
import com.niit.e_commercebackend.models.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;
	
	/*adding product to db*/
	@RequestMapping("/addP")
	public ModelAndView addP(@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("stock") int stock, @RequestParam("short") String shortDesc, @RequestParam("cat") int ca, @RequestParam("sid") int ss  ) {
		Product i=new Product();
		i.setName(name);
		i.setPrice(price);
		i.setStock(stock);
		i.setShortDesc(shortDesc);
		
		Category cc=new Category();
		cc=categoryDao.getcabyid(ca);
		
		Supplier su=new Supplier();
		su=supplierDao.getssbyid(ss);
		
		i.setCid(cc);
		i.setSid(su);
		productDao.saveProduct(i);
		
		ModelAndView mv1 = new ModelAndView("add");
		
		/*display category dropdown in navbar*/
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		return mv1;
	}
	
	/*deleting the product*/
	@RequestMapping("/deletep")
	public ModelAndView delpro(@RequestParam("prid") int ca){
		System.err.println("reaching"+ca);
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("add");
		mv.addObject("cate",cat);
		productDao.deleteproduct(ca);
		return mv;
	}
	
	/*adding product to db*/
	@RequestMapping("/upP")
	public ModelAndView upP(@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("stock") int stock, @RequestParam("short") String shortDesc, @RequestParam("cat") int ca, @RequestParam("sid") int ss  ) {
		System.out.println("reaching innnnn"+name);
		Product i=new Product();
		i.setName(name);
		i.setPrice(price);
		i.setStock(stock);
		i.setShortDesc(shortDesc);
		
		Category cc=new Category();
		cc=categoryDao.getcabyid(ca);
		
		Supplier su=new Supplier();
		su=supplierDao.getssbyid(ss);
		
		i.setCid(cc);
		i.setSid(su);
		productDao.updateproduct(i);
		
		ModelAndView mv1 = new ModelAndView("add");
		
		/*display category dropdown in navbar*/
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		return mv1;
	}

}
