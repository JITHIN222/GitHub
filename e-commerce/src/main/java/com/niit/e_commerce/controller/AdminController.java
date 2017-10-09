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
	
	/*<----category session--->
	*//*adding category to db*/
	@RequestMapping("/addC")
	public ModelAndView addC(@RequestParam("name") String name) {
		Category i=new Category();
		i.setName(name);
		categoryDao.saveCategory(i);
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cc);	
		return mv1;
	}
	
	@RequestMapping("/{categoryid}")
	public ModelAndView ca(@PathVariable("categoryid") int ca) {
		ArrayList<Product> p=new ArrayList<Product>();
		p=productDao.getprbycatid(ca);
		
		ModelAndView mv1 = new ModelAndView("ProductList");
		mv1.addObject("pro",p);
		
		ArrayList<Category> l=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",l);
	
		
		return mv1;
		
	}
	
	/*adding subcategory to db*/
/*	@RequestMapping("/addSC")
	public ModelAndView addSC(@RequestParam("name") String name, @RequestParam("cat") String ca) {
		System.out.println("in controller"+name);
		
		Category i=new Category();
		i.setName(name);
		Category c=new Category();
		c=categoryDao.getcabyid(ca);
		categoryDao.saveCategory(i);
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cc);	
		return mv1;
	}*/
	
	

/*	adding supplier to db*/
	@RequestMapping("/addS")
	public ModelAndView addS(@RequestParam("name") String name) {
		Supplier i=new Supplier();
		i.setName(name);
		supplierDao.saveSupplier(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cc);
		return mv1;
	}
	

	/*updating the category*/
	@RequestMapping("/updatec")
	public ModelAndView upca(@RequestParam("catid") int ca){
		System.err.println("reachinginnnn"+ca);
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("Categoryupdate");
		mv.addObject("cate",cat);
		Category c= new Category();
		c=categoryDao.getcabyid(ca);
		System.out.println(c);
		mv.addObject("cat",c);
		return mv;
	}
	
	/*deleting the category*/
	@RequestMapping("/deletec")
	public ModelAndView delcat(@RequestParam("catid") int ca){
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("add");
		mv.addObject("cate",cat);
		categoryDao.deletecategory(ca);
		return mv;
	}
	
	/*deleting the supplier*/
	@RequestMapping("/deletes")
	public ModelAndView delsup(@RequestParam("supid") int ca){
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("add");
		mv.addObject("cate",cat);
		supplierDao.deletesupplier(ca);
		return mv;
	}
	
	
	/*listing product,category & supplier*/
	@RequestMapping("/listpro")
	public ModelAndView listpro(){
		ArrayList<Product> p=(ArrayList<Product>)productDao.getallProduct();
		ModelAndView mv = new ModelAndView("list");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cat);
		mv.addObject("listp",p);
		return mv;
		
	}
	
	@RequestMapping("/listcat")
	public ModelAndView listcat(){
		ArrayList<Category> p=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv = new ModelAndView("list");
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cat);
		mv.addObject("listc",p);
		return mv;
		
	}
	
	@RequestMapping("/listsup")
	public ModelAndView listsup(){
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv = new ModelAndView("list");
		ArrayList<Supplier> p=(ArrayList<Supplier>)supplierDao.getallSupplier();
		mv.addObject("cate",cat);
		mv.addObject("lists",p);
		return mv;
		
	}
	
	/*updating category to db*/
	@RequestMapping("/upC")
	public ModelAndView upC(@RequestParam("name") String name) {
		System.out.println("reaching innnnn"+name);
		Category i=new Category();
		i.setName(name);
		categoryDao.updatecategory(i);
		
		ModelAndView mv1 = new ModelAndView("add");
		
		/*display category dropdown in navbar*/
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cat);
		return mv1;
	}
	
	/*updating the supplier*/
	@RequestMapping("/updates")
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
	
	
}
