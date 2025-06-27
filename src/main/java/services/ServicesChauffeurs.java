package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.fleetman.employe.ChauffeurStype;
import com.fleetman.employe.ChauffeurType;
import com.fleetman.employe.ObjectFactory;
import com.fleetman.employe.StatutEmployeType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;



public class ServicesChauffeurs extends ServiceEmploye{
	
	public static ChauffeurStype chauffeurs =new ChauffeurStype();
	
	
	
	
// Add a new Chauffeur to the collection
    
	public static boolean ajouterChauffeur(String login, String modpass, String nom, String prenom, String email, String tel, String dateNai) {
	    String filePath = "/Users/khaoula/Desktop/projetXML/chauffeurs.xml";
	    String schemaPath = "src/main/resources/xsd/Employe.xsd";
	    try {
	        // Load and validate existing XML
	        deserializeChauffeurs(filePath, schemaPath);

	        // Check for duplicate login
	        if (isLoginDuplicate(login)) {
	            System.err.println("Erreur: Un chauffeur avec le même login existe déjà.");
	            return false;
	        }

	        // Create new chauffeur object
	        ObjectFactory FactoryChauffeur = new ObjectFactory();
	        ChauffeurType chauff = FactoryChauffeur.createChauffeurType();

	        chauff.setLogin(login);
	        chauff.setMotDePasse(modpass);
	        chauff.setNom(nom);
	        chauff.setPrenom(prenom);
	        chauff.setEmail(email);
	        chauff.setTelephone(tel);
	        chauff.setDateNaissance(dateNai);
	        chauff.setDatePriseDePoste(generatedatePrisePoste());

	        // Generate unique ID and set status
	        String idChauff = generateUniqueId("CH", login);
	        chauff.setId(idChauff);
	        chauff.setStatutEmp(StatutEmployeType.DISPONIBLE);

	        // Add new chauffeur to the list
	        chauffeurs.getChauffeur().add(chauff);

	        // Serialize updated XML
	        serializeChauffeurs(filePath, schemaPath);
            } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return true;
	}

	
	private static boolean isLoginDuplicate(String login) {
	    if (chauffeurs != null && !chauffeurs.getChauffeur().isEmpty()) {
	        for (ChauffeurType chauff : chauffeurs.getChauffeur()) {
	            if (chauff.getLogin().equals(login)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

    
    
// Method to find a Chauffeur by ID
    
    public static ChauffeurType findChauffeurById(String id,  ChauffeurStype chauffeurs) {
    	// Load existing chauffeurs data from XML
        File file = new File("/Users/khaoula/Desktop/projetXML/chauffeurs.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(ChauffeurStype.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            chauffeurs = (ChauffeurStype) unmarshaller.unmarshal(file);
            if (chauffeurs != null && !chauffeurs.getChauffeur().isEmpty()) {
                for (ChauffeurType chauff : chauffeurs.getChauffeur()) {
                    if (chauff.getId().equals(id)) {
                        return chauff;
                    }
                }
            } else {
                System.out.println("No chauffeurs found in the XML file.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return null; // Not found
    }

	
	
	
    private static Unmarshaller createUnmarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(ChauffeurStype.class);
	    Unmarshaller unmarshaller = context.createUnmarshaller();
	    unmarshaller.setSchema(schema); // Enable validation
	    return unmarshaller;
	}

	private static Marshaller createMarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(ChauffeurStype.class);
	    Marshaller marshaller = context.createMarshaller();
	    marshaller.setSchema(schema); // Enable validation
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Pretty print
	    return marshaller;
	}

	
	
	public static void serializeChauffeurs(String filePath,String schemaPath) throws JAXBException {
	    if (chauffeurs == null) {
	        throw new IllegalStateException("Chauffeurs object is not initialized.");
	    }

	    Marshaller marshaller;
		try {
			marshaller = createMarshallerWithValidation(schemaPath);
			// Use validation
		    marshaller.marshal(chauffeurs, new File(filePath));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	public static void deserializeChauffeurs(String filePath,String schemaPath) throws JAXBException, FileNotFoundException {
	    File file = new File(filePath);
	    if (!file.exists()) {
	        throw new FileNotFoundException("The file at " + filePath + " does not exist.");
	    }

	    Unmarshaller unmarshaller;
		try {
			unmarshaller = createUnmarshallerWithValidation(schemaPath);
			// Use validation
			chauffeurs = (ChauffeurStype) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
	public static void affichChauffeur() {
	    File file = new File("/Users/khaoula/Desktop/projetXML/chauffeurs.xml");
	    
	    if (!file.exists()) {
	        System.out.println("The file does not exist.");
	        return;
	    }

	    try {
	        JAXBContext context = JAXBContext.newInstance(ChauffeurStype.class);
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        
	        ChauffeurStype chauffeurs = (ChauffeurStype) unmarshaller.unmarshal(file);
	        if (chauffeurs != null && !chauffeurs.getChauffeur().isEmpty()) {
	            System.out.println("List of chauffeurs:");
	            for (ChauffeurType chauff : chauffeurs.getChauffeur()) {
	                System.out.println("ID: " + chauff.getId());
	                System.out.println("Login: " + chauff.getLogin());
	                System.out.println("Name: " + chauff.getNom() + " " + chauff.getPrenom());
	                System.out.println("Email: " + chauff.getEmail());
	                System.out.println("Telephone: " + chauff.getTelephone());
	                System.out.println("Date of Birth: " + chauff.getDateNaissance());
	                System.out.println("Status: " + chauff.getStatutEmp());
	                System.out.println("--------------------------");
	            }
	        } else {
	            System.out.println("No chauffeurs found in the XML file.");
	        }
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	}

	
	public static boolean deleteChauffeurById(String id) {
		File file = new File("/Users/khaoula/Desktop/projetXML/chauffeurs.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(ChauffeurStype.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            chauffeurs = (ChauffeurStype) unmarshaller.unmarshal(file);
	   
	        // Find and remove chauffeur
	        ChauffeurType chauffeurToDelete = findChauffeurById(id, chauffeurs);
	        if (chauffeurToDelete != null) {
	            chauffeurs.getChauffeur().remove(chauffeurToDelete); 
	            serializeChauffeurs("/Users/khaoula/Desktop/projetXML/chauffeurs.xml", "src/main/resources/xsd/Employe.xsd");
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	public static boolean modifyChauffeurDetails(String id, Scanner scanner) {
	    try {
	    	File file = new File("/Users/khaoula/Desktop/projetXML/chauffeurs.xml");
	       
	            JAXBContext context = JAXBContext.newInstance(ChauffeurStype.class);
	            Unmarshaller unmarshaller = context.createUnmarshaller();
	            chauffeurs = (ChauffeurStype) unmarshaller.unmarshal(file);
	        ChauffeurType chauffeurToModify = findChauffeurById(id, chauffeurs);
	        if (chauffeurToModify != null) {
	            System.out.println("Laissez le champ vide pour ne pas modifier.");
	            System.out.print("Nouveau nom: ");
	            String newNom = scanner.nextLine();
	            if (!newNom.isEmpty()) chauffeurToModify.setNom(newNom);

	            System.out.print("Nouveau prénom: ");
	            String newPrenom = scanner.nextLine();
	            if (!newPrenom.isEmpty()) chauffeurToModify.setPrenom(newPrenom);

	            System.out.print("Nouvel email: ");
	            String newEmail = scanner.nextLine();
	            if (!newEmail.isEmpty()) chauffeurToModify.setEmail(newEmail);

	            System.out.print("Nouveau téléphone: ");
	            String newTel = scanner.nextLine();
	            if (!newTel.isEmpty()) chauffeurToModify.setTelephone(newTel);

	            serializeChauffeurs("/Users/khaoula/Desktop/projetXML/chauffeurs.xml", "src/main/resources/xsd/Employe.xsd");
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("Choisissez une option:");
	        System.out.println("1. Ajouter un chauffeur");
	        System.out.println("2. Afficher tous les chauffeurs");
	        System.out.println("3. Afficher les informations d'un chauffeur (par ID)");
	        System.out.println("4. Supprimer un chauffeur (par ID)");
	        System.out.println("5. Modifier les détails d'un chauffeur (par ID)");
	        System.out.println("6. Quitter");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        switch (choice) {
	            case 1:
	                System.out.print("Login : (numCIN) : ");
	                String login = scanner.nextLine();
	                System.out.print("Mot de passe : ");
	                String modpass = scanner.nextLine();
	                System.out.print("Nom : ");
	                String nom = scanner.nextLine();
	                System.out.print("Prénom : ");
	                String prenom = scanner.nextLine();
	                System.out.print("Email: (exemple@exemple.com) : ");
	                String email = scanner.nextLine();
	                System.out.print("Téléphone: (+12345678911) : ");
	                String tel = scanner.nextLine();
	                System.out.print("Date de naissance (dd/MM/yyyy) : ");
	                String dateNai = scanner.nextLine();
	                if (ajouterChauffeur(login, modpass, nom, prenom, email, tel, dateNai))
	                    System.out.println("Chauffeur ajouté avec succès.");
	                break;

	            case 2:
	                affichChauffeur();
	                break;

	            case 3:
	                System.out.print("Entrez l'ID du chauffeur : ");
	                String idToDisplay = scanner.nextLine();
	                ChauffeurType chauffeur = findChauffeurById(idToDisplay, chauffeurs);
	                if (chauffeur != null) {
	                    System.out.println("ID: " + chauffeur.getId());
	                    System.out.println("Login: " + chauffeur.getLogin());
	                    System.out.println("Nom: " + chauffeur.getNom());
	                    System.out.println("Prénom: " + chauffeur.getPrenom());
	                    System.out.println("Email: " + chauffeur.getEmail());
	                    System.out.println("Téléphone: " + chauffeur.getTelephone());
	                    System.out.println("Date de Naissance: " + chauffeur.getDateNaissance());
	                    System.out.println("Statut: " + chauffeur.getStatutEmp());
	                } else {
	                    System.out.println("Chauffeur non trouvé.");
	                }
	                break;

	            case 4:
	                System.out.print("Entrez l'ID du chauffeur à supprimer : ");
	                String idToDelete = scanner.nextLine();
	                if (deleteChauffeurById(idToDelete)) {
	                    System.out.println("Chauffeur supprimé avec succès.");
	                } else {
	                    System.out.println("Erreur: Chauffeur non trouvé.");
	                }
	                break;

	            case 5:
	                System.out.print("Entrez l'ID du chauffeur à modifier : ");
	                String idToModify = scanner.nextLine();
	                if (modifyChauffeurDetails(idToModify, scanner)) {
	                    System.out.println("Détails du chauffeur modifiés avec succès.");
	                } else {
	                    System.out.println("Erreur: Chauffeur non trouvé.");
	                }
	                break;

	            case 6:
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
