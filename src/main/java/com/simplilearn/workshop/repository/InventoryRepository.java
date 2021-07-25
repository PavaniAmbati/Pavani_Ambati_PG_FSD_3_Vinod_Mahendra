package com.simplilearn.workshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.ShoeInventory;

@Repository
public interface InventoryRepository extends JpaRepository<ShoeInventory, Integer>{


	// @Query("SELECT si FROM ShoeInventory si where si.category = :cat") 
	// public List<ShoeInventory> findAllbyCat(@Param("cat") String cat);
	
	@Query("SELECT si FROM ShoeInventory si where si.category = :cat or si.brand = :brand or si.colour = :colour or gender = :gender or size = :size") 
	public List<ShoeInventory> findAllbyKeyword(@Param("cat") String cat, @Param("brand") String brand, @Param("colour") String colour,
			@Param("gender") String gender, @Param("size") String size);
	

}
