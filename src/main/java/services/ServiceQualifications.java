package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;


import com.fleetman.qualifications.ObjectFactory;
import com.fleetman.qualifications.PermisType;
import com.fleetman.qualifications.QualificationStype;
import com.fleetman.qualifications.QualificationType;
import com.fleetman.qualifications.StatutQualifType;
import com.fleetman.vehicules.VehiculeStype;
import com.fleetman.vehicules.VehiculeType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class ServiceQualifications {
	
	public static QualificationStype qualifications=new QualificationStype() ;
	public static VehiculeStype Vehicules=ServiceVehicules.Vehicules;
	
private static final AtomicInteger COUNTER = new AtomicInteger(0);

private static void initializeCounter() {
    if (qualifications != null && qualifications.getQualification() != null) {
        int maxId = qualifications.getQualification().stream()
            .map(qualif -> qualif.getIdQualification().replace("QUALIF-", ""))
            .mapToInt(Integer::parseInt)
            .max()
            .orElse(0); // Default to 0 if no IDs are present
        COUNTER.set(maxId + 1);
    }
}

	
	public static String generateUniqueId() {
        int uniqueNumber = COUNTER.getAndIncrement();
        return String.format("QUALIF-%08d", uniqueNumber); 
    }
	
	
	
	public static List<QualificationType> getQualificationsByIdchauff(String idChauffeur,QualificationStype qualifications) {
		
		// Load existing trajets data from XML
	    File file = new File("/Users/khaoula/Desktop/projetXML/qualifications.xml");
	    JAXBContext context;
		try {
			context = JAXBContext.newInstance(QualificationStype.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
		    
		    // Deserialize and assign to trajets
		    qualifications = (QualificationStype) unmarshaller.unmarshal(file);
		    if(qualifications!=null)
		    	System.out.println("Qualifications loaded successfully.");
		    else
		        System.out.println("Qualifications not loaded ");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       List<QualificationType> qualifsChauff = new ArrayList<>();
        
        for (QualificationType qualif : qualifications.getQualification()) {
            if (qualif.getIdChauff().equals(idChauffeur)) {
                qualifsChauff.add(qualif);
            }
        }
        return qualifsChauff;
    }
	
	public static boolean isChauffeurQualified(String idChauffeur, String idVehicule) {
	    VehiculeType vehicule = ServiceVehicules.getVehiculeByID(idVehicule,Vehicules);
	    List<QualificationType> chauffeurQualifications = getQualificationsByIdchauff(idChauffeur,qualifications);

	    for (QualificationType qualif : chauffeurQualifications) {
	    	
	        String permis = qualif.getPermis().value(); // Convert enum to string using value()
	        String modele = vehicule.getModele().value();
	        String idQualif=qualif.getIdQualification();

	        if (modele.equals("camion-PorteEngins") && 
	            ((permis.equals("PermisC") || permis.equals("PermisCE")) && verifierDateExpiration(idQualif))) {
	            return true;
	        } else if (modele.equals("camion-aPlateau") &&
	                   (permis.equals("PermisCE") && verifierDateExpiration(idQualif))) {
	            return true;
	        } else if (modele.equals("camion-Grumiers") &&
	                   (permis.equals("PermisCE") && verifierDateExpiration(idQualif))) {
	            return true;
	        } else if (modele.equals("camion-Maintenance") &&
	                   (permis.equals("PermisC") && verifierDateExpiration(idQualif))) {
	            return true;
	        } else if (modele.equals("transpoPersonnel") &&
	                   (permis.equals("PermisD") && verifierDateExpiration(idQualif))) {
	            return true;
	        } else if (modele.equals("camion-citerne") &&
	                   (permis.equals("PermisCE") && verifierDateExpiration(idQualif))) {
	            return true;
	        } else if (modele.equals("benneBasculante") &&
	                   ((permis.equals("PermisC") || permis.equals("PermisCE")) && verifierDateExpiration(idQualif))) {
	            return true;
	        } else if (permis.equals("PermisC") || permis.equals("PermisC1")|| permis.equals("PermisC1E")) {
	            return verifierDateExpiration(idQualif);
	        }
	    }
	    return false; // No match found
	}



public static QualificationType getQualificationByID(String idQualification,QualificationStype qualifications) {
	// Load existing trajets data from XML
    File file = new File("/Users/khaoula/Desktop/projetXML/qualifications.xml");
    JAXBContext context;
	try {
		context = JAXBContext.newInstance(QualificationStype.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
	    
	    // Deserialize and assign to trajets
	    qualifications = (QualificationStype) unmarshaller.unmarshal(file);
	    if(qualifications!=null)
	    	System.out.println("Qualifications loaded successfully.");
	    else
	        System.out.println("Qualifications not loaded ");
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	for (QualificationType qualif : qualifications.getQualification()) {
		if(qualif.getIdQualification().equals(idQualification)) {
			return qualif;
		}

	}
    System.out.println("Qualification with ID " + idQualification + " not found.");

	return null;
	
}


// Adding new Qualification to the collection 

public static void ajouterQualif(PermisType permis, String libelle, StatutQualifType statut, String organisme , String description , String dateObtention , String dateExpiration , String idChauffeur) {
	
	ObjectFactory FactoryQualif = new ObjectFactory();
	QualificationType qualif=FactoryQualif.createQualificationType();
	
	qualif.setDateExpiration(dateExpiration);
	qualif.setDateObtention(dateObtention);
	qualif.setDescription(description);
	qualif.setIdChauff(idChauffeur);
	qualif.setLibelle(libelle);
	qualif.setOrganismeCertification(organisme);
	qualif.setPermis(permis);
	qualif.setStatutQualif(statut);
	qualif.setIdQualification(generateUniqueId());
	
	// Add to list
    qualifications.getQualification().add(qualif);
	
}


// Verify Qualification Expiration Date 

public static boolean verifierDateExpiration(String idQualif) {
    // Check if idQualif is null
    if (idQualif == null || idQualif.isEmpty()) {
        System.out.println("Error: ID Qualification is null or empty.");
        return false; // Indicate failure due to invalid input
    }

    // Parse the XML file
    File file2 = new File("/Users/khaoula/Desktop/projetXML/qualifications.xml");
    try {
        JAXBContext context2 = JAXBContext.newInstance(QualificationStype.class);
        Unmarshaller unmarshaller2 = context2.createUnmarshaller();
        qualifications = (QualificationStype) unmarshaller2.unmarshal(file2);
    
    
    // Retrieve the qualification by ID
    QualificationType qualif = getQualificationByID(idQualif, qualifications);
    if (qualif == null) {
        System.out.println("Error: Qualification with ID " + idQualif + " not found.");
        return false; // Indicate failure because qualification does not exist
    }

    // Get the expiration date as a string
    String dateExpirationStr = qualif.getDateExpiration();
    
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parse the expiration date
        LocalDate dateExpiration = LocalDate.parse(dateExpirationStr, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Compare the current date with the expiration date
        if (currentDate.isAfter(dateExpiration)) {
            // Expired => Automatic update of statutQualif attribute
            qualif.setStatutQualif(StatutQualifType.EXPIREE);
            
            serializeQualifications("/Users/khaoula/Desktop/projetXML/qualifications.xml","src/main/resources/xsd/Qualifications.xsd");
            
            return false; // Qualification is expired
        } else {
            return true; // Qualification is still valid
        }
    } catch (DateTimeParseException | JAXBException e) {
        System.out.println("Error: Invalid date format for qualification ID " + idQualif);
        e.printStackTrace();
        return false; // Indicate failure due to date parsing error
    }
}


private static Unmarshaller createUnmarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(new File(schemaPath));

    JAXBContext context = JAXBContext.newInstance(QualificationStype.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    unmarshaller.setSchema(schema); // Enable validation
    return unmarshaller;
}

private static Marshaller createMarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(new File(schemaPath));

    JAXBContext context = JAXBContext.newInstance(QualificationStype.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setSchema(schema); // Enable validation
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Pretty print
    return marshaller;
}

/**
 * Serializes the qualifications object to an XML file.
 * 
 * @param filePath the file path where the XML will be saved
 * @throws JAXBException if an error occurs during the marshalling process
 */
public static void serializeQualifications(String filePath,String schemaPath) throws JAXBException {
    if (qualifications == null) {
        throw new IllegalStateException("Qualifications object is not initialized.");
    }

    Marshaller marshaller;
	try {
		marshaller = createMarshallerWithValidation(schemaPath);
		// Use validation
	    marshaller.marshal(qualifications, new File(filePath));
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}

/**
 * Deserializes the qualifications object from an XML file.
 * 
 * @param filePath the file path of the XML to read
 * @throws JAXBException if an error occurs during the unmarshalling process
 * @throws FileNotFoundException if the specified file does not exist
 */
public static void deserializeQualifications(String filePath,String schemaPath) throws JAXBException, FileNotFoundException {
    File file = new File(filePath);
    if (!file.exists()) {
        throw new FileNotFoundException("The file at " + filePath + " does not exist.");
    }

    Unmarshaller unmarshaller;
	try {
		unmarshaller = createUnmarshallerWithValidation(schemaPath);
		// Use validation
	    qualifications = (QualificationStype) unmarshaller.unmarshal(file);
	    initializeCounter();
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}

public static void addingQualificationToXML(String permis, String libelle,String statutQualifTypeStr,String institution,String description,String dateObt,String dateExp,String idCH) {
	
	try {
		String filePath = "/Users/khaoula/Desktop/projetXML/qualifications.xml";
        String schemaPath = "src/main/resources/xsd/Qualifications.xsd";
        
        deserializeQualifications(filePath, schemaPath); // Load and validate existing XML

        PermisType permisType = PermisType.valueOf(permis); // Convert string to PermisType
        StatutQualifType statutQualifType = StatutQualifType.valueOf(statutQualifTypeStr); // Convert string to StatutQualifType

        // Add a new qualification using the method
        ajouterQualif(permisType,libelle,statutQualifType, institution, description, dateObt, dateExp, idCH);
        // Serialize the updated qualifications object to the file
        serializeQualifications(filePath, schemaPath);
        System.out.println("Updated qualifications have been serialized to " + filePath);

        

    } catch (Exception e) {
        e.printStackTrace();
    }
	
}

public static void affichQualification() {
    // File path to the XML file
    String filePath = "/Users/khaoula/Desktop/projetXML/qualifications.xml";
    String schemaPath = "src/main/resources/xsd/Qualifications.xsd";

    try {
        // Deserialize the qualifications object
        deserializeQualifications(filePath, schemaPath);

        // Check if the qualifications object is initialized and contains data
        if (qualifications != null && qualifications.getQualification() != null && !qualifications.getQualification().isEmpty()) {
            System.out.println("Liste des Qualifications: \n");

            // Iterate through the list of qualifications and display their details
            for (QualificationType qualif : qualifications.getQualification()) {
                System.out.println("ID Qualification: " + qualif.getIdQualification());
                System.out.println("ID Chauffeur: " + qualif.getIdChauff());
                System.out.println("Libelle: " + qualif.getLibelle());
                System.out.println("Permis: " + qualif.getPermis().value());
                System.out.println("Statut: " + qualif.getStatutQualif().value());
                System.out.println("Organisme: " + qualif.getOrganismeCertification());
                System.out.println("Description: " + qualif.getDescription());
                System.out.println("Date Obtention: " + qualif.getDateObtention());
                System.out.println("Date Expiration: " + qualif.getDateExpiration());
                System.out.println("------------------------------------------------");
            }
        } else {
            System.out.println("No qualifications found in the XML file.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("An error occurred while displaying qualifications.");
    }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Choisissez une option:");
        System.out.println("1. Ajouter une qualification");
        System.out.println("2. Afficher toutes les qualifications");
        System.out.println("3. Valider la date d'expiration d'une qualification");
        System.out.println("4. Quitter");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("ID du chauffeur possédant cette qualification (exemple : CH-12345678): ");
                String idChauff = scanner.nextLine();

                System.out.print("Libellé de la qualification que vous souhaitez ajouter: ");
                String libelle = scanner.nextLine();

                System.out.print("Choisir le type du permis: ");
                String permis = scanner.nextLine();

                System.out.print("Statut: (Valide | Expirée | En cours de renouvellement): ");
                String statQualif = scanner.nextLine();

                System.out.print("Entrer l'organisme de certification: ");
                String organisme = scanner.nextLine();

                System.out.print("Description supplémentaire: ");
                String description = scanner.nextLine();

                System.out.print("Date d'obtention du certificat: ");
                String dateObtention = scanner.nextLine();

                System.out.print("Date d'expiration du certificat: ");
                String dateExpiration = scanner.nextLine();

                // Adding the new qualification
                addingQualificationToXML(permis, libelle, statQualif, organisme, description, dateObtention, dateExpiration, idChauff);
                System.out.println("Qualification ajoutée avec succès.");
                break;

            case 2:
                affichQualification();
                break;

            case 3:
                System.out.print("Entrer l'id de qualification pour vérifier sa validité (exemple : QUALIF-12345678): ");
                String idQualif = scanner.nextLine();
                if (!verifierDateExpiration(idQualif)) {
                    System.out.println("Qualification Expirée. Le statut de la qualification a été automatiquement changé vers : 'Expirée'.");
                } else {
                    System.out.println("Qualification valide.");
                }
                break;

            case 4:
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









