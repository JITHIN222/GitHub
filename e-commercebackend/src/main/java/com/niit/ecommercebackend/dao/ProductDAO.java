package com.niit.ecommercebackend.dao;

import java.util.List;

import com.niit.ecommercebackend.models.Product;


public interface ProductDAO {
	void saveProduct();
	List<Product> getAllProducts();
	Product getProductById();
}
