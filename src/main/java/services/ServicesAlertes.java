package services;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.fleetman.alertes.AlerteStype;
import com.fleetman.alertes.AlerteType;
import com.fleetman.alertes.ObjectFactory;
import com.fleetman.alertes.StatutAlerteType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class ServicesAlertes {
	
	private static AlerteStype alertes=new AlerteStype();
	
private static final AtomicInteger COUNTER = new AtomicInteger(0);
	
	public static String generateUniqueId() {
        int uniqueNumber = COUNTER.getAndIncrement();
        return String.format("A-%08d", uniqueNumber); 
    }
	private static void initializeCounter() {
	    if (alertes != null && alertes.getAlerte() != null) {
	        int maxId = alertes.getAlerte().stream()
	            .map(alert -> alert.getIdAlerte().replace("A-", ""))
	            .mapToInt(Integer::parseInt)
	            .max()
	            .orElse(0); // Default to 0 if no IDs are present
	        COUNTER.set(maxId + 1);
	    }
	}


//Add a new Alerte to the collection

public static void saisirFormulaireAlerte(String idChauffeur, String idVehicule ,String idTrajet,String typeAlerte ,String description) {
		
		ObjectFactory factoryAlerte = new ObjectFactory();
		
		AlerteType alerte=factoryAlerte.createAlerteType();
			
			alerte.setIdChauff(idChauffeur);
			alerte.setIdVehic(idVehicule);
			alerte.setIdTraj(idTrajet);
			alerte.setTypeAlerte(typeAlerte);
			alerte.setDescription(description);
			
			alerte.setIdAlerte(generateUniqueId());
			alerte.setStatutAlerte(StatutAlerteType.EN_ATTENTE);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
            alerte.setDateAlerte(LocalDate.now().format(formatter));
			
			alertes.getAlerte().add(alerte);
			
	}

//Method to find a Alerte by ID

public static AlerteType findAlerteById(String id) {
    for (AlerteType alert : alertes.getAlerte()) {
        if (alert.getIdAlerte().equals(id)) {
            return alert;
        }
    }
    return null; // Not found
}


private static Unmarshaller createUnmarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(new File(schemaPath));

    JAXBContext context = JAXBContext.newInstance(AlerteStype.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    unmarshaller.setSchema(schema); // Enable validation
    return unmarshaller;
}

private static Marshaller createMarshallerWithValidation(String schemaPath) throws JAXBException, SAXException {
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(new File(schemaPath));

    JAXBContext context = JAXBContext.newInstance(AlerteStype.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setSchema(schema); // Enable validation
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Pretty print
    return marshaller;
}



public static void serializeAlertes(String filePath,String schemaPath) throws JAXBException {
    if (alertes == null) {
        throw new IllegalStateException("Alertes object is not initialized.");
    }

    Marshaller marshaller;
	try {
		marshaller = createMarshallerWithValidation(schemaPath);
		// Use validation
	    marshaller.marshal(alertes, new File(filePath));
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}


public static void deserializeAlertes(String filePath,String schemaPath) throws JAXBException, FileNotFoundException {
    File file = new File(filePath);
    if (!file.exists()) {
        throw new FileNotFoundException("The file at " + filePath + " does not exist.");
    }

    Unmarshaller unmarshaller;
	try {
		unmarshaller = createUnmarshallerWithValidation(schemaPath);
		// Use validation
		alertes = (AlerteStype) unmarshaller.unmarshal(file);
	    initializeCounter();
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}

public static void addingAlerteToXML() {
	
	try {
        String filePath = "/Users/khaoula/Desktop/projetXML/alertes.xml";
        String schemaPath = "src/main/resources/xsd/SignalerAlertes.xsd";
        
        deserializeAlertes(filePath, schemaPath); // Load and validate existing XML
        

        saisirFormulaireAlerte("CH-02072356", "VH-00000003","TRJ-00000001","type alerte1","description1" );

        // Serialize with validation
        serializeAlertes(filePath, schemaPath);

    } catch (Exception e) {
        e.printStackTrace();
    }
	
}

public static void main(String[] args) {
	addingAlerteToXML();
}

}
