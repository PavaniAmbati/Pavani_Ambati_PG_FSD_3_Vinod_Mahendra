package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.ShoeInventory;


public interface InventoryService {
	
		public List<ShoeInventory> getInventory();
		public ShoeInventory saveInventory(ShoeInventory theInventory);
		public ShoeInventory getInventory(Integer theId);
		public void deleteInventory(Integer theid);
		//public List<ShoeInventory> getInventoryCat(String theCat);
		public List<ShoeInventory> getInventoryKeyword(String theCat, String theBrand, String theColour, String theGender, String theSize);


	}

