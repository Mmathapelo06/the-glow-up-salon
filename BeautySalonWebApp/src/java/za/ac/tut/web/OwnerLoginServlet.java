
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entity.SalonOwner;
import za.ac.tut.model.bl.SalonOwnerFacadeLocal;

public class OwnerLoginServlet extends HttpServlet {
    @EJB SalonOwnerFacadeLocal sof;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        SalonOwner salonOwner = sof.findByUsernameAndPassword(userName, password);
        
        if (salonOwner != null) {

           HttpSession session = request.getSession();
           session.setAttribute("salonOwner", salonOwner);

          RequestDispatcher disp = request.getRequestDispatcher("/ownerDashboard.jsp");
          disp.forward(request, response);
         return;

        } else {

    request.setAttribute("errorMessage",
            "Invalid username or password.");

    RequestDispatcher disp = request.getRequestDispatcher("/ownerLogin.jsp");
    disp.forward(request, response);
}
    }
}
