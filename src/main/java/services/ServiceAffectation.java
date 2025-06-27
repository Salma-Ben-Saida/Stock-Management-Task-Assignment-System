package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.XMLConstants;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.fleetman.affectations.AffectationStype;
import com.fleetman.affectations.AffectationType;
import com.fleetman.affectations.ObjectFactory;
import com.fleetman.employe.ChauffeurStype;
import com.fleetman.employe.ChauffeurType;
import com.fleetman.employe.StatutEmployeType;
import com.fleetman.trajets.TrajetStype;
import com.fleetman.trajets.TrajetType;
import com.fleetman.vehicules.VehiculeStype;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class ServiceAffectation {

		public static AffectationStype affectations=new AffectationStype();
		public static TrajetStype trajets=ServiceTrajets.trajets;
		public static ChauffeurStype chauffeurs=ServicesChauffeurs.chauffeurs;
		public static VehiculeStype Vehicules=ServiceVehicules.Vehicules;

	    private static final AtomicInteger COUNTER = new AtomicInteger(0);

	    private static String generateUniqueId() {
	        int uniqueNumber = COUNTER.getAndIncrement();
	        return String.format("AFFECT-%08d",uniqueNumber);
	    }
	    
	    private static void initializeCounter() {
		    if (affectations != null && affectations.getAffectation() != null) {
		        int maxId = affectations.getAffectation().stream()
		            .map(affect -> affect.getIdAffectation().replace("AFFECT-", ""))
		            .mapToInt(Integer::parseInt)
		            .max()
		            .orElse(0); // Default to 0 if no IDs are present
		        COUNTER.set(maxId + 1);
		    }
		}

	 // Check if the Chauffeur is available
	    
	    private static boolean isChauffeurAvailable(String idChauff, XMLGregorianCalendar tempsDeb, XMLGregorianCalendar tempsFin) {
	        // Load existing chauffeurs data from XML
	        File file = new File("/Users/khaoula/Desktop/projetXML/chauffeurs.xml");
	        try {
	            JAXBContext context = JAXBContext.newInstance(ChauffeurStype.class);
	            Unmarshaller unmarshaller = context.createUnmarshaller();
	            chauffeurs = (ChauffeurStype) unmarshaller.unmarshal(file);
	            
	        } catch (JAXBException e) {
	            e.printStackTrace();
	            return false; // Return false if there's an error loading the data
	        }

	        // Check if the chauffeur exists and is available
	        ChauffeurType chauffeur = ServicesChauffeurs.findChauffeurById(idChauff, chauffeurs);
	        if (chauffeur == null) {
	            System.out.println("Chauffeur with ID " + idChauff + " not found.");
	            return false; // Consider unavailable if not found
	        }
	        StatutEmployeType chauffeurStatus = chauffeur.getStatutEmp();
	        if (chauffeurStatus != StatutEmployeType.DISPONIBLE) {
	            System.out.println("Chauffeur " + idChauff + " is not available (Status: " + chauffeurStatus + ").");
	            return false;
	        }

	        // Check for overlapping assignments
	        for (AffectationType affectation : affectations.getAffectation()) {
	            if (affectation.getIdChauff().equals(idChauff)) {
	                TrajetType relatedTrajet = getTrajetByAffectationId(affectation.getIdTrajet());
	                if (relatedTrajet != null && isOverlapping(relatedTrajet.getTempsDeb(), relatedTrajet.getTempsFin(), tempsDeb, tempsFin)) {
	                    System.out.println("Chauffeur " + idChauff + " is already assigned during the time.");
	                    return false;
	                }
	            }
	        }

	        return true; // Chauffeur is available
	    }


	 // Check if the Vehicle is available
	    
	    private static boolean isVehiculeAvailable(String idVehic, XMLGregorianCalendar tempsDeb, XMLGregorianCalendar tempsFin) {
	        for (AffectationType affectation : affectations.getAffectation()) {
	            if (affectation.getIdVehic().equals(idVehic)) {
	                TrajetType relatedTrajet = getTrajetByAffectationId(affectation.getIdTrajet());
	                if (relatedTrajet != null && isOverlapping(relatedTrajet.getTempsDeb(), relatedTrajet.getTempsFin(), tempsDeb, tempsFin)) {
	                    return false; // Vehicle is already assigned during the time
	                }
	            }
	        }
	        return true; // Vehicle is available
	    }
	    
	 // Check if two time intervals overlap
	    private static boolean isOverlapping(XMLGregorianCalendar start1, XMLGregorianCalendar end1,
	                                         XMLGregorianCalendar start2, XMLGregorianCalendar end2) {
	        return (start1.compare(start2) <= 0 && end1.compare(start2) > 0) || 
	               (start1.compare(end2) < 0 && end1.compare(end2) >= 0);
	    }
	    
	 // Affecter un chauffeur a un vehicule pour un trajet donne

	    public static String affecter(String idChauffeur, String idVehicule, String idTrajet, TrajetStype trajets) {
	    	
	    	TrajetType trajet = ServiceTrajets.getTrajetByID(idTrajet,trajets);
	    	if (trajet == null) {
	            return (" Trajet not found");
	        }
	        XMLGregorianCalendar tempsDeb = trajet.getTempsDeb();
	        XMLGregorianCalendar tempsFin = trajet.getTempsFin();

	        // Check if the chauffeur is available
	        if (!isChauffeurAvailable(idChauffeur, tempsDeb, tempsFin)) {
	            return ("Chauffeur not available");
	        }

	        // Check if the vehicle is available
	        if (!isVehiculeAvailable(idVehicule, tempsDeb, tempsFin)) {
	            return ("Vehicule not available");
	        }
	        
	     // Check if the chauffeur is qualified for the vehicle type
	        
	        if (!ServiceQualifications.isChauffeurQualified(idChauffeur, idVehicule)) {
	            return ("Chauffeur not qualified for the vehicle type");
	        }
	     
	        // Create a new affectation
	        ObjectFactory affectationFactory = new ObjectFactory();
	        AffectationType newAffectation = affectationFactory.createAffectationType();
	        
	        newAffectation.setIdTrajet(idTrajet);
	        newAffectation.setIdChauff(idChauffeur);
	        newAffectation.setIdVehic(idVehicule);
	        
	        newAffectation.setIdAffectation(generateUniqueId());
	        
	        affectations.getAffectation().add(newAffectation);

	        return ("Chauffeur affecte avec succes");
	    }
	    
	    private static TrajetType getTrajetByAffectationId(String idTrajet) {
	        for (TrajetType trajet : trajets.getTrajet()) {
	            if (trajet.getIdTrajet().equals(idTrajet)) {
	                return trajet;
	            }
	        }
	        return null; // Return null if no trajet is found with the given ID
	    }
	    
	    private static Unmarshaller createUnmarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
		    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		    Schema schema = schemaFactory.newSchema(new File(schemaPath));

		    JAXBContext context = JAXBContext.newInstance(AffectationStype.class);
		    Unmarshaller unmarshaller = context.createUnmarshaller();
		    
		    
		    unmarshaller.setSchema(schema); // Enable validation
		    return unmarshaller;
		}

		private static Marshaller createMarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
		    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		    Schema schema = schemaFactory.newSchema(new File(schemaPath));

		    JAXBContext context = JAXBContext.newInstance(AffectationStype.class);
		    Marshaller marshaller = context.createMarshaller();
		    marshaller.setSchema(schema); // Enable validation
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Pretty print
		    return marshaller;
		}

		
		
		public static void serializeAffectations(String filePath,String schemaPath) throws JAXBException {
		    if (affectations == null) {
		        throw new IllegalStateException("Affectations object is not initialized.");
		    }

		    Marshaller marshaller;
			try {
				marshaller = createMarshallerWithValidation(schemaPath);
				// Use validation
			    marshaller.marshal(affectations, new File(filePath));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		
		public static void deserializeAffectations(String filePath,String schemaPath) throws JAXBException, FileNotFoundException {
		    File file = new File(filePath);
		    if (!file.exists()) {
		        throw new FileNotFoundException("The file at " + filePath + " does not exist.");
		    }

		    Unmarshaller unmarshaller;
			try {
				unmarshaller = createUnmarshallerWithValidation(schemaPath);
				// Use validation
				affectations = (AffectationStype) unmarshaller.unmarshal(file);
			    initializeCounter();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		public static String addingAffectationsToXML(String idChauffeur,String idVehicule,String idTrajet) {
		    try {
		    	
		        // Load existing trajets data from XML
		        File file = new File("/Users/khaoula/Desktop/projetXML/trajets.xml");
		        JAXBContext context = JAXBContext.newInstance(TrajetStype.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        
		        // Deserialize and assign to trajets
		        trajets = (TrajetStype) unmarshaller.unmarshal(file);
		        
		        
		     // Load existing Vehicules data from XML
		        File file2 = new File("/Users/khaoula/Desktop/projetXML/vehicules.xml");
		        JAXBContext context2 = JAXBContext.newInstance(VehiculeStype.class);
		        Unmarshaller unmarshaller2 = context2.createUnmarshaller();
		        
		        // Deserialize and assign to Vehicules
		        Vehicules = (VehiculeStype) unmarshaller2.unmarshal(file2);
		        
		        // File and schema paths for affectations
		        String filePath = "/Users/khaoula/Desktop/projetXML/affectations.xml";
		        String schemaPath = "src/main/resources/xsd/Affect-ChauffVehic.xsd";
		        

		        
		        // Load existing affectations data
		        deserializeAffectations(filePath, schemaPath);

		        // Add a new affectation
		        
		        String result=(affecter(idChauffeur, idVehicule, idTrajet, trajets));

		        // Serialize updated affectations
		        serializeAffectations(filePath, schemaPath);
		        
		        return result;

		    } catch (Exception e) {
		        System.err.println("Error in addingAffectationsToXML: " + e.getMessage());
		        e.printStackTrace();
		    }
		    return (null);
		    
		}
		
		
		public static void affichAffectations() {
		    // File path to the XML file
		    String filePath = "/Users/khaoula/Desktop/projetXML/affectations.xml";
		    String schemaPath = "src/main/resources/xsd/Affect-ChauffVehic.xsd";

		    try {
		        // Deserialize the affectations object
		        deserializeAffectations(filePath, schemaPath);

		        // Check if the affectations object is initialized and contains data
		        if (affectations != null && affectations.getAffectation() != null && !affectations.getAffectation().isEmpty()) {
		            System.out.println("Liste des Affectations: \n");

		            // Iterate through the list of affectations and display their details
		            for (AffectationType affectation : affectations.getAffectation()) {
		                System.out.println("ID Affectation: " + affectation.getIdAffectation());
		                System.out.println("ID Chauffeur: " + affectation.getIdChauff());
		                System.out.println("ID Vehicule: " + affectation.getIdVehic());
		                System.out.println("ID Trajet: " + affectation.getIdTrajet());
		                System.out.println("------------------------------------------------");
		            }
		        } else {
		            System.out.println("No affectations found in the XML file.");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("An error occurred while displaying affectations.");
		    }
	}
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Affecter un chauffeur à un véhicule pour un trajet existant :");

	        System.out.println("\nVeuillez entrer l'identifiant du trajet (exemple : TRJ-12345678) :");
	        String idTraj = scanner.nextLine();

	        System.out.println("Veuillez entrer l'identifiant du chauffeur (exemple : CH-12345678) :");
	        String idChauff = scanner.nextLine();

	        System.out.println("Veuillez entrer l'identifiant du véhicule (exemple : VH-12345678) :");
	        String idVehic = scanner.nextLine();

	        try {
	            String result = addingAffectationsToXML(idChauff, idVehic, idTraj);
	            System.out.println(result); // Output the result of the operation

	            System.out.println("\nListe des affectations après modification :");
	            affichAffectations(); // Display the updated list of affectations

	        } catch (Exception e) {
	            System.err.println("Une erreur s'est produite lors de l'affectation. Veuillez réessayer.");
	            e.printStackTrace();
	        } finally {
	            scanner.close(); // Ensure the scanner is closed to prevent resource leaks
	        }
	    }

}
