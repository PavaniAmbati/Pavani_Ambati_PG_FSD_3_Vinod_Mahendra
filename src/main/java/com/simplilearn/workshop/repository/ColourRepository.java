package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.ShoeColour;


@Repository
public interface ColourRepository  extends JpaRepository<ShoeColour, Integer>{

}
