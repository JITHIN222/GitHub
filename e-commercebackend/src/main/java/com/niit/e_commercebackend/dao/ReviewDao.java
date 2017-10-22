package com.niit.e_commercebackend.dao;


import java.util.ArrayList;

import com.niit.e_commercebackend.models.Review;

public interface ReviewDao {
	
	public void saveReview(Review r);
	
	public ArrayList<Review> getrevbyprid(int id);
}
