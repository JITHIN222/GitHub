package com.niit.e_commercebackend.dao;

import java.util.List;

import com.niit.e_commercebackend.models.Login;
public interface LoginDao {

	void saveProduct();
	List<Login> getAllProducts();
	Login getProductById();
}
