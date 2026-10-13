<%-- 
    Document   : clientRegister
    Created on : 28 Aug 2026, 10:33:08 PM
    Author     : Thapi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Glow Up Salon | Client Registration</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
         <div class="login-container">

        <h1>Glow Up Salon</h1>

        <p>Create Client Account</p>

        <form action="ClientRegistrationServlet.do" method="post">

            <label for="name">Name</label>

            <input type="text"
                   id="name"
                   name="name"
                   required>

            <label for="surname">Surname</label>

            <input type="text"
                   id="surname"
                   name="surname"
                   required>

            <label for="email">Email</label>

            <input type="email"
                   id="email"
                   name="email"
                   required>

            <label for="phoneNumber">Phone Number</label>

            <input type="text"
                   id="phoneNumber"
                   name="phoneNumber"
                   required>

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
                Create Account
            </button>

        </form>

        <a href="clientLogin.jsp" class="back-link">
             Already have an account? Login
        </a>

    </div>
    </body>
</html>
