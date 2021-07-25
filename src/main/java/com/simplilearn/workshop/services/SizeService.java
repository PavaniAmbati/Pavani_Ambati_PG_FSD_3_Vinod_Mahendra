package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.ShoeSize;

public interface SizeService {
	
	public List<ShoeSize> getSizes();
	public ShoeSize saveSize(ShoeSize theSize);
	public ShoeSize getSize(Integer theId);
	public void deleteSize(Integer theid);

}



