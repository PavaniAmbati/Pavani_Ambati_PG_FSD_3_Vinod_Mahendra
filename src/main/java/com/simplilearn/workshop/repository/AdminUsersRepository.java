package com.simplilearn.workshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.AdminUsers;



public interface AdminUsersRepository extends JpaRepository<AdminUsers, Integer>{

	Optional<AdminUsers> findByUsername(String userName);
	Optional<AdminUsers> findByPassword(String password);
	
	

}
