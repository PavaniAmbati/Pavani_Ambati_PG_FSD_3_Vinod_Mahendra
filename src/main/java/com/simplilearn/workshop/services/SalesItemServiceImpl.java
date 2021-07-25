package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.PurchaseList;
import com.simplilearn.workshop.model.SalesItemTable;
import com.simplilearn.workshop.repository.SalesItemRepository;

@Service(value = "saleItemService")
public class SalesItemServiceImpl implements SalesItemService{
	
	@Autowired
	private SalesItemRepository saleItemRepository;
	
	@Override
	public List<SalesItemTable> getSaleItems() {
		return saleItemRepository.findAll();
	}
	
	@Override
	public SalesItemTable saveSaleItem(SalesItemTable theSaleItem) {
		return saleItemRepository.save(theSaleItem);
	}
	
	@Override
	public void deleteSaleItem(Integer theId) {
		saleItemRepository.deleteById(theId);
	}

	@Override
	public SalesItemTable getSaleItem(Integer theId) {
		return saleItemRepository.findById(theId).get();
	}

	//@Override
	//public List<PurchaseList> findAllbyJoin() {
		//return saleItemRepository.findAllbyJoin();
	//}


}
