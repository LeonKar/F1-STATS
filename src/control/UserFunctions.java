package control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserFunctions {
	public JSONArray leerFichero(String nombreFichero) {
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader(nombreFichero);
			ob = jp.parse(file);
			jrr=(JSONArray) ob;
			file.close();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jrr;
	}
}