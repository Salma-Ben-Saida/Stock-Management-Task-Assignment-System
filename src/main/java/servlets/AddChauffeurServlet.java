package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddChauffeurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to handle form data submission
        response.setContentType("text/html;charset=UTF-8");

        // Get the form data from request
        String idChauffeur = request.getParameter("idchauffeur");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String dateNaissance = request.getParameter("dateNaissance");
        String permis = request.getParameter("permis");
        String certifications = request.getParameter("certifications");

        // You can now use this data to add a chauffeur to your database or process it as needed
        // Example: 
        // DatabaseUtils.addChauffeur(idChauffeur, nom, prenom, email, telephone, dateNaissance, permis, certifications);

        // Redirect to a confirmation page or back to the form with a success message
        response.sendRedirect("confirmation.jsp");  // Redirect to a confirmation page
    }

    // This method can handle GET requests if needed, such as displaying a form again
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  // Delegate to doPost
    }
}

