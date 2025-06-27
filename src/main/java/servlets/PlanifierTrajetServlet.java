package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServiceTrajets;

import java.io.IOException;


@WebServlet("/planifierTrajet")
public class PlanifierTrajetServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve form data
        String trajetId = request.getParameter("trajetId");
        String departDate = request.getParameter("departDate");
        String tempsDeb = request.getParameter("departTime");
        String tempsFin = request.getParameter("finTime");
        String destinationLieu = request.getParameter("destinationLieu");

        // Set response content type
        response.setContentType("text/html;charset=UTF-8");

        

        // Save trajet information
        ServiceTrajets.addingTrajetToXML(trajetId, departDate, tempsDeb, tempsFin, destinationLieu);

        
    }


    
 

    
}

