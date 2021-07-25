package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.ShoeCategory;




public interface CategoryService {
	
	public List<ShoeCategory> getCategories();
	public ShoeCategory saveCategory(ShoeCategory theCategory);
	public ShoeCategory getCategory(Integer theId);
	public void deleteCategory(Integer theid);

}