package com.training.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.training.bean.User;
import com.training.service.UserService;
import com.training.service.UserServiceImpl;
import com.training.util.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = UserUtil.validateLoginRequest(request);
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		if(error == null) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			error = userService.authenticateUser(userName,password);
			if (error == null) {
				session.setAttribute("userName", userName);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("successPage.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		session.setAttribute("error", error);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
		requestDispatcher.include(request, response);
	}

}
