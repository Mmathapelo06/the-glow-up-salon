<%-- 
    Document   : clientDashboard
    Created on : 28 Aug 2026, 11:12:04 PM
    Author     : Thapi
--%>

<%@page import="za.ac.tut.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Dashboard Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
        Client client = (Client) session.getAttribute("client");
        %>

    <div class="login-container">

        <h1>Welcome, <%= client.getName() %>! 💖</h1>

        <p>You have successfully logged in.</p>

        <p>
            Ready to book your next hairstyle?
        </p>

        <a href="appointment.jsp" class="btn">
            Book Appointment
        </a>

        <a href="MyAppointmentsServlet" class="btn">
           My Appointments
        </a>

        <a href="index.html" class="back-link">
            Logout
        </a>

    </div>
    </body>
</html>
