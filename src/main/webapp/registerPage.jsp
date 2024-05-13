<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    
    <form action="registerServlet" method="post">
        <table>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lastName"></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>

    <% String error = (String) session.getAttribute("error");
       if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
        
    <% }
       session.setAttribute("error",null);
    %>
    
</body>
</html>