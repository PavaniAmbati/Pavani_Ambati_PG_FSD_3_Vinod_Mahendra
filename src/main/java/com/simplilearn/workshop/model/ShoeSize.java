package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "shoe_size")
public class ShoeSize {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sizeid;
	private String size;
	
	
	public ShoeSize() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoeSize(Integer sizeid, String size) {
		super();
		this.sizeid = sizeid;
		this.size = size;
	}
	
	public Integer getSizeid() {
		return sizeid;
	}
	public void setSizeid(Integer sizeid) {
		this.sizeid = sizeid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ShoeSize [sizeid=" + sizeid + ", size=" + size + "]";
	}
	
	
	
}