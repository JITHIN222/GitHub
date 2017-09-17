package com.niit.ecommercebackend.dao;

import java.util.List;

import com.niit.ecommercebackend.models.Supplier;
public interface SupplierDao {

	void saveProduct();
	List<Supplier> getAllProducts();
	Supplier getProductById();
}
