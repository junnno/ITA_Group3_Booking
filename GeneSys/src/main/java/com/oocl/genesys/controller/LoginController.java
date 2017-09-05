package com.oocl.genesys.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.oocl.genesys.dao.UserDAO;
import com.oocl.genesys.model.User;


@Controller
@ComponentScan("com.oocl.genesys") 
public class LoginController {

	@Autowired
	UserDAO userDAO;
	
	@ResponseBody
	@RequestMapping(value = { "/getAllUsers" }, method = RequestMethod.GET)
	public User getAllUsers() {
		
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
				System.out.println(user.getUsername());
		}
		return null;
	}
	
	//TODO Change RequestMethod to POST
	//TODO Add exception handling
	//TODO Implement user sessions
	//TODO Test userDAO methods
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public User login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.print("You are now logged in as ");
				System.out.println(user.getUsername());
				return user;
			}
		}
		System.out.println("Error");
		return null;
	}
	
	//TODO : Add NPE handlers! 
	//TODO : Return as JSON
	@ResponseBody
	@RequestMapping(value = { "/getUserById" }, method = RequestMethod.GET)
	public User getUserById(@RequestParam(required = true) int id) {
		
		User user = userDAO.getUserById(id);
		if(!user.equals(null)) {
			System.out.println("You got the user!");
			System.out.println(user.getUsername());
			return user;
		}
		System.out.println("Error");
		return null;
	}
	
	//TODO : Add NPE handlers! 
	//TODO : Return as JSON
	@ResponseBody
	@RequestMapping(value = { "/getUserByUsername" }, method = RequestMethod.GET)
	public User getUserByUsername(@RequestParam(required = true) String username) {
		
		User user = userDAO.getUserByUsername(username);
		if(!user.equals(null)) {
			System.out.println("You got the user!");
			System.out.println(user.getUsername());
			return user;
		}
		System.out.println("Error");
		return null;
	}

	//TODO : Uniqueness
	@ResponseBody
	@RequestMapping(value = { "/checkIfUserExists" }, method = RequestMethod.GET)
	public User checkIfUserExists(@RequestParam(required = true) String username) {
		
		boolean isExistent = userDAO.checkIfUserExists(username);
		if(isExistent) {
			System.out.println("User already exists.");
			return null;
		}
		System.out.println("Error");
		return null;
	}
	
	// TODO
	@ResponseBody
	@RequestMapping(value = { "/checkIfEmailExists" }, method = RequestMethod.GET)
	public User checkIfEmailExists(@RequestParam(required = true) String email) {
		
		boolean isExistent = userDAO.checkIfEmailExists(email);
		if(isExistent) {
			System.out.println("User already exists.");
			return null;
		}
		System.out.println("Error");
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public void test() {
		System.out.println("This is a test.");
	}
	
	@ResponseBody
	@RequestMapping(value = { "/save" }, method = RequestMethod.GET)
	public void createUser() {
		try {
			
			User user = new User();
			user.setEmail("genesys-genesys@oocl.com");
			user.setFirstName("genesys");
			user.setLastName("genesys");
			user.setUsername("genesys");
			user.setPassword("genesys");
			user.setRole(3);
			
			userDAO.saveUser(user);
			System.out.println("User has been saved.");
		} catch (Exception e) {
			System.out.println("Error. User not saved");
			e.printStackTrace();
		}
	}
 
	@ResponseBody
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public void deleteUser() {
		try {
			User user = userDAO.getUserByUsername("genesys");
			userDAO.deleteUser(user);
			System.out.println("User has been deleted.");
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	

}

