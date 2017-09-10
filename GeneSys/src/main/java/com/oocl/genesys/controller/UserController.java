package com.oocl.genesys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.genesys.mapper.UserMapper;
import com.oocl.genesys.model.Booking;
import com.oocl.genesys.model.User;
import com.oocl.genesys.service.UserService;

@Controller
@RequestMapping("/user")
@ComponentScan("com.oocl.genesys")
public class UserController {
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String createUser(@RequestParam(required = true) String username, @RequestParam(required = true) String password, @RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName, @RequestParam(required = true) String email, @RequestParam(required = true) int role, HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		if(user == null) return null;
		System.out.println(username + "" + password + "" + firstName +  ""+lastName+""+email+""+role );
		userService.createUser(username, password, firstName, lastName, email, role);
		return "something";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
	public String updateUser(@RequestParam(required = true) String username, @RequestParam(required = true) String password, @RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName, @RequestParam(required = true) String email, @RequestParam(required = true) int role, HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		if(user == null) return null;
		User user = userService.getUserByUsername(username);
		user = UserMapper.set(user, username, password, firstName, lastName, email, role);
		System.out.println("Controller : " + user.getId());
		userService.updateUser(user);
		return "something";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/listUser" }, method = RequestMethod.POST)
	public List<User> listUser(ModelMap model) {
		System.out.println("List User");
		List<User> userList = userService.getAllUsers();
        for(User user:userList) {
        	System.out.println("Username : " + user.getUsername());
        }
        model.addAttribute("user", userList);
        
		return userList;
    }
	
	@ResponseBody
	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public String deleteUser(@RequestParam(required=true) String userParam, HttpServletRequest request, HttpServletResponse response) {
//    	System.out.println(booking+" "+containers);
    	Object userObject = new JSONObject(userParam);
    	JSONObject userJSONObject = (JSONObject) userObject;
    	
    	String username = (String) userJSONObject.getString("Username");
    	if(userService.checkIfUserExists(username)) {
    		User user = userService.getUserByUsername(username);
    		userService.deleteUser(user);
    	}
    	
		return "deleted";
    }
}
