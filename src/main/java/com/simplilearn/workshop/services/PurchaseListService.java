package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.simplilearn.workshop.model.PurchaseList;

public interface PurchaseListService {
	
	public List<PurchaseList> getPurchaselist();
	public PurchaseList savePurchaselist(PurchaseList thePurchaselist);
	public PurchaseList getPurchaselist(Integer theId);
	public List<PurchaseList> findAllbyKeyword(String category,String brand,String paymentmethod);

}
