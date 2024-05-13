package com.training.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.training.bean.User;
import com.training.constants.UserConstants;
import com.training.service.UserService;
import com.training.service.UserServiceImpl;
import com.training.util.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String error = UserUtil.validateLoginRequest(request);
			HttpSession session = request.getSession();
			response.setContentType("text/html");
			if (error == null) {
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
				error = userService.authenticateUser(userName, password);
				System.out.println(error);
				if (error == null) {
					session.setAttribute("userName", userName);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("SuccessPage.jsp");
					requestDispatcher.forward(request, response);
				}
			
		
		else {
			session.setAttribute("error", error);
			request.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
			requestDispatcher.include(request, response);
		}
		}
			else {
				session.setAttribute("error", UserConstants.ALL_FIELDS_REQUIRED);
				request.setAttribute("error", UserConstants.ALL_FIELDS_REQUIRED);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
				requestDispatcher.include(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", UserConstants.LOGIN_FAILED);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
			requestDispatcher.include(request, response);
		}
		
	}

}
