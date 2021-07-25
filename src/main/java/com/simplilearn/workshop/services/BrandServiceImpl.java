package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.repository.BrandRepository;
import com.simplilearn.workshop.model.ShoeBrand;



@Service(value = "brandService")
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	
	@Override
	public List<ShoeBrand> getBrands() {
		return brandRepository.findAll();
	}
	
	@Override
	public ShoeBrand saveBrand(ShoeBrand theBrand) {
		return brandRepository.save(theBrand);
	}
	
	@Override
	public void deleteBrand(Integer theId) {
		brandRepository.deleteById(theId);
	}

	@Override
	public ShoeBrand getBrand(Integer theId) {
		return brandRepository.findById(theId).get();
	}


}

