package start;

import utility.FileUtility;
import utility.StringUtility;

import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Stagista;

public class Main {

	public static void main(String[] args) {
		
		Stagista io = null;
		ArrayList <Stagista>listaStagisti;
		
		final String FILE_NAME = "user.json";
		byte[] dati = FileUtility.getFileFromInternalResources(FILE_NAME);

		String json = new String(dati);
		String xml = null;
		
		listaStagisti = StringUtility.fromJson(json);
		
		for(Stagista stagista: listaStagisti) {
			String nome = stagista.getNome().toLowerCase();
			
			if(nome.equals("marco")) {
				io = stagista;
				io.setEta(25);
				
			}
		}
		
		
		

		System.out.println("****************  Il file JSON generato è:  ***********");
		System.out.println(StringUtility.toJson(io));
		
		
        try {
    		System.out.println("\n****************  Il file XML  generato è:  ***********");
			System.out.println(StringUtility.toXML(io));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		 
		
		
		
		
		
		
		

	}

}
