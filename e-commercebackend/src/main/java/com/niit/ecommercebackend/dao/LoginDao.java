package com.niit.ecommercebackend.dao;

import java.util.List;

import com.niit.ecommercebackend.models.Login;
public interface LoginDao {

	void saveProduct();
	List<Login> getAllProducts();
	Login getProductById();
}
