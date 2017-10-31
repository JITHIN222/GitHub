package com.niit.e_commercebackend.daoImpl;


import org.hibernate.Transaction;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.dao.UserDao;
import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Supplier;
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
	
	public ArrayList<User> getuserbyusername(String Username){

		ArrayList<User> su=new ArrayList<User>();
		
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from User where EMAIL='"+Username+"'");
		su=(ArrayList<User>) q.list();
        t.commit();
        s.close();
		return su;
	}
	
public ArrayList<User> getalluser() {
		
		Session ssn=sessionF.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Query q= ssn.createQuery("from User");
		ArrayList<User> l=(ArrayList<User>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
		
	}
}
