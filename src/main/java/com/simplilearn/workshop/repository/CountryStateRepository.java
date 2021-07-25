package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.CountryStateList;

@Repository
public interface CountryStateRepository  extends JpaRepository<CountryStateList, Integer>{

}
