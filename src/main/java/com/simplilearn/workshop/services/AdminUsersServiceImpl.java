
package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.AdminUsers;
import com.simplilearn.workshop.model.ShoeBrand;
import com.simplilearn.workshop.repository.AdminUsersRepository;
import com.simplilearn.workshop.repository.BrandRepository;



@Service(value = "adminUsersService")
public class AdminUsersServiceImpl implements AdminUsersService {

	@Autowired
	private AdminUsersRepository adminUsersRepository;
	
	
	@Override
	public List<AdminUsers> getAUsers() {
		return adminUsersRepository.findAll();
	}
	
	@Override
	public AdminUsers saveAUsers(AdminUsers theAUser) {
		return adminUsersRepository.save(theAUser);
	}
	
	@Override
	public void deleteAUser(Integer theId) {
		adminUsersRepository.deleteById(theId);
	}

	@Override
	public AdminUsers getAUsers(Integer theId) {
		return adminUsersRepository.findById(theId).get();
	}
	
	@Override
	public AdminUsers getAUsersname(String UserName) {
		return adminUsersRepository.findByUsername(UserName).get();
	}

	@Override
	public AdminUsers getAPassword(String userName) {
		return adminUsersRepository.findByPassword(userName).get();
	}
	
	

}


