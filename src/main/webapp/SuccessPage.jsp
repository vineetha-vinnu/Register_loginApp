<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("userName") == null){
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
	requestDispatcher.forward(request, response);
} 
%>
<h1> Welcome User <%= session.getAttribute("userName") %>!</h1>
</body>
</html>