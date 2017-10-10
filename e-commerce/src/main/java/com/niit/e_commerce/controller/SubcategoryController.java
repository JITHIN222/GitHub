package com.niit.e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.SubcategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Subcategory;
import com.niit.e_commercebackend.models.Category;

public class SubcategoryController {

	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	SubcategoryDAO scategoryDao;
	
	
	
	
	/*adding subcategory to db*/
	@RequestMapping("/addSC")
	public ModelAndView addSC(@RequestParam("name") String name) {
		System.out.println("reaching subcategory name:"+name);
		Subcategory i=new Subcategory();
		i.setName(name);
		scategoryDao.saveSubcategory(i);
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cc);	
		return mv1;
	}
	
	
}
