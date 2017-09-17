package com.niit.ecommercebackend.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ADMIN")
public class Admin {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	 @Column(name = "DTYPE", nullable = false)
	    private String dtype;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

}

