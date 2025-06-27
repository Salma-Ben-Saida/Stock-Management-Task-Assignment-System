package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServiceVehicules;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addVehicule")
public class AddVehiculeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String immatriculation = request.getParameter("immatriculation");
        String type = request.getParameter("type");
        String capaciteStr = request.getParameter("capacite");
        int nb=Integer.parseInt(capaciteStr);
        String etat = request.getParameter("etat");
        String maintenance = request.getParameter("maintenance");
        String marque=request.getParameter("marque");

        // Validate input
        StringBuilder message = new StringBuilder();
        boolean hasError = false;

        
        if (immatriculation == null || immatriculation.isEmpty()) {
            message.append("L'immatriculation est requise.<br>");
            hasError = true;
        }
        if (type == null || type.isEmpty()) {
            message.append("Le type de véhicule est requis.<br>");
            hasError = true;
        }
        if (capaciteStr == null || capaciteStr.isEmpty()) {
            message.append("La capacité de charge est requise.<br>");
            hasError = true;
        }
        double capacite = 0;
        try {
            capacite = Double.parseDouble(capaciteStr);
            if (capacite <= 0) {
                message.append("La capacité de charge doit être un nombre positif.<br>");
                hasError = true;
            }
        } catch (NumberFormatException e) {
            message.append("La capacité de charge doit être un nombre valide.<br>");
            hasError = true;
        }
        if (etat == null || etat.isEmpty()) {
            message.append("L'état actuel est requis.<br>");
            hasError = true;
        }
        if (maintenance == null || maintenance.isEmpty()) {
            message.append("La date de la dernière maintenance est requise.<br>");
            hasError = true;
        }

        if (hasError) {
            // Send error message back to the form
            request.setAttribute("errorMessage", message.toString());
            request.getRequestDispatcher("/ajoutVehicule.html").forward(request, response);
            return;
        }
        
        PrintWriter out = response.getWriter();

        out.println("<div>"+ServiceVehicules.addingVehicleToXML(immatriculation,marque,type,etat,nb,maintenance) +"</div>");

    }
}

