package com.oocl.genesys.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.oocl.genesys.dao.AbstractDAO;
import com.oocl.genesys.model.User;

@Repository("userDao")
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO {

	@Override
	public List<User> getAllUsers() {
		Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
	}

	@Override
	public User getUserById(int id) {
		return getByKey(id);
	}

	@Override
	public User getUserByUsername(String username) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
	}

	@Override
	public void saveUser(User user) {
		persist(user);
	}
	
	@Override
	public void deleteUser(User user) {
		delete(user);
	}

	@Override
	public boolean checkIfUserExists(String username) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        if(criteria.uniqueResult().equals(null)) return true;
        else return false;
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        if(criteria.uniqueResult().equals(null)) return true;
        else return false;
	}

}
