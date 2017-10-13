package com.niit.e_commercebackend.daoImpl;


import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.dao.UserDao;
import com.niit.e_commercebackend.models.User;

@Repository
public class UserDaoImpl implements UserDao {
 
	@Autowired
	private SessionFactory sessionF;


	@Autowired
	public UserDaoImpl(SessionFactory sessionF){
		this.sessionF= sessionF;
	}

	public void saveProduct(User u) {
		Session session=sessionF.openSession();
		Transaction t=session.getTransaction();
		t.begin();
		session.save(u);
		t.commit();
		session.close();
	}
}
