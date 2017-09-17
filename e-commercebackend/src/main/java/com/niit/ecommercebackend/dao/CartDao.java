package com.niit.ecommercebackend.dao;

import java.util.List;

import com.niit.ecommercebackend.models.Cart;

public interface CartDao {

	void saveProduct();
	List<Cart> getAllProducts();
	Cart getProductById();
}