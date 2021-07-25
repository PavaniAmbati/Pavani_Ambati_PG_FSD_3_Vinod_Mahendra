package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.CountryStateList;

public interface CountryStateService {
	
	public List<CountryStateList> getCountryStates();
	public CountryStateList saveCountryState(CountryStateList theCountryState);
	public CountryStateList getCountryState(Integer theId);
	public void deleteCountryState(Integer theid);

}
