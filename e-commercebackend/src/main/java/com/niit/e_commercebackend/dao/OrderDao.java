package com.niit.e_commercebackend.dao;


import java.util.ArrayList;

import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Order;

public interface OrderDao {
	public void saveOrder(Order o);
	public Order getorbyusername(String username);
	public ArrayList<Cart> getcartbyusernmae(String Username);
	public void updateOrder(Order o);
	public ArrayList<Order> getallundeliveredprods();
	public Order getorbyid(int id);
	public void deleteorder(Order o);
	
}
