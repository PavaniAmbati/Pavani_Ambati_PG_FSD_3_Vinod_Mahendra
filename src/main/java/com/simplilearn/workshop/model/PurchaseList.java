package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseid;
	private int custid;
	private int salesid;
	private int salesitemid;
	private String firstname;
	private String lastname;
	private String category;
	private String brand;
	private String shoename;
	private String paymentMethod;
	private Float price;
	private int quantity;
	private Float totalprice;
	
	public PurchaseList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PurchaseList(int purchaseid, int custid, int salesid, int salesitemid, String firstname, String lastname,
			String category, String brand, String shoename, String paymentMethod, Float price, int quantity,
			Float totalprice) {
		super();
		this.purchaseid = purchaseid;
		this.custid = custid;
		this.salesid = salesid;
		this.salesitemid = salesitemid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.category = category;
		this.brand = brand;
		this.shoename = shoename;
		this.paymentMethod = paymentMethod;
		this.price = price;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}


	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}

	public int getCustid() {
		return custid;
	}


	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public int getSalesitemid() {
		return salesitemid;
	}

	public void setSalesitemid(int salesitemid) {
		this.salesitemid = salesitemid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getShoename() {
		return shoename;
	}
	public void setShoename(String shoename) {
		this.shoename = shoename;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public Float getTotalprice() {
		return totalprice;
	}




	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}




	@Override
	public String toString() {
		return "PurchaseList [purchaseid=" + purchaseid + ", custid=" + custid + ", salesid=" + salesid
				+ ", salesitemid=" + salesitemid + ", firstname=" + firstname + ", lastname=" + lastname + ", category="
				+ category + ", brand=" + brand + ", shoename=" + shoename + ", paymentMethod=" + paymentMethod
				+ ", price=" + price + ", quantity=" + quantity + ", totalprice=" + totalprice + "]";
	}
	
	
	
	

}
