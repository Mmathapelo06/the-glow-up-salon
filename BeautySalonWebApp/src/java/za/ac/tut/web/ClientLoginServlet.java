
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.client.ClientFacadeLocal;
import za.ac.tut.entity.Client;

@WebServlet("/ClientLoginServlet")
public class ClientLoginServlet extends HttpServlet {
    @EJB ClientFacadeLocal cfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        Client client = cfl.findByUsernameAndPassword(userName, password);
        
        if (client != null) {

            // Create a session for the logged-in client
            HttpSession session = request.getSession();

            // Store the client in the session
            session.setAttribute("client", client);

            // For now, go to the client dashboard
            response.sendRedirect("clientDashboard.jsp");
            return;

        } else {

            // Login failed
            request.setAttribute("errorMessage", "Invalid username or password.");

            RequestDispatcher disp = request.getRequestDispatcher("/clientLogin.jsp");
            disp.forward(request, response);
        }
        
    }
}
