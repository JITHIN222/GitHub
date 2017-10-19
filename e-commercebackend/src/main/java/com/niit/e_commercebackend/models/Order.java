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

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getBill() {
		return bill;
	}
	
	@Column(name = "SHIPPING_ADDRESS", nullable = false)
	private String ship;

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}
	
	
	

}
