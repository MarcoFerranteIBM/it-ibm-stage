package start;

import utility.FileUtility;
import utility.StringUtility;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
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
				try {
		        	xml = StringUtility.toXML(io);
		    		
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				System.out.println("\n****************  Il file XML generato è:  ***********");
				System.out.println(xml);
			}
		}		
		
		json = StringUtility.toJson(io);
		System.out.println("****************  Il file JSON generato è:  ***********");
		System.out.println(json);
		
		/*try {
			//System.out.print(StringUtility.fromXML(xml));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
