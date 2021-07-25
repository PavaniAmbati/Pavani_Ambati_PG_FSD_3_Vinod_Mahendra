package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.simplilearn.workshop.model.ShoeColour;
import com.simplilearn.workshop.repository.ColourRepository;

@Service(value = "colourService")
public class ColourServiceImpl  implements ColourService{

	@Autowired
	private ColourRepository colourRepository;
	
	@Override
	public List<ShoeColour> getColours() {
		return colourRepository.findAll();
	}
	
	
	@Override
	public ShoeColour saveColour(ShoeColour theColour) {
		return colourRepository.save(theColour);
	}
	
	@Override
	public void deleteColour(Integer theId) {
		colourRepository.deleteById(theId);
	}

	@Override
	public ShoeColour getColour(Integer theId) {
		return colourRepository.findById(theId).get();
	}


}