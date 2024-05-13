package com.training.service;

import com.training.bean.User;
import com.training.constants.UserConstants;
import com.training.dao.UserDAOImpl;

public class UserServiceImpl implements UserService{
	
	 private UserDAOImpl userDAO = new UserDAOImpl();

	    @Override
	    public String registerUser(User user) {
	    	
	    	Boolean isAdded = userDAO.addUser(user);
	    	if(isAdded) 
	    		return null;
	    	return UserConstants.REGISTRATION_FAILED;
	    }

	    @Override
	    public String authenticateUser(String userName, String password) {
	    	boolean isAdded = userDAO.authenticateUser(userName,password);
	    	if(isAdded) 
	    		return null;
	    	return UserConstants.LOGIN_FAILED;	        
	    }

}
