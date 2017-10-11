package com.niit.e_commercebackend.dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.e_commercebackend.models.Product;


@SuppressWarnings("unused")
public interface ProductDAO {
	public void saveProduct(Product p);
	public ArrayList<Product> getprbycatid(int id);
	public ArrayList<Product> getallProduct();
	public void deleteproduct(int id); 
	public void updateproduct(Product id);
	public Product getprbyid(int id);
	public ArrayList<Product> offerlist();
	public void setoffers(int id,int offpr,int actp);
	public void deleteoffer(int id);
}
