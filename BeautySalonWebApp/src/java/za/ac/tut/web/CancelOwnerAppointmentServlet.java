
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

@WebServlet("/CancelOwnerAppointmentServlet")
public class CancelOwnerAppointmentServlet extends HttpServlet {
    @EJB AppointmentFacadeLocal afl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long appointmentId = Long.parseLong(request.getParameter("appointmentId"));
        
        Appointment appointment = afl.find(appointmentId);
        
        if (appointment != null && !"CANCELLED_BY_CLIENT".equals(appointment.getStatus())
                  && !"CANCELLED_BY_OWNER".equals(appointment.getStatus())) {
            
            appointment.setStatus("CANCELLED_BY_OWNER");
            afl.edit(appointment);
    }
        response.sendRedirect("OwnerAppointmentsServlet.do");
}
}
