package com.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.training.constants.UserConstants;

public class DBUtil {
    

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(UserConstants.DB_URL, UserConstants.DB_USERNAME, UserConstants.DB_PASSWORD);
    }

}
