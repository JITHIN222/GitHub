package com.niit.e_commercebackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.models.Product;

@SuppressWarnings("unused")
@Repository
public class ProductDAOImpl implements ProductDAO
{
@Autowired
private SessionFactory sessionF;

	public ProductDAOImpl(SessionFactory sessionF) {

	this.sessionF = sessionF;
}
	

	public ProductDAOImpl() {
		super();
	}


	public void saveProduct(Product p) {
		System.out.println("in impl");
	Session session=sessionF.openSession();
	Transaction t=session.getTransaction();
	t.begin();
	session.save(p);
	t.commit();
	session.close();
	}


}