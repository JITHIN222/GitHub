package com.niit.e_commerce.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;

	@RequestMapping("/{categoryid}")
	public ModelAndView ca(@PathVariable("categoryid") int ca) {
		ArrayList<Product> p=new ArrayList<Product>();
		p=productDao.getprbycatid(ca);
		ModelAndView mv1 = new ModelAndView("ProductList");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		mv1.addObject("pro",p);
		return mv1;
		
	}

	
	/*adding category to db*/
	@RequestMapping("/admin/addC")
	public ModelAndView addC(@RequestParam("name") String name) {
		Category i=new Category();
		i.setName(name);
		categoryDao.saveCategory(i);
		ModelAndView mv1 = new ModelAndView("redirect:/admin/listcat?f=");	
		return mv1;
	}
	
	/*update button */
	@RequestMapping("/admin/updatec")
	public ModelAndView upca(@RequestParam("catid") int ca){
		ModelAndView mv= new ModelAndView("Categoryupdate");
		Category c= new Category();
		c=categoryDao.getcabyid(ca);
		mv.addObject("cat",c);
		return mv;
	}
	
	/*updating category to db*/
	@RequestMapping("/admin/upC")
	public ModelAndView upC(@RequestParam("n") int id, @RequestParam("name") String name) {
		Category i=new Category();
		i.setId(id);
		i.setName(name);
		categoryDao.updatecategory(i);
		
		ModelAndView mv1 = new ModelAndView("redirect:/admin/listcat?f=");
		return mv1;
	}
	
	/*deleting the category*/
	@RequestMapping("/admin/deletec")
	public String delcat(@RequestParam("catid") int ca){
		
		String c="";
		try{
		categoryDao.deletecategory(ca);
		c="success";
		
	}
		catch(Exception e){
			c="cannot delete category";
		}
		return "redirect:/admin/listcat?f="+c;
		
	}
	
	
	@RequestMapping("/admin/listcat")
	public ModelAndView listcat(@RequestParam("f") String ca){
		ArrayList<Category> p=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv = new ModelAndView("listcat");
		mv.addObject("listc",p);
		if(ca == " " ){
			mv.addObject("c"," ");
		}
		else{
			mv.addObject("c",ca);
		}
		return mv;
		
	}
	
}
