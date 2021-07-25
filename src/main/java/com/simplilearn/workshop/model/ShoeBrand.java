package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "shoe_brand")
public class ShoeBrand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandId;
	
	@NotBlank (message = "Brand cannot be empty")
	private String brand;
	

	public ShoeBrand(Integer brandId, String brand) {
		super();
		this.brandId = brandId;
		this.brand = brand;
	}

	
	
	public ShoeBrand() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	@Override
	public String toString() {
		return String.format("ShoeBrand [brandId=%s, brand=%s]", brandId, brand);
	}
	
}
