package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.fleetman.shared.StatutType;
import com.fleetman.trajets.ObjectFactory;
import com.fleetman.trajets.TrajetStype;
import com.fleetman.trajets.TrajetType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;


public class ServiceTrajets {
	
	public static TrajetStype trajets=new TrajetStype();
	
	
	public static TrajetStype getTrajets() {
        return trajets;
    }
	
	
	
	public static TrajetType getTrajetByID(String idTrajet, TrajetStype trajets) {
        for (TrajetType trajet : trajets.getTrajet()) {
            if (trajet.getIdTrajet().equals(idTrajet)) {
                return trajet;
            }
        }
        return null; // Return null if no trajet is found with the given ID
    }
	
	
	// Add new trajet to the collection 
	
	public static void ajouterTrajet( String idTrajet,String destination,String dateTrajet, XMLGregorianCalendar tempsDeb,XMLGregorianCalendar tempsFin) {
		
		ObjectFactory FactoryTrajet = new ObjectFactory();
    	TrajetType trajet=FactoryTrajet.createTrajetType();
    	
    		
    		trajet.setDestination(destination);
    		trajet.setDateTrajet(dateTrajet);
    		trajet.setTempsDeb(tempsDeb);
    		trajet.setTempsFin(tempsFin);
    		
    		trajet.setStatutTache(StatutType.EN_ATTENTE);
    		
    		trajets.getTrajet().add(trajet);
    		
	}
	
	
	private static Unmarshaller createUnmarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(TrajetStype.class);
	    Unmarshaller unmarshaller = context.createUnmarshaller();
	    unmarshaller.setSchema(schema); // Enable validation
	    return unmarshaller;
	}
	
	private static Marshaller createMarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(TrajetStype.class);
	    Marshaller marshaller = context.createMarshaller();
	    marshaller.setSchema(schema); // Enable validation
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Pretty print
	    return marshaller;
	}
	
	public static void serializeTrajets(String filePath,String schemaPath) throws JAXBException {
	    if (trajets == null) {
	        throw new IllegalStateException("Trajets object is not initialized.");
	    }
	    Marshaller marshaller;
		try {
			marshaller = createMarshallerWithValidation(schemaPath);
			// Use validation
		    marshaller.marshal(trajets, new File(filePath));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void deserializeTrajets(String filePath,String schemaPath) throws JAXBException, FileNotFoundException {
	    File file = new File(filePath);
	    if (!file.exists()) {
	        throw new FileNotFoundException("The file at " + filePath + " does not exist.");
	    }
	    Unmarshaller unmarshaller;
		try {
			unmarshaller = createUnmarshallerWithValidation(schemaPath);
			// Use validation
			trajets = (TrajetStype) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void addingTrajetToXML(String idTrajet, String dateTrajet, String tempsDebut,String tempsdeFin,String destination) {
		
		try {
	        String filePath = "/Users/khaoula/Desktop/projetXML/trajets.xml";
	        String schemaPath = "src/main/resources/xsd/Trajets.xsd";
	        
	        deserializeTrajets(filePath, schemaPath); // Load and validate existing XML
	        

	        // Convert ISO 8601 formatted strings to XMLGregorianCalendar
	        XMLGregorianCalendar tempsDeb = DatatypeFactory.newInstance().newXMLGregorianCalendar(tempsDebut);
	        XMLGregorianCalendar tempsFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(tempsdeFin);

	        ServiceGestionnaire.planifierTrajet(idTrajet,destination, dateTrajet, tempsDeb, tempsFin);
	        // Serialize with validation
	        serializeTrajets(filePath, schemaPath);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	public static void affichTrajet() {
	    // File path to the XML file
	    File file = new File("/Users/khaoula/Desktop/projetXML/trajets.xml");
	    
	    if (!file.exists()) {
	        System.out.println("The file does not exist.");
	        return;
	    }

	    try {
	        JAXBContext context = JAXBContext.newInstance(TrajetStype.class);
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        
	        // Load and validate the existing XML
	        TrajetStype trajets = (TrajetStype) unmarshaller.unmarshal(file);
	        if (trajets != null && !trajets.getTrajet().isEmpty()) {
	            System.out.println("List of trajets:");
	            for (TrajetType trajet : trajets.getTrajet()) {
	                System.out.println("ID: " + trajet.getIdTrajet());
	                System.out.println("Destination: " + trajet.getDestination());
	                System.out.println("Date du trajet: " + trajet.getDateTrajet());
	                System.out.println("Temps de début: " + trajet.getTempsDeb());
	                System.out.println("Temps de fin: " + trajet.getTempsFin());
	                System.out.println("Statut: " + trajet.getStatutTache());
	                System.out.println("--------------------------");
	            }
	        } else {
	            System.out.println("No trajets found in the XML file.");
	        }
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	}
	

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez une option:");
            System.out.println("1. Ajouter un trajet");
            System.out.println("2. Afficher tous les trajets");
            System.out.println("3. Quitter");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("ID du trajet (exemple : TRJ-12345678): ");
                    String idTraj = scanner.nextLine();
                    
                    System.out.print("Date du trajet (aaaa-MM-dd): ");
                    String dateTraj = scanner.nextLine();
                    
                    System.out.print("Heure de début du trajet (HH:mm:ss): ");
                    String tempsDebut = scanner.nextLine();
                    
                    System.out.print("Heure de fin estimée du trajet (HH:mm:ss): ");
                    String tempsdeFin = scanner.nextLine();
                    
                    System.out.print("Destination du trajet: ");
                    String destination = scanner.nextLine();

                    // Adding the new trajet
                    addingTrajetToXML(idTraj, dateTraj, tempsDebut, tempsdeFin, destination);
                    System.out.println("Trajet ajouté avec succès.");
                    break;

                case 2:
                    affichTrajet();
                    break;

                case 3:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide, veuillez réessayer.");
                    break;
            }
        }
    }



}
