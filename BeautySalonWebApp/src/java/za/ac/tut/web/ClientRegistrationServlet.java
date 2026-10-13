
package za.ac.tut.web;

import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.client.ClientFacadeLocal;
import za.ac.tut.entity.Client;

@WebServlet("/ClientRegistrationServlet")
public class ClientRegistrationServlet extends HttpServlet {
    @EJB ClientFacadeLocal cfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get information from registration page
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        // Create Client object
        Client client = new Client();
        
        // Set client details
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setUserName(userName);
        client.setPassword(password);
        client.setCreationDate(new Date());
        
        // Save Client to database
        cfl.create(client);
        
        RequestDispatcher disp = request.getRequestDispatcher("clientLogin.jsp");
        disp.forward(request, response);
    }
}
