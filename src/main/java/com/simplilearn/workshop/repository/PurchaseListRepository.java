package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.PurchaseList;

@Repository
public interface PurchaseListRepository extends JpaRepository<PurchaseList, Integer>{
	
	@Query("SELECT p FROM PurchaseList p where p.category = :category or p.brand = :brand or p.paymentMethod = :paymentMethod") 
	public List<PurchaseList> findAllbyKeyword(@Param("category") String category, @Param("brand") String brand, @Param("paymentMethod") String paymentmethod);



}
