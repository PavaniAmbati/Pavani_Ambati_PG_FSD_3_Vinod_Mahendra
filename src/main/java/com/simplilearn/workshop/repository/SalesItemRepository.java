package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.PurchaseList;
import com.simplilearn.workshop.model.SalesItemTable;

@Repository
public interface SalesItemRepository extends JpaRepository<SalesItemTable, Integer>{
	
	//@Query ("SELECT b.category, b.brand, b.shoename, b.price, a.paymentMethod from SalesItemTable b Join b.SalesTable a on a.salesId = b.salesId")
	//public List<PurchaseList> findAllbyJoin();

}
