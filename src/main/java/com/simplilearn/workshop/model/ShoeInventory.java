package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shoe_inventory")
public class ShoeInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shoeid;
	
	@NotBlank (message = "Shoe name cannot be empty")
	private String shoename;
	
	@NotBlank (message = "Shoe description cannot be empty")
	private String shoedescription;
	//private Integer categoryid;
	@NotBlank (message = "Category cannot be empty")
	private String category;
	//private Integer brandid;
	@NotBlank (message = "Brand cannot be empty")
	private String brand;
	
	@NotBlank (message = "Size cannot be empty")
	private String size;
	
	@NotBlank (message = "Colour cannot be empty")
	private String colour;
	
	@NotBlank (message = "Gender cannot be empty")
	private String gender;
	
	@NotNull (message = "Price cannot be empty")
	private Float price;
	//private String image;
	
	public ShoeInventory() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public ShoeInventory(Integer shoeid, String shoename, String shoedescription, Integer categoryid, String category,
			Integer brandid, String brand, String size, String colour, String gender, Float price) {
		super();
		this.shoeid = shoeid;
		this.shoename = shoename;
		this.shoedescription = shoedescription;
		//this.categoryid = categoryid;
		this.category = category;
		//this.brandid = brandid;
		this.brand = brand;
		this.size = size;
		this.colour = colour;
		this.gender = gender;
		this.price = price;
		//this.image = image;
	}
	

	public Integer getShoeid() {
		return shoeid;
	}

	public void setShoeid(Integer shoeid) {
		this.shoeid = shoeid;
	}
	public String getShoename() {
		return shoename;
	}
	public void setShoename(String shoename) {
		this.shoename = shoename;
	}
	public String getShoedescription() {
		return shoedescription;
	}
	public void setShoedescription(String shoedescription) {
		this.shoedescription = shoedescription;
	}
	/*public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid; 
	}*/
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	/*public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}*/
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
	//public String getImage() {
	//	return image;
	//}
	//public void setImage(String image) {
	//	this.image = image;
	//}

	@Override
	public String toString() {
		return "ShoeInventory [shoeid=" + shoeid + ", shoename=" + shoename + ", shoedescription=" + shoedescription
				+ ", category=" + category + ", brand=" + brand + ", size=" + size + ", colour=" + colour + ", gender="
				+ gender + ", price=" + price + "]";
	}
	
	

}
