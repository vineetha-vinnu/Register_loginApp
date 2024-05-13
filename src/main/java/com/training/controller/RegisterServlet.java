package com.training.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.bean.User;
import com.training.constants.UserConstants;
import com.training.service.UserService;
import com.training.service.UserServiceImpl;
import com.training.util.DBUtil;
import com.training.util.UserUtil;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
	        
	        try {
				String error = UserUtil.validateRegisterRequest(request);
				HttpSession session = request.getSession();
				response.setContentType("text/html");
				
				if(error == null) {
					User user = UserUtil.CreateUser(request);
					error = userService.registerUser(user);
					session.setAttribute("userName",user.getUserName());
					if(error == null) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("registerSuccess.jsp");
			            dispatcher.forward(request, response);
					}
					
				}
				else {
					session.setAttribute("error", error);

					 request.setAttribute("error", UserConstants.ALL_FIELDS_REQUIRED);
			           request.getRequestDispatcher("registerPage.jsp").include(request, response);
				}

	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", UserConstants.REGISTRATION_FAILED);
	            request.getRequestDispatcher("registerPage.jsp").include(request, response);
	        }
	    }

}
