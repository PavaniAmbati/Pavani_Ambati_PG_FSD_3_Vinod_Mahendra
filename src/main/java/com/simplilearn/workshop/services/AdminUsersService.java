package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.AdminUsers;


public interface AdminUsersService {
	
	public List<AdminUsers> getAUsers();
	public AdminUsers saveAUsers(AdminUsers theAUser);
	public AdminUsers getAUsers(Integer theId);
	public void deleteAUser(Integer theid);
	public AdminUsers getAUsersname(String userName);
	public AdminUsers getAPassword(String userName);

	
}