package com.niit.e_commercebackend.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.dao.OrderDao;
import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionF;

	@Autowired
    public OrderDaoImpl(SessionFactory sessionF) {

		this.sessionF = sessionF;
	}
	
	public void saveOrder(Order o){
		Session session=sessionF.openSession();
		Transaction t=session.getTransaction();
		t.begin();
		session.save(o);
		t.commit();
		session.close();
	
	}
	
	public Order getorbyusername(String username){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Order where USERNAME='"+username+"'");
		Order or=(Order)q.list().get(0);

        t.commit();
        s.close();
		return or;
	}
}
