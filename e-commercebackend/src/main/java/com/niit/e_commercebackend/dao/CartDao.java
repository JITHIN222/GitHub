package com.niit.e_commercebackend.dao;

import java.util.List;

import com.niit.e_commercebackend.models.Cart;

public interface CartDao {

	void saveProduct();
	List<Cart> getAllProducts();
	Cart getProductById();
}