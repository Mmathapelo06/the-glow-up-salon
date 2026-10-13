
package za.ac.tut.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.appointment.AppointmentFacadeLocal;
import za.ac.tut.entity.Appointment;

@WebServlet("/OwnerAppointmentsServlet")
public class OwnerAppointmentsServlet extends HttpServlet {
    @EJB AppointmentFacadeLocal afl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get all appointments from the database
        List<Appointment> appointments = afl.findAll();
        
        // Prepare today's date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        
        String today = dateFormat.format(new Date());

        int totalToday = 0;
        int pendingToday = 0;
        int confirmedToday = 0;
        
         // Count today's appointments
        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentDate() == null) {
                continue;
            }

            String appointmentDate = dateFormat.format(
                    appointment.getAppointmentDate());

            if (today.equals(appointmentDate)) {

                String status = appointment.getStatus();

                // Exclude cancelled appointments from active bookings
                if (!"CANCELLED".equalsIgnoreCase(status)) {
                    totalToday++;
                }

                if ("PENDING".equalsIgnoreCase(status)) {
                    pendingToday++;
                } else if ("CONFIRMED".equalsIgnoreCase(status)) {
                    confirmedToday++;
                }
            }
            
            System.out.println("Appointment ID: " + appointment.getId());
System.out.println("Appointment date: "
        + appointment.getAppointmentDate());
System.out.println("Appointment status: "
        + appointment.getStatus());
System.out.println("------------------------");
        }

        // Send the appointments to the JSP page
        request.setAttribute("appointments", appointments);
        request.setAttribute("totalToday", totalToday);
        request.setAttribute("pendingToday", pendingToday);
        request.setAttribute("confirmedToday", confirmedToday);

        // Open the owner appointments page
        RequestDispatcher disp = request.getRequestDispatcher("ownerAppointments.jsp");
        disp.forward(request, response);
    }
}
