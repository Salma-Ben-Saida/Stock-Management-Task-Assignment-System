package services;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.fleetman.vehicules.EtatType;
import com.fleetman.vehicules.ModeleType;
import com.fleetman.vehicules.ObjectFactory;
import com.fleetman.vehicules.VehiculeStype;
import com.fleetman.vehicules.VehiculeType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class ServiceVehicules {
	
	public static VehiculeStype Vehicules = new VehiculeStype();
	
	private static final AtomicInteger COUNTER = new AtomicInteger(0);

	private static void initializeCounter() {
	    if (Vehicules != null && Vehicules.getVehicule() != null) {
	        int maxId = Vehicules.getVehicule().stream()
	            .map(vehic -> vehic.getIdVehicule().replace("VH-", ""))
	            .mapToInt(Integer::parseInt)
	            .max()
	            .orElse(0); // Default to 0 if no IDs are present
	        COUNTER.set(maxId + 1);
	    }
	}

	
	
	public static VehiculeType getVehiculeByID(String idVehicule ,VehiculeStype Vehicules) {
		// Load existing Vehicules data from XML
        File file2 = new File("/Users/khaoula/Desktop/projetXML/vehicules.xml");
        JAXBContext context2;
		try {
			context2 = JAXBContext.newInstance(VehiculeStype.class);
			Unmarshaller unmarshaller2 = context2.createUnmarshaller();
	        
	        // Deserialize and assign to Vehicules
	        Vehicules = (VehiculeStype) unmarshaller2.unmarshal(file2);
	        if(Vehicules!=null)
	        	System.out.println("Vehicules loaded successfully.");
	        else
		        System.out.println("Vehicules not loaded ");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		for (VehiculeType vehicule : Vehicules.getVehicule()) {
            if (vehicule.getIdVehicule().equals(idVehicule)) {
                return vehicule;
            }
        }
        return null; 
    }
	
	public static ModeleType getTypeById(String idVehicule,VehiculeStype Vehicules) {
		// Load existing Vehicules data from XML
        File file2 = new File("/Users/khaoula/Desktop/projetXML/vehicules.xml");
        JAXBContext context2;
		try {
			context2 = JAXBContext.newInstance(VehiculeStype.class);
			Unmarshaller unmarshaller2 = context2.createUnmarshaller();
	        
	        // Deserialize and assign to Vehicules
	        Vehicules = (VehiculeStype) unmarshaller2.unmarshal(file2);
	        if(Vehicules!=null)
	        	System.out.println("Vehicules loaded successfully.");
	        else
		        System.out.println("Vehicules not loaded ");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VehiculeType vehicule =getVehiculeByID(idVehicule,Vehicules);
        if (vehicule!=null) {
                return vehicule.getModele();
            }
        
        return null; 
	}
	
	public static String generateUniqueId() {
        int uniqueNumber = COUNTER.getAndIncrement();
        return String.format("VH-%08d", uniqueNumber); 
    }

	
	
	// Adding new Vehicule to the collection 

	public static void ajouterVehicule(String immat,String marque,ModeleType modele,EtatType etat , int capaciteCharge, String dateDernMaintenance) {
		
		ObjectFactory FactoryVehic = new ObjectFactory();
		VehiculeType vehicule=FactoryVehic.createVehiculeType();
		
		vehicule.setCapaciteCharge(capaciteCharge);
		vehicule.setDateDernMaintenance(dateDernMaintenance);
		vehicule.setEtat(etat);
		vehicule.setImmatriculation(immat);
		vehicule.setMarque(marque);
		vehicule.setModele(modele);
		vehicule.setIdVehicule(generateUniqueId());
		
		// Add to list
		Vehicules.getVehicule().add(vehicule);
		
	}
	
	private static Unmarshaller createUnmarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(VehiculeStype.class);
	    Unmarshaller unmarshaller = context.createUnmarshaller();
	    unmarshaller.setSchema(schema); // Enable validation
	    return unmarshaller;
	}

	private static Marshaller createMarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(VehiculeStype.class);
	    Marshaller marshaller = context.createMarshaller();
	    marshaller.setSchema(schema); // Enable validation
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Pretty print
	    return marshaller;
	}

	
	
	public static void serializeVehicules(String filePath,String schemaPath) throws JAXBException {
	    if (Vehicules == null) {
	        throw new IllegalStateException("Vehicules object is not initialized.");
	    }

	    Marshaller marshaller;
		try {
			marshaller = createMarshallerWithValidation(schemaPath);
			// Use validation
		    marshaller.marshal(Vehicules, new File(filePath));
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
	public static void deserializeVehicules(String filePath,String schemaPath) throws JAXBException, FileNotFoundException {
	    File file = new File(filePath);
	    if (!file.exists()) {
	        throw new FileNotFoundException("The file at " + filePath + " does not exist.");
	    }

	    Unmarshaller unmarshaller;
		try {
			unmarshaller = createUnmarshallerWithValidation(schemaPath);
			// Use validation
		    Vehicules = (VehiculeStype) unmarshaller.unmarshal(file);
		    initializeCounter();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	// Helper method to map string to ModeleType enum
	private static ModeleType mapToModeleType(String modele) {
	    switch (modele) {
	        case "camion-PorteEngins":
	            return ModeleType.CAMION_PORTE_ENGINS;
	        case "camion-aPlateau":
	            return ModeleType.CAMION_A_PLATEAU;
	        case "camion-Grumiers":
	            return ModeleType.CAMION_GRUMIERS;
	        case "camion-Maintenance":
	            return ModeleType.CAMION_MAINTENANCE;
	        case "transpoPersonnel":
	            return ModeleType.TRANSPO_PERSONNEL;
	        case "camion-citerne":
	            return ModeleType.CAMION_CITERNE;
	        case "benneBasculante":
	            return ModeleType.BENNE_BASCULANTE;
	        case "camion-Frigorifiques":
	            return ModeleType.CAMION_FRIGORIFIQUES;
	        default:
	            throw new IllegalArgumentException("Modele invalide: " + modele);
	    }
	}
	
	// Helper method to map string to EtatType enum
	private static EtatType mapToEtatType(String etat) {
	    switch (etat) {
	        case "EnService":
	            return EtatType.EN_SERVICE;
	        case "EnMaintenance":
	            return EtatType.EN_MAINTENANCE;
	        case "Disponible":
	            return EtatType.DISPONIBLE;
	        case "EnPanne":
	            return EtatType.EN_PANNE;
	        default:
	            throw new IllegalArgumentException("Etat invalide: " + etat);
	    }
	}
	
	public static String addingVehicleToXML(String immatriculation, String marque, String modele, String etat, int capacite, String dateDernM) {
	    try {
	        String filePath = "/Users/khaoula/Desktop/projetXML/vehicules.xml";
	        String schemaPath = "src/main/resources/xsd/Vehicules.xsd";

	        // Deserialize and validate existing XML
	        deserializeVehicules(filePath, schemaPath);

	        // Convert strings to the appropriate enumeration types
	        ModeleType modeleType = mapToModeleType(modele);
	        EtatType etatType = mapToEtatType(etat);

	        // Add a new vehicle with the provided parameters
	        ajouterVehicule(immatriculation, marque, modeleType, etatType, capacite,dateDernM);

	        // Serialize with validation
	        serializeVehicules(filePath, schemaPath);
	        return("Vehicule ajoute avec succes");

	    } catch (Exception e) {
	        e.printStackTrace();
	        return ("Invalid input");
	    }
	}

	
	public static void affichVehicules() {
	    // File path to the XML file
	    String filePath = "/Users/khaoula/Desktop/projetXML/vehicules.xml";
	    String schemaPath = "src/main/resources/xsd/Vehicules.xsd";

	    try {
	        // Deserialize the vehicles object
	        deserializeVehicules(filePath, schemaPath);

	        // Check if the vehicles object is initialized and contains data
	        if (Vehicules != null && Vehicules.getVehicule() != null && !Vehicules.getVehicule().isEmpty()) {
	            System.out.println("Liste des Vehicules dans le flotte: \n");

	            // Iterate through the list of vehicles and display their details
	            for (VehiculeType vehicule : Vehicules.getVehicule()) {
	                System.out.println("ID Vehicule: " + vehicule.getIdVehicule());
	                System.out.println("Immatriculation: " + vehicule.getImmatriculation());
	                System.out.println("Marque: " + vehicule.getMarque());
	                System.out.println("Modele: " + vehicule.getModele());
	                System.out.println("Etat: " + vehicule.getEtat());
	                System.out.println("Capacité de Charge: " + vehicule.getCapaciteCharge());
	                System.out.println("Date Dernière Maintenance: " + vehicule.getDateDernMaintenance());
	                System.out.println("------------------------------------------------");
	            }
	        } else {
	            System.out.println("No vehicles found in the XML file.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("An error occurred while displaying vehicles.");
	    }
	}
	

	

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String choice;

	    // Available enumeration options for modele and etat
	    String[] modeles = {
	        "camion-PorteEngins", "camion-aPlateau", "camion-Grumiers", 
	        "camion-Maintenance", "transpoPersonnel", "camion-citerne", 
	        "benneBasculante", "camion-Frigorifiques"
	    };

	    String[] etats = {
	        "EnService", "EnMaintenance", "Disponible", "EnPanne"
	    };

	    do {
	        System.out.println("\n===== Gestion des Vehicules =====");
	        System.out.println("1. Ajouter un nouveau véhicule");
	        System.out.println("2. Afficher tous les véhicules");
	        System.out.println("3. Quitter");
	        System.out.print("Votre choix: ");
	        
	        choice = scanner.nextLine();

	        switch (choice) {
	            case "1":
	                // User inputs for vehicle details
	                System.out.print("Immatriculation: (123-AB-123");
	                String immatriculation = scanner.nextLine();

	                System.out.print("Marque: ");
	                String marque = scanner.nextLine();

	                // User chooses modele from predefined options
	                System.out.println("\nChoisissez un Modèle:");
	                for (int i = 0; i < modeles.length; i++) {
	                    System.out.println((i + 1) + ". " + modeles[i]);
	                }
	                int modeleIndex = 0;
	                try {
	                    System.out.print("Entrez le numéro du modèle: ");
	                    modeleIndex = Integer.parseInt(scanner.nextLine()) - 1;
	                    if (modeleIndex < 0 || modeleIndex >= modeles.length) {
	                        System.out.println("Choix invalide pour le modèle.");
	                        break;
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Erreur: Veuillez entrer un numéro valide.");
	                    break;
	                }
	                String modele = modeles[modeleIndex];

	                // User chooses etat from predefined options
	                System.out.println("\nChoisissez un État:");
	                for (int i = 0; i < etats.length; i++) {
	                    System.out.println((i + 1) + ". " + etats[i]);
	                }
	                int etatIndex = 0;
	                try {
	                    System.out.print("Entrez le numéro de l'état: ");
	                    etatIndex = Integer.parseInt(scanner.nextLine()) - 1;
	                    if (etatIndex < 0 || etatIndex >= etats.length) {
	                        System.out.println("Choix invalide pour l'état.");
	                        break;
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Erreur: Veuillez entrer un numéro valide.");
	                    break;
	                }
	                String etat = etats[etatIndex];

	                System.out.print("Capacité de charge: ");
	                int capacite = 0;
	                try {
	                    capacite = Integer.parseInt(scanner.nextLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("Erreur: La capacité doit être un nombre entier.");
	                    break;
	                }

	                System.out.print("Date dernière maintenance (dd/mm/yyyy): ");
	                String dateDernM = scanner.nextLine();

	                // Call addingVehicleToXML to add the vehicle
	                String result = addingVehicleToXML(immatriculation, marque, modele, etat, capacite, dateDernM);
	                System.out.println(result);
	                break;

	            case "2":
	                // Display all vehicles
	                affichVehicules();
	                break;

	            case "3":
	                System.out.println("Merci d'utiliser l'application. À bientôt!");
	                break;

	            default:
	                System.out.println("Choix invalide. Veuillez réessayer.");
	                break;
	        }
	    } while (!choice.equals("3"));

	    scanner.close();
	}

	    

	

}
