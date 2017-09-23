package com.niit.e_commercebackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.models.Product;

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
	Session session=sessionF.openSession();
	Transaction t=session.getTransaction();
	t.begin();
	session.save(p);
	t.commit();
	session.close();
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductById() {
		// TODO Auto-generated method stub
		return null;
	}

}