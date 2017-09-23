package com.niit.e_commercebackend.dao;

import java.util.List;

import com.niit.e_commercebackend.models.Category;


public interface CategoryDAO {
	public void saveCategory(Category c);
	List<Category> getAllProducts();
	Category getProductById();
}