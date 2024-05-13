package com.training.util;

import com.training.bean.User;
import com.training.constants.UserConstants;

import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {

	public static String validateLoginRequest(HttpServletRequest request) {
		String error = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if (userName.isEmpty() ||  password.isEmpty()) {
			error = UserConstants.EMPTY_USERNAME_PASSWORD;
		}
		return error;
	}
	
	public static String validateRegisterRequest(HttpServletRequest request) {
		String error = null;
		 String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String userName = request.getParameter("userName");
	        String password = request.getParameter("password");
	    
	        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || password.isEmpty()) {
			error = UserConstants.ALL_FIELDS_REQUIRED;
		}
		return error;
	}

	public static User CreateUser(HttpServletRequest request) {
		
		 String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String userName = request.getParameter("userName");
	        String password = request.getParameter("password");
	        
	        User user = new User(firstName, lastName, userName,password);
			return user;
	        
	        
	}
	
}
