package services;

import java.io.File;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fleetman.alertes.AlerteType;
import com.fleetman.alertes.StatutAlerteType;
import com.fleetman.employe.GestionnaireStype;
import com.fleetman.employe.GestionnaireType;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class ServiceGestionnaire extends ServiceEmploye{
	
	public static  GestionnaireStype gestionnaires=new GestionnaireStype();
	
	
	
	// Methode findGestionnaireById
	
	public static GestionnaireType findGestionnaireById(String id , GestionnaireStype gestionnaires) {
		
		File file = new File("/Users/khaoula/Desktop/projetXML/gestionnaires.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(GestionnaireStype.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            gestionnaires = (GestionnaireStype) unmarshaller.unmarshal(file);
            if (gestionnaires != null && !gestionnaires.getGestionnaireFlotte().isEmpty()) {
                for (GestionnaireType gest : gestionnaires.getGestionnaireFlotte()) {
                    if (gest.getId().equals(id)) {
                        return gest;
                    }
                }
            } else {
                System.out.println("No gestionnaires found in the XML file.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return null; // Not found
    }
		
	
	
	
	
	
	
	
	// Methode pour mettre a jour le statut de l'alerte envoyee
	
	public static int modifierStatutAlerte(String idAlerte, StatutAlerteType statAlerte) {
		
		AlerteType alerte = ServicesAlertes.findAlerteById(idAlerte);
		if(alerte!=null) {
			alerte.setStatutAlerte(statAlerte);
			return 0;
		}
		return -1;
		
	}
	
	
        
        

     // PLanifier un trajet 
    	
    	public static int planifierTrajet( String idTrajet,String destination,String dateTrajet, XMLGregorianCalendar tempsDeb,XMLGregorianCalendar tempsFin) {
    		
    		// Validate inputs 
            if (destination == null || destination.isEmpty() || dateTrajet == null || 
                tempsDeb == null || tempsFin == null) {
                
                return -1;
    	    }
            
            // Vérifier si la date de début est dans le passé
            XMLGregorianCalendar now;
			try {
				now = javax.xml.datatype.DatatypeFactory.newInstance()
				                                .newXMLGregorianCalendar(new java.util.GregorianCalendar());
				if (tempsDeb.compare(now) < 0) {
	                return -1; // tempsDeb est dans le passé
	            }
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            ServiceTrajets.ajouterTrajet(idTrajet,destination, dateTrajet, tempsDeb, tempsFin);
            
            return 0;
    }

}
