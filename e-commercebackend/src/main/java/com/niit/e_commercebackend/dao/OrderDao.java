package com.niit.e_commercebackend.dao;


import com.niit.e_commercebackend.models.Order;

public interface OrderDao {
	public void saveOrder(Order o);
	public Order getorbyusername(String username);
	
}
