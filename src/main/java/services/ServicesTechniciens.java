package services;

import java.io.File;


import com.fleetman.employe.TechnicienStype;
import com.fleetman.employe.TechnicienType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class ServicesTechniciens {
	
	public static TechnicienStype techniciens= new TechnicienStype();
	
	
// Method to find a Technicien by ID
    
    public static TechnicienType findTechnicienById(String id,  TechnicienStype techniciens) {
    	
        File file = new File("/Users/khaoula/Desktop/projetXML/techniciens.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(TechnicienStype.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            techniciens = (TechnicienStype) unmarshaller.unmarshal(file);
            if (techniciens != null && !techniciens.getTechnicien().isEmpty()) {
                for (TechnicienType tech : techniciens.getTechnicien()) {
                    if (tech.getId().equals(id)) {
                        return tech;
                    }
                }
            } else {
                System.out.println("No techniciens found in the XML file.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return null; // Not found
    }

}
