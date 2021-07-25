package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.SalesTable;
import com.simplilearn.workshop.repository.SaleRepository;

@Service(value = "saleService")
public class SaleServiceImpl implements SaleService{
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public List<SalesTable> getSales() {
		return saleRepository.findAll();
	}
	
	@Override
	public SalesTable saveSale(SalesTable theSale) {
		return saleRepository.save(theSale);
	}
	
	@Override
	public void deleteSale(Integer theId) {
		saleRepository.deleteById(theId);
	}

	@Override
	public SalesTable getSale(Integer theId) {
		return saleRepository.findById(theId).get();
	}

	//@Override
	//public List<SalesTable> findAllbyJoin() {
		//return saleRepository.findAllbyJoin();
	//}
	
}

