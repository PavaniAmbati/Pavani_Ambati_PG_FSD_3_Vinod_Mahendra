package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salesitemtable")
public class SalesItemTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salesItemId;
	private Integer salesId;
	private Integer customerId;
	private Integer shoeId;
	private String shoename;
	private String category;
	private String brand;
	private String size;
	private String colour;
	private String gender;
	private Float price;
	private Integer quantity;
	private Float totalprice;
	@ManyToOne
	
	//relationship (many flight schedule is associated with one fight route)
	
	private SalesTable salestable;
	
	public SalesItemTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesItemTable(Integer salesItemId, Integer salesId, Integer customerId, Integer shoeId, String shoename,
			String category, String brand, String size, String colour, String gender, Float price, Integer quantity,
			Float totalprice) {
		super();
		this.salesItemId = salesItemId;
		this.salesId = salesId;
		this.customerId = customerId;
		this.shoeId = shoeId;
		this.shoename = shoename;
		this.category = category;
		this.brand = brand;
		this.size = size;
		this.colour = colour;
		this.gender = gender;
		this.price = price;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}

	public Integer getShoeId() {
		return shoeId;
	}
	public void setShoeId(Integer shoeId) {
		this.shoeId = shoeId;
	}
	public Integer getSalesItemId() {
		return salesItemId;
	}
	public void setSalesItemId(Integer salesItemId) {
		this.salesItemId = salesItemId;
	}
	public Integer getSalesId() {
		return salesId;
	}
	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getShoename() {
		return shoename;
	}
	public void setShoename(String shoename) {
		this.shoename = shoename;
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
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}
	
		
	public SalesTable getSalestable() {
		return salestable;
	}

	public void setSalestable(SalesTable salestable) {
		this.salestable = salestable;
	}

	@Override
	public String toString() {
		return "SalesItemTable [salesItemId=" + salesItemId + ", salesId=" + salesId + ", customerId=" + customerId
				+ ", shoeId=" + shoeId + ", shoename=" + shoename + ", category=" + category + ", brand=" + brand
				+ ", size=" + size + ", colour=" + colour + ", gender=" + gender + ", price=" + price + ", quantity="
				+ quantity + ", totalprice=" + totalprice + "]";
	}
	
	
	
	
}
