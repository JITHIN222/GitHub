package com.niit.e_commercebackend.models;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Cart")
public class Cart {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

