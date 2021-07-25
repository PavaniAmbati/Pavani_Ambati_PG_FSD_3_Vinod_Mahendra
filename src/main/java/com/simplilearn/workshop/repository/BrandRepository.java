package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.ShoeBrand;


@Repository
public interface BrandRepository extends JpaRepository<ShoeBrand, Integer>{
	
//	@Query(value = "complex sql")
//	List<Customer> meaningfulmethodname();

}