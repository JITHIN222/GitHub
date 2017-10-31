package com.niit.e_commercebackend.dao;


import java.util.ArrayList;

import com.niit.e_commercebackend.models.User;


public interface UserDao {

	public void saveProduct(User u);
	public ArrayList<User> getuserbyusername(String Username);
	public ArrayList<User> getalluser();
	
}
