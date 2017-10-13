package com.niit.e_commercebackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.dao.CartDao;
import com.niit.e_commercebackend.models.Cart;
import com.niit.e_commercebackend.models.Product;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionF;

	@Autowired
    public void ProductDAOImpl(SessionFactory sessionF) {

		this.sessionF = sessionF;
	}
		

	
	public void saveCart(Cart c) {
		Session session=sessionF.openSession();
		Transaction t=session.getTransaction();
		t.begin();
		session.save(c);
		t.commit();
		session.close();
		
	}

	public ArrayList<Cart> getcartbyuserid(String Username) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Cart where USERNAME='"+Username+"'");
		ArrayList<Cart> cat=(ArrayList<Cart>)q.list();

        t.commit();
        s.close();
		return cat;
	}

	public Cart getProductById() {
		// TODO Auto-generated method stub
		return null;
	}
}
