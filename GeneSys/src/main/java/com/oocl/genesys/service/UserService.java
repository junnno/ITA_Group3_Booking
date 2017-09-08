package com.oocl.genesys.service;

import java.util.List;

import com.oocl.genesys.model.User;

public interface UserService {
	public void updateUser(User user);

	List<User> getAllUsers();

	void deleteUser();

	boolean checkIfEmailExists(String email);

	boolean checkIfUserExists(String username);

	User getUserByUsername(String username);

	User getUserById(int id);

	void createUser(String username, String password, String firstName, String lastName, String email, int role);
}
