
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entity.SalonOwner;
import za.ac.tut.model.bl.SalonOwnerFacadeLocal;

@WebServlet("/OwnerRegistrationServlet")
public class OwnerRegistrationServlet extends HttpServlet {
    @EJB SalonOwnerFacadeLocal sof;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get information from the registration page
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        // Create SalonOwner object
        SalonOwner salonOwner = new SalonOwner();

        // Set owner details
        salonOwner.setUserName(userName);
        salonOwner.setPassword(password);
        salonOwner.setCreationDate(new Date());

        // Save SalonOwner to database
        sof.create(salonOwner);

        // Go to the login page
        response.sendRedirect("ownerLogin.jsp");
    }
}
