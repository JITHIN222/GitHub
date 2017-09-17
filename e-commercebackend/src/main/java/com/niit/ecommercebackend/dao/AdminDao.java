package com.niit.ecommercebackend.dao;

import java.util.List;

import com.niit.ecommercebackend.models.Admin;

public interface AdminDao {

	void saveProduct();
	List<Admin> getAllProducts();
	Admin getProductById();
}
