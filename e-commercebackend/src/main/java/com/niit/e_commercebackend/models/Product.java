package com.niit.e_commercebackend.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @Column(name = "IMG", nullable = false)
    private String img;
    
    @Column(name = "IMG1", nullable = false)
    private String img1;
    
    @Column(name = "IMG2", nullable = false)
    private String img2;
    
    @Column(name = "IMG3", nullable = false)
    private String img3;
    
    @Column(name = "OFFER", nullable =false)
    private int offer;
    
	@Column(name = "OFFERAMOUNT", nullable =false)
    private int offerprice;
	
	@Column(name = "OFFERPER", nullable =false)
    private int offerper;
	
	@OneToMany(targetEntity=Cart.class, mappedBy="pid", fetch=FetchType.EAGER)
    private Set<Cart> cart;
	
	public int getOfferper() {
		return offerper;
	}

	public void setOfferper(int offerper) {
		this.offerper = offerper;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public int getOfferprice() {
		return offerprice;
	}

	public void setOfferprice(int offerprice) {
		this.offerprice = offerprice;
	}

    
	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

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


