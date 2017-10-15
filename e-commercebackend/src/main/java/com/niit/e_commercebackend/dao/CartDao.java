package com.niit.e_commercebackend.dao;

import java.util.ArrayList;


import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Product;

public interface CartDao {

	public void saveCart(Cart c);
	
	public ArrayList<Cart> getcartbyusernmae(String Username);
	public Product getprbyid(int id);
	public Cart getcartbyid(int id);
	public void updatequantity(int cartid, int quantity);
	public void deletecart(int id);
	public void updatecart(Cart id);
}