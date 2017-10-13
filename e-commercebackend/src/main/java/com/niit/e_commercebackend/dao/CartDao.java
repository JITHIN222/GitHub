package com.niit.e_commercebackend.dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.e_commercebackend.models.Cart;

public interface CartDao {

	public void saveCart(Cart c);
	
	public ArrayList<Cart> getcartbyuserid(String Username);
}