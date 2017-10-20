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


	public void saveProduct(Product p) 
	{
	Session session=sessionF.openSession();
	Transaction t=session.getTransaction();
	t.begin();
	session.save(p);
	t.commit();
	session.close();
	}

	public ArrayList<Product> getprbycatid(int id)
	{
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
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Product");
		ArrayList<Product> pr=(ArrayList<Product>)q.list();
		t.commit();
		s.close();
		
			return pr;		
	}
	
	public void deleteproduct(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Product p = (Product) s.get(Product.class, id);
		s.delete(p);
        t.commit();
        s.close();
        
		
	}
	
	public void updateproduct(Product id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.update(id);
        t.commit();
        s.close();
	}
	
	public Product getprbyid(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Product ca = (Product) s.get(Product.class, id);
        t.commit();
        
        s.close();
		
		return ca;
	}
	
	public ArrayList<Product> offerlist() {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();		
		Query q= s.createQuery("from Product where offer="+1);
		ArrayList<Product> l=(ArrayList<Product>) q.list();
        t.commit();        
        s.close();
        return l;
		
	}
	
	public void setoffers(int id,int offpr,int actp) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		int per=100-(100*offpr/actp);
		 Query o = s.createQuery("update Product  set offer="+1+"where id="+id);
		 Query o1 = s.createQuery("update Product  set offerprice="+offpr+"where id="+id);
		 Query o2 = s.createQuery("update Product  set offerper="+per+"where id="+id); 
		 o.executeUpdate();	
		 o1.executeUpdate();
		 o2.executeUpdate();
        t.commit();       
        s.close();
		
	}
	
	public void deleteoffer(int id) 
	{
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		 Query o = s.createQuery("update Product  set offer="+0+"where id="+id);
		 Query o1 = s.createQuery("update Product  set offerprice="+0+"where id="+id); 
		 o.executeUpdate(); 
         o1.executeUpdate();
        t.commit();
        s.close();
	}

}