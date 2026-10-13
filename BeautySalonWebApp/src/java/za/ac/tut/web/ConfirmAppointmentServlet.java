
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

@WebServlet("/ConfirmAppointmentServlet")
public class ConfirmAppointmentServlet extends HttpServlet {
    @EJB AppointmentFacadeLocal afl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long appointmentId = Long.parseLong(request.getParameter("appointmentId"));

        Appointment appointment = afl.find(appointmentId);

        if (appointment != null) {
            appointment.setStatus("CONFIRMED");
            afl.edit(appointment);
        }

        response.sendRedirect("OwnerAppointmentsServlet");
    }
}
