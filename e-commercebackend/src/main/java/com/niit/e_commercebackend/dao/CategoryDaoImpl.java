package com.niit.e_commercebackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.models.Category;

@Repository
public class CategoryDaoImpl implements CategoryDAO{
	
	@Autowired
	public CategoryDaoImpl (SessionFactory sessionF)
	{
		super();
	}
	
	public void saveProduct() {
		
		
	}

	public List<Category> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getProductById() {
		// TODO Auto-generated method stub
		return null;
	}

}