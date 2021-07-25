package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.SalesTable;


public interface SaleService {
	
	
		public List<SalesTable> getSales();
		public SalesTable saveSale(SalesTable theSale);
		public SalesTable getSale(Integer theId);
		public void deleteSale(Integer theid);
		//public List<SalesTable> findAllbyJoin();
	}



