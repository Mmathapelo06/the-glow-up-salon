<%-- 
    Document   : myAppointments
    Created on : 09 Sep 2026, 10:50:47 PM
    Author     : Thapi
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Glow Up Salon My Appointments Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="login-container">

        <h1> My Appointments</h1>

        <%
            List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        %>

        <% if (appointments == null || appointments.isEmpty()) { %>

            <p>You do not have any appointments yet.</p>

        <% } else { %>

            <% for (Appointment appointment : appointments) { %>

                <div class="card">

                    <h2><%= appointment.getHairstyle() %></h2>

                    <p>
                        <strong>Date:</strong>
                        <%= dateFormat.format(appointment.getAppointmentDate()) %>
                    </p>

                    <p>
                        <strong>Time:</strong>
                        <%= appointment.getAppointmentTime() %>
                    </p>

                    <p>
                        <strong>Status:</strong>
                        <%= appointment.getStatus() %>
                    </p>

                   <% if ("PENDING".equals(appointment.getStatus())) { %>

                   <form action="CancelAppointmentServlet" method="post">

                    <input type="hidden"
                      name="appointmentId"
                      value="<%= appointment.getId() %>">

                    <button type="submit" class="btn">
                      Cancel Appointment
                    </button>
                    </form>

                <% } %>

                </div>

            <% } %>

        <% } %>

        <a href="clientDashboard.jsp" class="back-link">
             Back to Dashboard
        </a>

    </div>

    </body>
</html>
