package com.oocl.genesys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.genesys.dao.UserDAO;
import com.oocl.genesys.mapper.UserMapper;
import com.oocl.genesys.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void updateUser(User user) {
		User entity = userDAO.getUserById(user.getId());
		//System.out.println("DAO + " + entity.getId());
		if (entity != null) {
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setRole(user.getRole());
			entity.setPassword(user.getPassword());
		}
		
	}

	// TODO : Add NPE handlers!
	// TODO : Return as JSON
	@Override
	public User getUserById(int id) {

		User user = userDAO.getUserById(id);
		if (!user.equals(null)) {
			System.out.println("You got the user!");
			System.out.println(user.getUsername());
			return user;
		}
		System.out.println("Error");
		return null;
	}

	// TODO : Add NPE handlers!
	// TODO : Return as JSON
	@Override
	public User getUserByUsername(String username) {

		User user = userDAO.getUserByUsername(username);
		if (!user.equals(null)) {
			System.out.println("You got the user!");
			System.out.println(user.getUsername());
			return user;
		}
		System.out.println("Error");
		return null;
	}

	// TODO : Uniqueness
	@Override
	public boolean checkIfUserExists(String username) {

		boolean isExistent = userDAO.checkIfUserExists(username);
		if (isExistent) {
			System.out.println("User already exists.");
			return true;
		}

		return false;
	}

	// TODO
	@Override
	public boolean checkIfEmailExists(String email) {

		boolean isExistent = userDAO.checkIfEmailExists(email);
		if (isExistent) {
			System.out.println("User already exists.");
			return true;
		}

		return false;
	}

	@Override
	public void createUser(String username, String password, String firstName, String lastName, String email,
			int role) {
		try {
			User user = UserMapper.create(username, password, firstName, lastName, email, role);
			userDAO.saveUser(user);
			System.out.println("User has been saved.");
		} catch (Exception e) {
			System.out.println("Error. User not saved");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			userDAO.deleteUser(user);
			System.out.println("User has been deleted.");
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		return users;
	}

}
