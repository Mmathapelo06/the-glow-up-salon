<%-- 
    Document   : appointment
    Created on : 04 Sep 2026, 2:30:21 PM
    Author     : Thapi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Appointment Page</title>
        
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="login-container">

        <h1>Book Appointment</h1>

        <p>Select your hairstyle, date and time.</p>

        <form action="AppointmentServlet.do" method="post">

            <label for="hairstyle">Hairstyle</label>

            <select id="hairstyle" name="hairstyle" required>

                <option value="">-- Select Hairstyle --</option>

                <option value="Knotless Braids">
                    Knotless Braids
                </option>

                <option value="Box Braids">
                    Box Braids
                </option>

                <option value="Cornrows">
                    Cornrows
                </option>

                <option value="Goddess Braids">
                    Goddess Braids
                </option>

                <option value="Passion Twists">
                    Passion Twists
                </option>

                <option value="Faux Locs">
                    Faux Locs
                </option>

            </select>

            <label for="appointmentDate">Appointment Date</label>

            <input type="date"
                   id="appointmentDate"
                   name="appointmentDate"
                   required>

            <label for="appointmentTime">Appointment Time</label>

            <input type="time"
                   id="appointmentTime"
                   name="appointmentTime"
                   required>

            <button type="submit" class="login-btn">
                Book Appointment
            </button>

        </form>

        <a href="clientDashboard.jsp" class="back-link">
             Back to Dashboard
        </a>

    </div>
    </body>
</html>
