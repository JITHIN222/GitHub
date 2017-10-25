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
	public String delsup(@RequestParam("supid") int ca){
		String c="";
		try{
		supplierDao.deletesupplier(ca);
		c="Successfully deleted";
		
		}
		catch(Exception e){
			c="Cannot delete supplier";	
			}
		return "redirect:/admin/listsup?f="+c;
	}
	
	
	/*listing all suppliers*/
	@RequestMapping("/admin/listsup")
	public ModelAndView listsup(@RequestParam("f") String ca){
		ModelAndView mv = new ModelAndView("listsup");
		ArrayList<Supplier> p=(ArrayList<Supplier>)supplierDao.getallSupplier();
		mv.addObject("lists",p);
		if(ca == " " ){
			mv.addObject("c"," ");
		}
		else{
			mv.addObject("c",ca);
		}
		return mv;
		
	}
	
	
	/*updating the supplier*/
	@RequestMapping("/admin/updates")
	public ModelAndView upS(@RequestParam("supid") int ca){
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
	public ModelAndView addS(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("mob") long mob) {
		Supplier i=new Supplier();
		i.setName(name);
		i.setEmail(email);
		i.setMob(mob);
		supplierDao.saveSupplier(i);
		
		ModelAndView mv1 = new ModelAndView("redirect:/admin/listsup?f=");
	
		return mv1;
	}
	
	@RequestMapping("/admin/upS")
	public ModelAndView upS(@RequestParam("n") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("mob") long mob ) {
		Supplier i=new Supplier();
		i.setId(id);
		i.setName(name);
		i.setEmail(email);
		i.setMob(mob);
		supplierDao.updatesupplier(i);
		
		ModelAndView mv1 = new ModelAndView("redirect:/admin/listsup?f=");
		
		return mv1;
	}
	
}
