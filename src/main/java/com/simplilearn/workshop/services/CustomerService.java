package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.ShoeInventory;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	public Customer saveCustomer(Customer theCustomer);
	public Customer getCustomer(Integer theId);
	public void deleteCustomer(Integer theid);
	public List<Customer> getCustomerKeyword(String lastname, String phonenumber, String email, String city, String state, String country);

}
