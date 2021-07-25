package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.ShoeBrand;

public interface BrandService {
	
	public List<ShoeBrand> getBrands();
	public ShoeBrand saveBrand(ShoeBrand theBrand);
	public ShoeBrand getBrand(Integer theId);
	public void deleteBrand(Integer theid);

}