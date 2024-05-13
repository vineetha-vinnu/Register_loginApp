package com.training.dao;

import com.training.bean.User;

public interface UserDao {
	Boolean addUser(User user);
	Boolean authenticateUser(String userName, String password);
}
