package com.oocl.genesys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.genesys.model.User;
import com.oocl.genesys.service.UserService;

@Controller
@ComponentScan("com.oocl.genesys")
public class UserController {
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.GET)
	public User createUser(@RequestParam(required = true) String username, @RequestParam(required = true) String password, @RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName, @RequestParam(required = true) String email, @RequestParam(required = true) int role, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null) return null;
		
		userService.createUser(username, password, firstName, lastName, email, role);

		return user;
	}
}
