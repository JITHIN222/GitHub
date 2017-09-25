package com.niit.e_commercebackend.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="SUPPLIER")
public class Supplier implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "NAME", nullable = false)
    private String name;
	

	   @OneToMany(targetEntity=Product.class, mappedBy="sid", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	   private Set<Product> prod;
	    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProd() {
		return prod;
	}

	public void setProd(Set<Product> prod) {
		this.prod = prod;
	}



}
