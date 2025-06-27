package services;


import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.fleetman.employe.ChauffeurStype;
import com.fleetman.employe.ChauffeurType;
import com.fleetman.employe.ObjectFactory;
import com.fleetman.employe.ResponsableRHType;
import com.fleetman.employe.ResponsableStype;
import com.fleetman.employe.StatutEmployeType;
import com.fleetman.qualifications.PermisType;
import com.fleetman.qualifications.QualificationStype;
import com.fleetman.qualifications.QualificationType;
import com.fleetman.qualifications.StatutQualifType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class ServicesResponsable extends ServiceEmploye{
	
	public static ResponsableStype responsables=new ResponsableStype();
	public static ChauffeurStype chauffeurs =ServicesChauffeurs.chauffeurs;
	public static QualificationStype qualifications=ServiceQualifications.qualifications;
	
	
	
	//Method to find responsable by id
	
	
	public static ResponsableRHType findResponsableById(String id,  ResponsableStype responsables) {
    	// Load existing chauffeurs data from XML
        File file = new File("/Users/khaoula/Desktop/projetXML/responsables.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(ResponsableStype.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            responsables = (ResponsableStype) unmarshaller.unmarshal(file);
            if (responsables != null && !responsables.getResponsableRH().isEmpty()) {
                for (ResponsableRHType resp : responsables.getResponsableRH()) {
                    if (resp.getId().equals(id)) {
                        return resp;
                    }
                }
            } else {
                System.out.println("No responsables found in the XML file.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return null; // Not found
    }
	
	// CRUD methods for Chauffeur

	
		// Method to add a new Chauffeur to the system
		
	    public void saisirInformations(String login , String modpass, String nom, String prenom, String email, String tel, String dateNai) {
	    	ServicesChauffeurs.ajouterChauffeur(login,modpass,nom,prenom,email,tel,dateNai);
	    		
	    	}
	    
	    
	 // Method to modify the login of a Chauffeur
	    
	    public int modifierLoginChauffeur(String idChauffeur, String newLogin) {
	        // Call findChauffeurById from ServicesChauffeurs
	        ChauffeurType chauffeur = ServicesChauffeurs.findChauffeurById(idChauffeur,chauffeurs);

	        if (chauffeur != null) { // If a chauffeur is found
	            chauffeur.setLogin(newLogin); // Update the login using a setter method
	            return 0;
	        } 
	        return -1;
	        
	    }
	    
	    
	    
	// Method to modify the password of a Chauffeur
	    
	    public int modifierMotDePasseChauffeur(String idChauffeur, String newPassword) {
	        // Call findChauffeurById from ChauffeurStype
	        ChauffeurType chauffeur = ServicesChauffeurs.findChauffeurById(idChauffeur,chauffeurs);

	        if (chauffeur != null) { // If a chauffeur is found
	            chauffeur.setMotDePasse(newPassword); // Update the password using a setter method
	            return 0;
	        } 
	        return -1;
	        
	    }
	    
	// Method to modify the email of a Chauffeur
	    
	    public int modifierEmailChauffeur(String idChauffeur, String newEmail) {
	        // Call findChauffeurById from ChauffeurStype
	        ChauffeurType chauffeur = ServicesChauffeurs.findChauffeurById(idChauffeur,chauffeurs);

	        if (chauffeur != null) { // If a chauffeur is found
	            chauffeur.setEmail(newEmail); // Update the email using a setter method
	            return 0;
	        } 
	        return -1;
	        
	    }
	    
	    
	// Method to modify the phone number of a Chauffeur
	    
	    public int modifierTelChauffeur(String idChauffeur, String newTel) {
	        // Call findChauffeurById from ChauffeurStype
	        ChauffeurType chauffeur = ServicesChauffeurs.findChauffeurById(idChauffeur,chauffeurs);

	        if (chauffeur != null) { // If a chauffeur is found
	            chauffeur.setTelephone(newTel); // Update the phone number using a setter method
	            return 0;
	        } 
	        return -1;
	        
	    }
	    
	   
	 // Method to add new Qualifications to an existing Chauffeur
	    
	    public int ajouterQualification(String permis, String libelle, String statut, String organisme , String description , String dateObtention 
	    		, String dateExpiration , String idChauffeur) {
	    	
	    	if(ServicesChauffeurs.findChauffeurById(idChauffeur,chauffeurs)!=null) {
	    	try {
	            // Validate and convert permis to PermisType
	            PermisType permisType = PermisType.valueOf(permis);

	            // Validate and convert statut to StatutQualifType
	            StatutQualifType statutQualifType = StatutQualifType.valueOf(statut);

	            // Validate other inputs (basic non-null and non-empty checks)
	            if (libelle == null || libelle.isEmpty() || 
	                organisme == null || organisme.isEmpty() ||
	                description == null || description.isEmpty() || 
	                dateObtention == null || dateObtention.isEmpty() || 
	                dateExpiration == null || dateExpiration.isEmpty() || 
	                idChauffeur == null || idChauffeur.isEmpty()) {
	                return -1; // Invalid input
	            }

	            // Call the method to add the qualification
	            ServiceQualifications.ajouterQualif(permisType, libelle, statutQualifType, organisme, description, 
	                          dateObtention, dateExpiration, idChauffeur);
	            return 0; // Success
	        } catch (IllegalArgumentException e) {
	            // This exception is thrown if the permis or statut does not match the enumeration
	            return -1; // Invalid permis or statut
	        } catch (Exception e) {
	            e.printStackTrace();
	            return -1; // General error
	        }
	    	}
	    	return -2;
	    	
	    }
	    		
	            
	    
	   //Method to Update the status of a chauffeur's qualification 
	    
	    public static int updateStatutQualif(String idQualification, String newStatutStr) {
	        try {
	            StatutQualifType newStatut = StatutQualifType.valueOf(newStatutStr);
	            QualificationType qualif = ServiceQualifications.getQualificationByID(idQualification,qualifications);
	            if (qualif != null) {
	                qualif.setStatutQualif(newStatut);
	                return 0; 
	            }
	        } catch (IllegalArgumentException e) {
	            return -1; // Invalid newStatut
	        }
	        return -1; // Qualification not found
	    }

	//Method to modify the expiration date of a qualification of a chauffeur 


	public int modifierQualificationDateExpiration(
	 		
	         ChauffeurStype chauffeurs,
	         QualificationStype qualifications,
	         String idChauffeur,
	         String newDateExpiration,
	         String idQualification){
	         
	     
	     QualificationType qualification = ServiceQualifications.getQualificationByID(idQualification,qualifications);

	     if (qualification != null) { 
	         
	     	qualification.setDateExpiration(newDateExpiration);
	     	
	             return 0;
	         }       
	     	return -1;
	}
	
	private static Unmarshaller createUnmarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(ResponsableStype.class);
	    Unmarshaller unmarshaller = context.createUnmarshaller();
	    unmarshaller.setSchema(schema); // Enable validation
	    return unmarshaller;
	}

	private static Marshaller createMarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schema = schemaFactory.newSchema(new File(schemaPath));

	    JAXBContext context = JAXBContext.newInstance(ResponsableStype.class);
	    Marshaller marshaller = context.createMarshaller();
	    marshaller.setSchema(schema); // Enable validation
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Pretty print
	    return marshaller;
	}

	
	
	public static void serializeResponsable(String filePath,String schemaPath) throws JAXBException {
	    if (responsables == null) {
	        throw new IllegalStateException("Responsables object is not initialized.");
	    }

	    Marshaller marshaller;
		try {
			marshaller = createMarshallerWithValidation(schemaPath);
			// Use validation
		    marshaller.marshal(responsables, new File(filePath));
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
	public static void deserializeResponsable(String filePath,String schemaPath) throws JAXBException, FileNotFoundException {
	    File file = new File(filePath);
	    if (!file.exists()) {
	        throw new FileNotFoundException("The file at " + filePath + " does not exist.");
	    }

	    Unmarshaller unmarshaller;
		try {
			unmarshaller = createUnmarshallerWithValidation(schemaPath);
			// Use validation
			responsables = (ResponsableStype) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
public static void ajouterResponsable(String login , String modpass, String nom, String prenom, String email, String tel, String dateNai) {
    	
    	ObjectFactory FactoryResponsable = new ObjectFactory();
    	ResponsableRHType resp=FactoryResponsable.createResponsableRHType();
    		
    		resp.setDateNaissance(dateNai);
    		resp.setDatePriseDePoste(generatedatePrisePoste());
    		resp.setEmail(email);
    		resp.setId(generateUniqueId("RESP",login));
    		resp.setLogin(login);
    		resp.setMotDePasse(modpass);
    		resp.setNom(nom);
    		resp.setPrenom(prenom);
    		resp.setStatutEmp(StatutEmployeType.DISPONIBLE);
    		resp.setTelephone(tel);
    		
    		
    		responsables.getResponsableRH().add(resp);
    		
    		
    }
	
	public static void addingResponsableToXML() {
		
		try {
	        String filePath = "/Users/khaoula/Desktop/projetXML/responsables.xml";
	        String schemaPath = "src/main/resources/xsd/Employe.xsd";
	        
	        deserializeResponsable(filePath, schemaPath); // Load and validate existing XML
	        

	        ajouterResponsable("02071389", "myRespFleetpass1", "Trabelsi", "Chokri", "ChokriResp@fleetman.com", "+21622800164", "10/10/1968");

	        // Serialize with validation
	        serializeResponsable(filePath, schemaPath);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	/*public static void main(String[] args) {
		addingResponsableToXML();
	}*/

}
