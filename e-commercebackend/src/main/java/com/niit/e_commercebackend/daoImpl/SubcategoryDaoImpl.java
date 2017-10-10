
package com.niit.e_commercebackend.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.models.Subcategory;
import com.niit.e_commercebackend.dao.SubcategoryDAO;

@Repository
public class SubcategoryDaoImpl implements SubcategoryDAO{

	@Autowired
	private SessionFactory sessionF;
	
	@Autowired
	public SubcategoryDaoImpl(SessionFactory sessionF){
		this.sessionF= sessionF;
	}
	public void saveSubcategory(Subcategory c) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.save(c);
		t.commit();
		s.close();
	}
	
}
