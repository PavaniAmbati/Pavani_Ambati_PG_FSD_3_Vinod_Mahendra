package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.ShoeCategory;
import com.simplilearn.workshop.repository.CategoryRepository;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<ShoeCategory> getCategories() {
		return categoryRepository.findAll();
	}
	
	@Override
	public ShoeCategory saveCategory(ShoeCategory theCategory) {
		return categoryRepository.save(theCategory);
	}
	
	@Override
	public void deleteCategory(Integer theId) {
		categoryRepository.deleteById(theId);
	}

	@Override
	public ShoeCategory getCategory(Integer theId) {
		return categoryRepository.findById(theId).get();
	}


}
