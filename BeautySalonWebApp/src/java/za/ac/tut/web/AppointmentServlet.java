
package za.ac.tut.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.appointment.AppointmentFacadeLocal;
import za.ac.tut.entity.Appointment;
import za.ac.tut.entity.Client;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    @EJB AppointmentFacadeLocal afl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get information from the booking form
        String hairstyle = request.getParameter("hairstyle");
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime");
        
        // Get the logged-in client
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        
        // Check if client is logged in
        if (client == null) {
            response.sendRedirect("clientLogin.jsp");
            return;
        }
        
        // Create Appointment object
        Appointment appointment = new Appointment();
        
        appointment.setClient(client);
        appointment.setHairstyle(hairstyle);
        appointment.setAppointmentTime(appointmentTime);
        
        // Convert date from form into Date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(appointmentDate);

            appointment.setAppointmentDate(date);

        } catch (ParseException ex) {
            request.setAttribute("errorMessage",
                    "Invalid appointment date.");

           RequestDispatcher disp = request.getRequestDispatcher("appointment.jsp");
            disp.forward(request, response);

            return;
        }

        // New appointments start as pending
        appointment.setStatus("PENDING");

        // Save appointment to database
        afl.create(appointment);

        // Go back to client dashboard
        response.sendRedirect("appointmentSuccess.jsp");
    }
}
