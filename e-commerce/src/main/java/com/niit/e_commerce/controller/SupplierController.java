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
import com.niit.e_commercebackend.models.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;

	/*deleting the supplier*/
	@RequestMapping("/admin/deletes")
	public ModelAndView delsup(@RequestParam("supid") int ca){
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("add");
		mv.addObject("cate",cat);
		supplierDao.deletesupplier(ca);
		return mv;
	}
	
	
	/*listing all suppliers*/
	@RequestMapping("/admin/listsup")
	public ModelAndView listsup(){
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv = new ModelAndView("listsup");
		ArrayList<Supplier> p=(ArrayList<Supplier>)supplierDao.getallSupplier();
		mv.addObject("cate",cat);
		mv.addObject("lists",p);
		return mv;
		
	}
	
	
	/*updating the supplier*/
	@RequestMapping("/admin/updates")
	public ModelAndView upS(@RequestParam("supid") int ca){
		System.err.println("reachinginnnn"+ca);
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("Supplierupdate");
		mv.addObject("cate",cat);
		Supplier c= new Supplier();
		c=supplierDao.getssbyid(ca);
		mv.addObject("sup",c);
		return mv;
	}
	

	/*adding supplier to db*/
	@RequestMapping("/admin/addS")
	public ModelAndView addS(@RequestParam("name") String name) {
		Supplier i=new Supplier();
		i.setName(name);
		supplierDao.saveSupplier(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cc);
		return mv1;
	}
	
}
