package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymenttypes")
public class PaymentTypes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymenttypeid;
	private String paymenttype;
	
	
	
	public PaymentTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentTypes(Integer paymenttypeid, String paymenttype) {
		super();
		this.paymenttypeid = paymenttypeid;
		this.paymenttype = paymenttype;
	}
	public Integer getPaymenttypeid() {
		return paymenttypeid;
	}
	public void setPaymenttypeid(Integer paymenttypeid) {
		this.paymenttypeid = paymenttypeid;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	@Override
	public String toString() {
		return "PaymentTypes [paymenttypeid=" + paymenttypeid + ", paymenttype=" + paymenttype + "]";
	}
	

}
