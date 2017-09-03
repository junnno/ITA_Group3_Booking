package com.oocl.genesys.dao;

import java.util.List;

import com.oocl.genesys.model.User;

public interface UserDAO {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public void saveUser(User user);
	public void deleteUser(User user);
	public boolean checkIfUserExists(String username);
	public boolean checkIfEmailExists(String email);
}
