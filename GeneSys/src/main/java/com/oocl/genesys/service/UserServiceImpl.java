package com.oocl.genesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.genesys.dao.UserDAO;
import com.oocl.genesys.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDAO dao;
	
	@Override
	public void updateUser(User user) {
		User entity = dao.getUserById(user.getId());
        if(entity!=null){
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setRole(user.getRole());
        }
	}

}
