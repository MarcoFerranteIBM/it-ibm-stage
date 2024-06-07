package utility;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Stagista;

public class StringUtility {

	public static String toJson(Stagista s) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		return gson.toJson(s);

	}

	public static String toXML(Stagista s) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Stagista.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		marshaller.marshal(s, sw);

		String xmlString = sw.toString();

		return xmlString;

	}

	public static ArrayList<Stagista> fromJson(String str) {

		ArrayList<Stagista> stagisti = new ArrayList<Stagista>();
		Gson json = new Gson();

		JsonObject jsonObject = JsonParser.parseString(str).getAsJsonObject();
		JsonArray jsonArray = jsonObject.getAsJsonArray("utenti");

		for (JsonElement jsonElement : jsonArray) {
			stagisti.add(json.fromJson(jsonElement, Stagista.class));
		}

		return stagisti;

	}

	public static Stagista fromXML(String s) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(Stagista.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(s);

		Stagista stagista = (Stagista) unmarshaller.unmarshal(reader);

		return stagista;

	}
}
