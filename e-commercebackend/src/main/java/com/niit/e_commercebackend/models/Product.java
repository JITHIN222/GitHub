package com.niit.e_commercebackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="PRODUCTS")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Column(name = "SHORT_DESCRIPTION", nullable = false)
    private String shortDesc;
    
    @Column(name = "PRICE", nullable = false)
    private int price;
    
    @Column(name = "STOCK", nullable = false)
    private int stock;

	@ManyToOne
    @JoinColumn(name="C_ID",updatable=true,insertable=true,nullable=false)
    Category cid;
    
    @ManyToOne
    @JoinColumn(name="S_ID",updatable=true,insertable=true,nullable=false)
    Supplier sid;
    
	public Category getCid() {
		return cid;
	}

	public void setCid(Category cid) {
		this.cid = cid;
	}

	public Supplier getSid() {
		return sid;
	}

	public void setSid(Supplier sid) {
		this.sid = sid;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	 public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}
}


