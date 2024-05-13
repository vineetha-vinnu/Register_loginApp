package com.training.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.bean.User;
import com.training.util.DBUtil;

public class UserDAOImpl implements UserDao {
    @Override
    public Boolean addUser(User user) {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DBUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO user (userName, firstName, lastName, password) VALUES (?, ?, ?, ?)");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            return statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean authenticateUser(String userName, String password) {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DBUtil.getConnection();
        	PreparedStatement statement = conn.prepareStatement(
                    "SELECT * FROM user WHERE userName = ? AND password = ?");
            statement.setString(1, userName);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Returns true if user credentials are valid
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
