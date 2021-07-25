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
@Table(name = "shoe_category")
public class ShoeCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	@NotBlank (message = "Category cannot be empty")
	private String category;
	
	public ShoeCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoeCategory(Integer categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ShoeCategory [categoryId=" + categoryId + ", category=" + category + "]";
	}
	
	

}
