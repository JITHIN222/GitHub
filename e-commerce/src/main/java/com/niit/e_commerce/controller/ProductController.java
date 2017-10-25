package com.niit.e_commerce.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.e_commercebackend.dao.CategoryDAO;
import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.dao.ReviewDao;
import com.niit.e_commercebackend.dao.SupplierDao;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;
import com.niit.e_commercebackend.models.Review;
import com.niit.e_commercebackend.models.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	/*adding product to db*/
	@RequestMapping("/admin/addP")
	public ModelAndView addP(@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("stock") int stock,
			@RequestParam("img") MultipartFile file, @RequestParam("img1") MultipartFile file1,
			@RequestParam("img2") MultipartFile file2, @RequestParam("img3") MultipartFile file3, 
			@RequestParam("short") String shortDesc, @RequestParam("cat") int ca, @RequestParam("sid") int ss  ) {
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
		
		String img=file.getOriginalFilename();
	    i.setImg(img);
		 String filepath ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file.getOriginalFilename();
		 try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
				fos.write(imagebyte);
				fos.close();
				} catch (IOException e) {
				e.printStackTrace();}
		 
		 String img1=file1.getOriginalFilename();
		    i.setImg1(img1);
			 String filepath1 ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file1.getOriginalFilename();
			 try {
					byte imagebyte[] = file1.getBytes();
					BufferedOutputStream fos1 = new BufferedOutputStream(new FileOutputStream(filepath1));
					fos1.write(imagebyte);
					fos1.close();
					} catch (IOException e) {
					e.printStackTrace();}
			 
			 String img2=file2.getOriginalFilename();
			    i.setImg2(img2);
				 String filepath2 ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file2.getOriginalFilename();
				 try {
						byte imagebyte[] = file2.getBytes();
						BufferedOutputStream fos2 = new BufferedOutputStream(new FileOutputStream(filepath2));
						fos2.write(imagebyte);
						fos2.close();
						} catch (IOException e) {
						e.printStackTrace();}
				 
				 String img3=file3.getOriginalFilename();
				    i.setImg3(img3);
					 String filepath3 ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file3.getOriginalFilename();
					 try {
							byte imagebyte[] = file3.getBytes();
							BufferedOutputStream fos3 = new BufferedOutputStream(new FileOutputStream(filepath3));
							fos3.write(imagebyte);
							fos3.close();
							} catch (IOException e) {
							e.printStackTrace();}
					 
		productDao.saveProduct(i);
		
		ModelAndView mv1 = new ModelAndView("redirect:/admin/listpro?f=");
		
		return mv1;
	}
	
	/*redirecting to product update page*/
	@RequestMapping("/admin/updatep")
	public ModelAndView uppr(@RequestParam("prid") int ca){
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		ModelAndView mv= new ModelAndView("Productupdate");
		ArrayList<Supplier> ss=(ArrayList<Supplier>)supplierDao.getallSupplier();
		mv.addObject("sup",ss);     /*dropdown supplier inside product update*/
		mv.addObject("categ",cat); /*dropdown category inside product update*/
		Product p= new Product();
		p=productDao.getprbyid(ca);
		mv.addObject("pr",p);   /*product details obtained using id*/
		return mv;
	}
	
	/*deleting the product*/
	@RequestMapping("/admin/deletep")
	public String delpro(@RequestParam("prid") int ca){
		
		String c="";
		try{
		productDao.deleteproduct(ca);
        c="success";
		}
		catch(Exception e){
			c="product might added by any user";
			}
		return "redirect:/admin/listpro?f="+c;
	}
	
	/*updating product to db*/
	@RequestMapping("/admin/upP")
	public ModelAndView update(@RequestParam("id") int id,@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("stock") int stock,
			@RequestParam("img") MultipartFile file, @RequestParam("img1") MultipartFile file1,
			@RequestParam("img2") MultipartFile file2, @RequestParam("img3") MultipartFile file3, 
			@RequestParam("short") String shortDesc, @RequestParam("cat") int ca, @RequestParam("sid") int ss  ) {
		
		Product i=productDao.getprbyid(id);
		i.setId(id);
		i.setName(name);
		i.setPrice(price);
		i.setStock(stock);
		i.setShortDesc(shortDesc);
		
		Category cc=new Category();
		cc=categoryDao.getcabyid(ca);
		i.setCid(cc);
		
		Supplier su=new Supplier();
		su=supplierDao.getssbyid(ss);
		i.setSid(su);
	
		if(file.getOriginalFilename()!="" || file1.getOriginalFilename()!="" || file2.getOriginalFilename()!="" || file3.getOriginalFilename()!="")
		{
			String img=file.getOriginalFilename();
	    i.setImg(img);
	    
		 String filepath ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file.getOriginalFilename();
		 try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
				fos.write(imagebyte);
				fos.close();
				} catch (IOException e) {
				e.printStackTrace();}
		 
		 String img1=file1.getOriginalFilename();
		    i.setImg1(img1);
		    
			 String filepath1 ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file1.getOriginalFilename();
			 try {
					byte imagebyte[] = file1.getBytes();
					BufferedOutputStream fos1 = new BufferedOutputStream(new FileOutputStream(filepath1));
					fos1.write(imagebyte);
					fos1.close();
					} catch (IOException e) {
					e.printStackTrace();}
			 
			 String img2=file2.getOriginalFilename();
			    i.setImg2(img2);
			    
				 String filepath2 ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file2.getOriginalFilename();
				 try {
						byte imagebyte[] = file2.getBytes();
						BufferedOutputStream fos2 = new BufferedOutputStream(new FileOutputStream(filepath2));
						fos2.write(imagebyte);
						fos2.close();
						} catch (IOException e) {
					e.printStackTrace();}	
				 
				 String img3=file3.getOriginalFilename();
				    i.setImg3(img3);
				    
					 String filepath3 ="C:/Users/Jithin Shaji/workspace/e-commerce/src/main/webapp/resources/Productimage/" + file3.getOriginalFilename();
					 try {
							byte imagebyte[] = file3.getBytes();
							BufferedOutputStream fos3 = new BufferedOutputStream(new FileOutputStream(filepath3));
							fos3.write(imagebyte);
							fos3.close();
							} catch (IOException e) {
							e.printStackTrace();}
		}
		productDao.updateproduct(i);
		
		ModelAndView mv1 = new ModelAndView("redirect:/admin/listpro?f=");
		return mv1;
	}
	
	/*listing product*/
	@RequestMapping("/admin/listpro")
	public ModelAndView listpro(@RequestParam("f") String ca){
		ArrayList<Product> p=(ArrayList<Product>)productDao.getallProduct();
		ModelAndView mv = new ModelAndView("listpro");
		mv.addObject("listp",p);
		if(ca == " " ){
			mv.addObject("c"," ");
		}
		else{
			mv.addObject("c",ca);
		}
		return mv;
		
	}
	
	/*single product*/
	@RequestMapping("/product")
	public ModelAndView product(@RequestParam("id") int id){
		Product p=new Product();
		p=productDao.getprbyid(id);
		ModelAndView mv = new ModelAndView("Product");
		mv.addObject("pr",p);
		ArrayList<Category> cat=(ArrayList<Category>)categoryDao.getallCategories();
		mv.addObject("cate",cat);
		ArrayList<Review> l= new ArrayList<Review>();
		l=reviewDao.getrevbyprid(id);
		mv.addObject("review",l);
		return mv;
		
	}

}
