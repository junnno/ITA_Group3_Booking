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
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public User login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("You are now logged in");
				return user;
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public void logout() {
		System.out.println("Logged out.");
	}
	
	@ResponseBody
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public void test() {
		System.out.println("This is a test.");
	}
 

}

