package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shoe_colour")
public class ShoeColour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer colourid;
	private String colour;
	
	public ShoeColour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoeColour(Integer colourid, String colour) {
		super();
		this.colourid = colourid;
		this.colour = colour;
	}
	
	public Integer getColourid() {
		return colourid;
	}
	public void setColourid(Integer colourid) {
		this.colourid = colourid;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "ShoeColour [colourid=" + colourid + ", colour=" + colour + "]";
	}
	
		

}