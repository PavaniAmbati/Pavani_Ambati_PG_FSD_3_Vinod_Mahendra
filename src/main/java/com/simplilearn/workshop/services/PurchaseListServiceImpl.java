package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.PurchaseList;
import com.simplilearn.workshop.repository.PurchaseListRepository;

@Service(value = "purchaselistService")
public class PurchaseListServiceImpl implements PurchaseListService {
	
	@Autowired
	private PurchaseListRepository purchaselistRepository;
	
	@Override
	public List<PurchaseList> getPurchaselist() {
		return purchaselistRepository.findAll();
	}
	
	@Override
	public PurchaseList savePurchaselist(PurchaseList thePurchaselist) {
		return purchaselistRepository.save(thePurchaselist);
	}
	
	
	@Override
	public PurchaseList getPurchaselist(Integer theId) {
		return purchaselistRepository.findById(theId).get();
	}

	@Override
	public List<PurchaseList> findAllbyKeyword(String category, String brand, String paymentmethod) {
		return purchaselistRepository.findAllbyKeyword(category, brand, paymentmethod);
	}

	

}
