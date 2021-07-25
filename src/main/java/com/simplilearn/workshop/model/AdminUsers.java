package com.simplilearn.workshop.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




	@Entity
	@Table(name = "adminusers")
	public class AdminUsers{
		
		 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotNull  (message = "UserName cannot be null")
		@NotBlank (message = "UserName cannot be empty")
		@Size(min = 2, max = 30, message ="UserName must be between 2 - 30 characters") 
		private String username;
		
		@NotNull (message = "Password cannot be null")
		@NotBlank (message = "Password cannot be empty")
	    @Size(min = 5, max = 30, message ="Password cannot be less than 5 characters")	
		private String password;
		
		private String enabled;
		private String role;
	
			
		public AdminUsers() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		
		public AdminUsers(Integer id,
				@NotNull(message = "UserName cannot be null") @NotBlank(message = "UserName cannot be empty") @Size(min = 2, max = 30, message = "UserName must be between 2 - 30 characters") String username,
				@NotNull(message = "Password cannot be null") @NotBlank(message = "Password cannot be empty") @Size(min = 5, max = 30, message = "Password cannot be less than 5 characters") String password,
				String enabled, String role) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.enabled = enabled;
			this.role = role;
		}



		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEnabled() {
			return enabled;
		}

		public void setEnabled(String enabled) {
			this.enabled = enabled;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
		

		@Override
		public String toString() {
			return "AdminUsers [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
					+ ", role=" + role + "]";
		}
	

}
