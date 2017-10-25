package com.niit.e_commercebackend.daoImpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.e_commercebackend.dao.ReviewDao;
import com.niit.e_commercebackend.models.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	@Autowired
	private SessionFactory sessionF;


	@Autowired
	public ReviewDaoImpl(SessionFactory sessionF){
		this.sessionF= sessionF;
	}
	
	public void saveReview(Review r){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.save(r);
		t.commit();
		s.close();
	}
	
	public ArrayList<Review> getrevbyprid(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q= s.createQuery("from Review where PRID="+id);
		ArrayList<Review> l=(ArrayList<Review>) q.list();
        t.commit();
        s.close();
        return l;
	}

}
