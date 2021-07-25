package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.ShoeSize;
import com.simplilearn.workshop.repository.SizeRepository;

@Service(value = "sizeService")
public class SizeServiceImpl  implements SizeService{

	@Autowired
	private SizeRepository sizeRepository;
	
	@Override
	public List<ShoeSize> getSizes() {
		return sizeRepository.findAll();
	}
	
	@Override
	public ShoeSize saveSize(ShoeSize theSize) {
		return sizeRepository.save(theSize);
	}
	
	@Override
	public void deleteSize(Integer theId) {
		sizeRepository.deleteById(theId);
	}

	@Override
	public ShoeSize getSize(Integer theId) {
		return sizeRepository.findById(theId).get();
	}


}