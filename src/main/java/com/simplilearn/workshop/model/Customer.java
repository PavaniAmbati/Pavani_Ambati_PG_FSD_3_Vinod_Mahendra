package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotNull @Size (min = 2, message = "first name should have atleast 2 characters")
	@NotEmpty (message = "first name is required field")
	private String firstName;
	
	@NotNull @Size (min = 2, message = "last name should have atleast 2 characters")
	@NotEmpty (message = "last name is required field")
	private String lastName;
	
	@NotEmpty (message = "phone number is a required field")
	private String phoneNumber;
	
	@NotEmpty @Email(message = "email is a required field")
	private String email;
	
	//@NotEmpty (message = "house number is a required field")
	
	@NotNull (message = "house number is a required field")
	private Integer houseNumber;
	
	@NotEmpty (message = "street name is a required field")
	private String streetName;
	
	@NotEmpty (message = "city is a required field")
	private String city;
	
	@NotEmpty (message = "state is a required field")
	private String state;
	
	@NotEmpty (message = "postal code is a required field")
	private String postalCode;
	
	@NotEmpty (message = "country is a required field")
	private String country;
	
	//one to many
	@OneToMany (mappedBy = 	"customer")
	private List<SalesTable> salestab = new ArrayList<SalesTable>();
	
		
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String firstName, String lastName, String phoneNumber, String email,
			Integer houseNumber, String streetName, String city, String state, String postalCode, String country) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	public List<SalesTable> getSalestab() {
		return salestab;
	}

	public void setSalestab(List<SalesTable> salestab) {
		this.salestab = salestab;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", houseNumber=" + houseNumber + ", streetName="
				+ streetName + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", country="
				+ country + "]";
	}
	
	public void addSalesTable(SalesTable salesTab) {
		salesTab.setCustomer(this);
		salestab.add(salesTab);
			
	}

}
