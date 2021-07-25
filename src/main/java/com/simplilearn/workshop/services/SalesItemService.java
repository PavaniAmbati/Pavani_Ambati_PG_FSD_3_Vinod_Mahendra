package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.PurchaseList;
import com.simplilearn.workshop.model.SalesItemTable;
import com.simplilearn.workshop.model.SalesTable;

public interface SalesItemService {
	
	public List<SalesItemTable> getSaleItems();
	public SalesItemTable saveSaleItem(SalesItemTable theSaleItem);
	public SalesItemTable getSaleItem(Integer theId);
	public void deleteSaleItem(Integer theid);
	//public List<PurchaseList> findAllbyJoin();

}
