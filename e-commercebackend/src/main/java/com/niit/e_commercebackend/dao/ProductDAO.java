package com.niit.e_commercebackend.dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.e_commercebackend.models.Product;


@SuppressWarnings("unused")
public interface ProductDAO {
	void saveProduct(Product p);
	public ArrayList<Product> getprbyid(int id);
}
