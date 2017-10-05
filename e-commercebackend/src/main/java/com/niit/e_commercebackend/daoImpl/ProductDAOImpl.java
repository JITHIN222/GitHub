package com.niit.e_commercebackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.dao.ProductDAO;
import com.niit.e_commercebackend.models.Category;
import com.niit.e_commercebackend.models.Product;
import com.niit.e_commercebackend.models.Supplier;

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

	public ArrayList<Product> getprbycatid(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Product where cid="+id);
		ArrayList<Product> cat=(ArrayList<Product>)q.list();

        t.commit();
        s.close();
		return cat;
	}
	
	public ArrayList<Product> getallProduct(){
		System.out.println("impl reaching");
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Product");
		ArrayList<Product> pr=(ArrayList<Product>)q.list();
		System.out.println("retrieved");
		t.commit();
		s.close();
		
			return pr;		
	}
	
	public Product deleteproduct(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Product p = (Product) s.get(Product.class, id);
		s.delete(p);
        t.commit();
        s.close();
        return p;
		
	}

}