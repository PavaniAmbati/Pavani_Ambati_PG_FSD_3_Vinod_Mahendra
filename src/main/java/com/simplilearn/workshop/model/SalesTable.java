package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "salestable")
public class SalesTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salesId;
	private Integer custId;
	
	private String paymentMethod;
	
	private String cardnumber;
	
	private Integer cvvnumber;
	
	private String expiryDate;
	
	private Float totalPrice;
	
	//one to many
		@OneToMany (mappedBy = 	"salestable")
		private List<SalesItemTable> salesitemtable = new ArrayList<SalesItemTable>();
		
		@ManyToOne
		
	//relationship (many sales is associated with one customer)
		
		private Customer customer;
	
	public SalesTable() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public SalesTable(Integer salesId, Integer custId, String paymentMethod, String cardnumber, Integer cvvnumber,
			String expiryDate, Float totalPrice) {
		super();
		this.salesId = salesId;
		this.custId = custId;
		this.paymentMethod = paymentMethod;
		this.cardnumber = cardnumber;
		this.cvvnumber = cvvnumber;
		this.expiryDate = expiryDate;
		this.totalPrice = totalPrice;
	}




	public Integer getSalesId() {
		return salesId;
	}
	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public Integer getCustId() {
		return custId;
	}
	public Integer getCvvnumber() {
		return cvvnumber;
	}


	public void setCvvnumber(Integer cvvnumber) {
		this.cvvnumber = cvvnumber;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public List<SalesItemTable> getSalesitemtable() {
		return salesitemtable;
	}

	public void setSalesitemtable(List<SalesItemTable> salesitemtable) {
		this.salesitemtable = salesitemtable;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "SalesTable [salesId=" + salesId + ", custId=" + custId + ", paymentMethod=" + paymentMethod
				+ ", cardnumber=" + cardnumber + ", cvvnumber=" + cvvnumber + ", expiryDate=" + expiryDate
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	//Business method to define it is two-way relationship
	public void addSalesItemTable(SalesItemTable salesItemTable) {
		salesItemTable.setSalestable(this);
		salesitemtable.add(salesItemTable);
		
		
	}
	
}
