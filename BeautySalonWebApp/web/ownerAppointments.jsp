<%-- 
    Document   : ownerAppointments
    Created on : 15 Sep 2026, 10:23:30 PM
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
        <title>Glow Up Salon Owner Appointments Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body>
        <div class="login-container">

        <h1> Salon Appointments</h1>

        <p>View and manage all client appointments.</p>
        
        <div class="card">
        <h2>Today's Appointments</h2>

        <p>
          <strong>Total Bookings:</strong>
          <%= request.getAttribute("totalToday") %>
        </p>

        <p>
          <strong>Pending:</strong>
          <%= request.getAttribute("pendingToday") %>
        </p>

        <p>
          <strong>Confirmed:</strong>
          <%= request.getAttribute("confirmedToday") %>
        </p>
        </div>

        <%
            List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");

            SimpleDateFormat dateFormat =new SimpleDateFormat("dd MMMM yyyy");
        %>

        <% if (appointments == null || appointments.isEmpty()) { %>

            <p>No appointments have been booked yet.</p>

        <% } else { %>
            <div class="appointment-card-container">

            <% for (Appointment appointment : appointments) { %>

                <div class="card">

                    <h2>
                        <%= appointment.getHairstyle() %>
                    </h2>

                    <p>
                        <strong>Client:</strong>
                        <%= appointment.getClient().getUserName() %>
                    </p>

                    <p>
                        <strong>Date:</strong>
                        <%= dateFormat.format(
                                appointment.getAppointmentDate()) %>
                    </p>

                    <p>
                        <strong>Time:</strong>
                        <%= appointment.getAppointmentTime() %>
                    </p>

                    <p>
                        <strong>Status:</strong>
                        <%= appointment.getStatus() %>
                    </p>
                    
                    
                <% if (!"CANCELLED_BY_CLIENT".equals(appointment.getStatus())
                       && !"CANCELLED_BY_OWNER".equals(appointment.getStatus())) { %>

                <form action="CancelOwnerAppointmentServlet" method="post">

                   <input type="hidden"
                     name="appointmentId"
                     value="<%= appointment.getId() %>">

                   <button type="submit" class="btn">
                      Cancel Appointment
                   </button>

                </form>

                 <% } %>
                    
                    <% if ("PENDING".equals(appointment.getStatus())) { %>

                    <form action="ConfirmAppointmentServlet" method="post">

                    <input type="hidden"
                      name="appointmentId"
                      value="<%= appointment.getId() %>">

                    <button type="submit" class="btn">
                       Confirm Appointment
                    </button>

                    </form>

                <% } %>

                     </div>

                <% } %>
                </div>

        <% } %>

        <a href="ownerDashboard.jsp" class="back-link">
            Back to Owner Dashboard
        </a>

    </div>
    </body>
</html>
