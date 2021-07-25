package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.SalesTable;


@Repository
public interface SaleRepository extends JpaRepository<SalesTable, Integer>{
	
	
	
	//@Query("SELECT c.firstName, c.lastName, b.category, b.brand, b.shoename, b.price, a.paymentMethod FROM SalesTable a inner join SalesItemTable b on a.salesId = b.salesId inner join Customer c on a.custId = c.customerId")
	//public List<SalesTable> findAllbyJoin();
	
	//@Query("SELECT c FROM Customer c where c.lastName = :lastName or c.phoneNumber = :phoneNumber or c.email = :email or c.city = :city or c.state = :state or c.country = :country") 
	//public List<Customer> findAllbyKeyword(@Param("lastName") String lastname, @Param("phoneNumber") String phonenumber, @Param("email") String email, @Param("city") String city, @Param("state") String state, @Param("country") String country);


}

