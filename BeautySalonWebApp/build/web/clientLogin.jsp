<%-- 
    Document   : clientLogin
    Created on : 28 Aug 2026, 10:55:19 PM
    Author     : Thapi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Login Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="login-container">

        <h1>Glow Up Salon</h1>

        <p>Client Login</p>

        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <p style="color:red;"><%= errorMessage %></p>
        <%
            }
        %>

        <form action="ClientLoginServlet.do" method="post">

            <label for="userName">Username</label>

            <input type="text"
                   id="userName"
                   name="userName"
                   required>

            <label for="password">Password</label>

            <input type="password"
                   id="password"
                   name="password"
                   required>

            <button type="submit" class="login-btn">
                Login
            </button>

        </form>

        <a href="clientRegister.jsp" class="back-link">
            Don't have an account? Register
        </a>

    </div>
    </body>
</html>
