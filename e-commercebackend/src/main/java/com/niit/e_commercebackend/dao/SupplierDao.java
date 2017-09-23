package com.niit.e_commercebackend.dao;

import java.util.List;

import com.niit.e_commercebackend.models.Supplier;
public interface SupplierDao {

	void saveProduct();
	List<Supplier> getAllProducts();
	Supplier getProductById();
}
