package com.oocl.genesys.mapper;

import com.oocl.genesys.model.User;

public class UserMapper {
	
	public static User create(String username, String password, String firstName, String lastName, String email, int role) {
		User user = new User();
		if(!(email.isEmpty()||firstName.isEmpty()||lastName.isEmpty()||username.isEmpty()||password.isEmpty())) {
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
		}
		return user;
		
	}

	public static User set(User user, String username, String password, String firstName, String lastName, String email,
			int role) {
		// TODO Auto-generated method stub
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}
}
