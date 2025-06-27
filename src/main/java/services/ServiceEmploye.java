package services;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fleetman.employe.EmployeType;
import com.fleetman.employe.GestionnaireStype;
import com.fleetman.employe.GestionnaireType;
import com.fleetman.employe.ResponsableRHType;
import com.fleetman.employe.ResponsableStype;
import com.fleetman.employe.TechnicienStype;
import com.fleetman.employe.TechnicienType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import com.fleetman.employe.ChauffeurStype;
import com.fleetman.employe.ChauffeurType;



public class ServiceEmploye extends EmployeType{
	
	public static  ResponsableStype responsables=ServicesResponsable.responsables;
	public static  ChauffeurStype chauffeurs=ServicesChauffeurs.chauffeurs;
	public static TechnicienStype techniciens=ServicesTechniciens.techniciens;
	public static GestionnaireStype gestionnaires=ServiceGestionnaire.gestionnaires;
	
	 
        
     // Helper method to generate the current date in dd/MM/yyyy format
        
        public static String generatedatePrisePoste() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.now().format(formatter);
        }
        
        public static String generateUniqueId(String prefix,String login) {
            return (prefix +"-"+ login); 
        }
        
        
        // Methode pour l'authentification des employes
        
        public static boolean logIn(String userLogin, String userPass, String user) {
            switch (user) {
                case "R":
                    ResponsableRHType resp = ServicesResponsable.findResponsableById(userLogin, responsables);
                    File file = new File("/Users/khaoula/Desktop/projetXML/responsables.xml");
                    try {
                        JAXBContext context = JAXBContext.newInstance(ResponsableStype.class);
                        Unmarshaller unmarshaller = context.createUnmarshaller();
                        responsables = (ResponsableStype) unmarshaller.unmarshal(file);}
                    catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    if (resp != null && userPass.equals(resp.getMotDePasse())) {
                        return true;
                    }
                    break;

                case "C":
                    ChauffeurType chauff = ServicesChauffeurs.findChauffeurById(userLogin, chauffeurs);
                    if (chauff != null && userPass.equals(chauff.getMotDePasse())) {
                        return true;
                    }
                    break;

                case "G":
                    GestionnaireType gest = ServiceGestionnaire.findGestionnaireById(userLogin, gestionnaires);
                    if (gest != null && userPass.equals(gest.getMotDePasse())) {
                        return true;
                    }
                    break;

                case "T":
                    TechnicienType tech = ServicesTechniciens.findTechnicienById(userLogin, techniciens);
                    if (tech != null && userPass.equals(tech.getMotDePasse())) {
                        return true;
                    }
                    break;

                default:
                    // Invalid user type
                    return false;
            }

            // If no match found
            return false;
        }



}
