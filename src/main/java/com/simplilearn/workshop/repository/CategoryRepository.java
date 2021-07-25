package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.ShoeCategory;



@Repository
public interface CategoryRepository extends JpaRepository<ShoeCategory, Integer>{
}