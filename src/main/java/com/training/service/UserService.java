package com.training.service;

import com.training.bean.User;

public interface UserService {
	String registerUser(User user);
	String authenticateUser(String userName, String password);

}
