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
		System.out.println("in controller"+name);
		
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
		System.out.println("in contoller"+ca);
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
		System.out.println("in controller");
		System.out.println(name);
		Supplier i=new Supplier();
		i.setName(name);
		supplierDao.saveSupplier(i);
		
		ModelAndView mv1 = new ModelAndView("index");
		ArrayList<Category> cc=(ArrayList<Category>)categoryDao.getallCategories();
		mv1.addObject("cate",cc);
		return mv1;
	}
	
	/*adding product to db*/
	@RequestMapping("/addP")
	public ModelAndView addP(@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("stock") int stock, @RequestParam("short") String shortDesc, @RequestParam("cat") int ca, @RequestParam("sid") int ss  ) {
		System.out.println("in controller");
		System.out.println(name);
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
	@RequestMapping("/{prid}")
	public ModelAndView delpro(@PathVariable("prid") int ca){
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("list");
		mv.addObject("cate",cat);
		productDao.deleteproduct(ca);
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
	
	
}
