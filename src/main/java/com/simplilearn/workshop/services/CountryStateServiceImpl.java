package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.CountryStateList;
import com.simplilearn.workshop.repository.CountryStateRepository;

@Service(value = "countryStateService")
public class CountryStateServiceImpl  implements CountryStateService{

	@Autowired
	private CountryStateRepository countryStateRepository;
	
	@Override
	public List<CountryStateList> getCountryStates() {
		return countryStateRepository.findAll();
	}
	
	@Override
	public CountryStateList saveCountryState(CountryStateList theCountryState) {
		return countryStateRepository.save(theCountryState);
	}
	
	@Override
	public void deleteCountryState(Integer theId) {
		countryStateRepository.deleteById(theId);
	}

	@Override
	public CountryStateList getCountryState(Integer theId) {
		return countryStateRepository.findById(theId).get();
	}


}