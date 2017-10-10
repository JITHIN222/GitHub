package com.niit.e_commercebackend.models;




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
@Table(name="Cart")
public class Cart {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "ORDERID", nullable = false)
	private int orderid; 
	
	@Column(name = "QUANTITY", nullable = false)
	private int quantity;
	
	@Column(name = "PRICE", nullable = false)
	private int price;
	
	@Column(name = "PRODUCT_ID", nullable = false)
	private int productid;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@ManyToOne
    @JoinColumn(name="EMAIL",updatable=true,insertable=true,nullable=false)
    User uid;
	
	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

