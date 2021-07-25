package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.ShoeColour;



public interface ColourService {
	
	
	public List<ShoeColour> getColours();
	public ShoeColour saveColour(ShoeColour theColour);
	public ShoeColour getColour(Integer theId);
	public void deleteColour(Integer theid);

}






