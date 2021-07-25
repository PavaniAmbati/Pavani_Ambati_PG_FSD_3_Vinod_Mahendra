package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "gender")
public class Gender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genderid;
	private String gender;
	
		
	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gender(Integer genderid, String gender) {
		super();
		this.genderid = genderid;
		this.gender = gender;
	}
	
	public Integer getGenderid() {
		return genderid;
	}
	public void setGenderid(Integer genderid) {
		this.genderid = genderid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Gender [genderid=" + genderid + ", gender=" + gender + "]";
	}
	
		
}
	