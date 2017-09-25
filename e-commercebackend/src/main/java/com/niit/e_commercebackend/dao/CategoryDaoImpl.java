package com.niit.e_commercebackend.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.models.Category;

@Repository
public class CategoryDaoImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionF;


	@Autowired
	public CategoryDaoImpl(SessionFactory sessionF){
		this.sessionF= sessionF;
	}

	public void saveCategory(Category c) {
		Session session=sessionF.openSession();
		Transaction t=session.getTransaction();
		t.begin();
		session.save(c);
		t.commit();
		session.close();
	}

	
	
}