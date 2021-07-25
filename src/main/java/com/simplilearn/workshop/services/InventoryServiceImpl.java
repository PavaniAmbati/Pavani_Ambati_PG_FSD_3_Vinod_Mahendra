package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.ShoeInventory;
import com.simplilearn.workshop.repository.InventoryRepository;

@Service(value = "inventoryService")
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public List<ShoeInventory> getInventory() {
		return inventoryRepository.findAll();
	}

	@Override
	public ShoeInventory saveInventory(ShoeInventory theInventory) {
		return inventoryRepository.save(theInventory);
	}
	
	@Override
	public void deleteInventory(Integer theId) {
		inventoryRepository.deleteById(theId);
	}

	@Override
	public ShoeInventory getInventory(Integer theId) {
		return inventoryRepository.findById(theId).get();
	}
	
	//@Override
	//public List<ShoeInventory> getInventoryCat(String theCat) {
		//return inventoryRepository.findAllbyCat(theCat);
	
	@Override
	public List<ShoeInventory> getInventoryKeyword(String theCat, String theBrand, String theColour, String theGender, String theSize)
		{
		return inventoryRepository.findAllbyKeyword(theCat, theBrand, theColour, theGender, theSize);
		}


}


