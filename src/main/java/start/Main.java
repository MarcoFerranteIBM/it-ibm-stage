package start;

import utility.FileUtility;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Stagista;

public class Main {

	public static void main(String[] args) {

		final String FILE_NAME = "user.json";
		byte[] dati = FileUtility.getFileFromInternalResources(FILE_NAME);

		String str = new String(dati);
		Gson json = new Gson();
		Stagista io = new Stagista("Marco","Ferrante","M");
		
		ArrayList<Stagista> stagisti = new ArrayList<Stagista>();
		
		JsonObject jsonObject = JsonParser.parseString(str).getAsJsonObject();

        // Ottenere l'array di utenti
        JsonArray jsonArray = jsonObject.getAsJsonArray("utenti");

		for(JsonElement jsonElement: jsonArray) {

			stagisti.add(json.fromJson(jsonElement, Stagista.class));
			if(stagisti.getLast().equals(io)) {
				System.out.println("eccomi");
			}
		}
		
		
		

	}

}
