package com.niit.e_commercebackend.daoImpl;


import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.dao.CategoryDAO;
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
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.save(c);
		t.commit();
		s.close();
	}
	
	public ArrayList<Category> getallCategories(){
		System.out.println("impl reaching");
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Category");
		ArrayList<Category> cat=(ArrayList<Category>)q.list();
		System.out.println("retrieved");
		for(Category c:cat)
		{
			System.out.println(c);
		}
		t.commit();
		s.close();
		
			return cat;		
	}
	
	public Category getcabyid(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Category ca = (Category) s.get(Category.class, id);
System.out.println(ca.getName()+ca.getId());
		
        t.commit();
        
        s.close();
		
		return ca;
	}

	public void deletecategory(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Category p = (Category) s.get(Category.class, id);
		s.delete(p);
        t.commit();
        s.close();
        
		
	}
	
	public void updatecategory(Category id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.update(id);
        t.commit();
        s.close();
	}
	
	
}