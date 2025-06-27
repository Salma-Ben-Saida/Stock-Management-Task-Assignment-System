package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServiceAffectation;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/affecterChauffeur")
public class AffecterChauffeurServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	
        // Récupérer les données du formulaire
        String trajetId = request.getParameter("trajetId");
        String idChauffeur = request.getParameter("idchauffeur");
        String idVehicule = request.getParameter("idvehicule");

        // Traiter l'affectation via un service métier
        String resultMessage = ServiceAffectation.addingAffectationsToXML(idChauffeur, idVehicule, trajetId);

        // Générer une réponse dynamique
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Résultat de l'Affectation</title>");
            out.println("<link href='assets/vendor/bootstrap/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body class='bg-light'>");
            out.println("<div class='container mt-5'>");
            out.println("<div class='alert alert-success' role='alert'>");
            out.println("<p>" + resultMessage + "</p>");
            out.println("<hr>");
            out.println("<a href='src/main/webapp/home.jsp' class='btn btn-primary'>Retour a l'acceuil</a>");
            out.println("<a href='src/main/webapp/affecterchauffeurs.jsp' class='btn btn-primary'>Affecter un autre chauffeur</a>");
            out.println("<a href='src/main/webapp/planifiertrajet.jsp' class='btn btn-primary'>Planifier un autre trajet</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
