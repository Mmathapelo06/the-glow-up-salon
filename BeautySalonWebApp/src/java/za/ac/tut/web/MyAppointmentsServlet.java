
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet("/MyAppointmentsServlet")
public class MyAppointmentsServlet extends HttpServlet {
    @EJB AppointmentFacadeLocal afl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // Get the logged-in client
        Client client = (Client) session.getAttribute("client");
        
        // If no client is logged in, go to login
        if (client == null) {
            response.sendRedirect("clientLogin.jsp");
            return;
        }

        // Get all appointments
        List<Appointment> allAppointments = afl.findAll();

        // Store only this client's appointments
        List<Appointment> clientAppointments = new ArrayList<Appointment>();

        for (Appointment appointment : allAppointments) {

            if (appointment.getClient() != null
                    && appointment.getClient().getId().equals(client.getId())) {

                clientAppointments.add(appointment);
            }
        }
        
        // Send appointments to JSP
        request.setAttribute("appointments", clientAppointments);

        // Open My Appointments page
        RequestDispatcher disp = request.getRequestDispatcher("myAppointments.jsp");
        disp.forward(request, response);

    }
}
