
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.appointment.AppointmentFacadeLocal;
import za.ac.tut.entity.Appointment;

@WebServlet("/CancelAppointmentServlet")
public class CancelAppointmentServlet extends HttpServlet {
    @EJB AppointmentFacadeLocal afl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get appointment ID from the form
        Long appointmentId =
                Long.parseLong(request.getParameter("appointmentId"));

        // Find the appointment
        Appointment appointment = afl.find(appointmentId);

        if (appointment != null) {

            // Change the appointment status
            appointment.setStatus("CANCELLED_BY_CLIENT");

            // Save the change
            afl.edit(appointment);
        }

        // Go back to My Appointments
        response.sendRedirect("MyAppointmentsServlet");
    }
}
