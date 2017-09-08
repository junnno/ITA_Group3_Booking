package com.oocl.genesys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.oocl.genesys.dao.UserDAO;
import com.oocl.genesys.model.User;
import com.oocl.genesys.service.UserService;

@Controller
@ComponentScan("com.oocl.genesys")
public class LoginController {

	@Autowired
	UserService userService;

	// TODO Change RequestMethod to POST
	// TODO Add exception handling
	// TODO Implement user sessions
	// TODO Test userDAO methods
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public User login(@RequestParam(required = true) String username, @RequestParam(required = true) String password,
			HttpSession session) {

		List<User> users = userService.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

				session.setAttribute("user", user);

				System.out.print("You are now logged in as ");
				System.out.println(user.getUsername());

				return user;
			}
		}
		System.out.println("Error");
		return null;
	}

	@ResponseBody
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		User user = (User) session.getAttribute("user");

		session.removeAttribute("user");

		return "Successfully logged out";
	}

}
