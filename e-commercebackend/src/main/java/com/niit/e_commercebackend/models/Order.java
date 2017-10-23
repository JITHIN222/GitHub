package com.niit.e_commercebackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Orders")
public class Order {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "BILL_ADDRESS", nullable = false)
	private String bill;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getBill() {
		return bill;
	}
	
	@Column(name = "SHIPPING_ADDRESS", nullable = false)
	private String ship;

	@Column(name = "DELIVER", nullable = false)
     private int deliver;
	
	public int getDeliver() {
		return deliver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDeliver(int deliver) {
		this.deliver = deliver;
	}

	@Column(name = "ORDER_DETAILS", nullable = false)
	private String order_detail;
	
	public String getOrder_detail() {
		return order_detail;
	}

	public void setOrder_detail(String order_detail) {
		this.order_detail = order_detail;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}
	
	
	

}
