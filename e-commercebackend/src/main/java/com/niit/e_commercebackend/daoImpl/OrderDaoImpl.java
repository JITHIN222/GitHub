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
		int size= q.list().size();
		Order or=(Order)q.list().get(size-1);	
        t.commit();
        s.close();
		return or;
	}
	
	public ArrayList<Cart> getcartbyusernmae(String Username) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Cart where USERNAME='"+Username+"'");
		ArrayList<Cart> cat=(ArrayList<Cart>)q.list();

        t.commit();
        s.close();
		return cat;
	}
	
	public void updateOrder(Order o){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.update(o);
        t.commit();
        s.close();
	}
	
	public ArrayList<Order> getallundeliveredprods(){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		org.hibernate.Query q= s.createQuery("from Order where DELIVER="+0);
		ArrayList<Order> l=(ArrayList<Order>) q.list();
		
	    t.commit();
	    s.close();
		
		
		return l;
	}
	
	public Order getorbyid(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Order l = (Order) s.get(Order.class, id);
        t.commit();
        s.close();
		return l;
	}

	public void deleteorder(Order o){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.delete(o);
        t.commit();
        s.close();
	}

}
