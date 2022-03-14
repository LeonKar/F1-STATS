import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import model.Login;

public class Main {
	protected ArrayList<Login> loginList = new ArrayList<Login>();
	static Scanner sc = new Scanner(System.in);
    private static final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		System.out.println("Estadistica F1");
		String login="", password="", check;
		System.out.println("Introduzca su login:");
		login = sc.next();
		System.out.println("Introduzca su contraseña:");
		password = sc.next();
		check = login(login, password);
		if(check.equals("error")) {
			System.out.println("Login o contraseña incorrecto");
		}else {
			menu(check);
		}
		sc.close();
	}
	
	public static String login(String login, String password) throws FileNotFoundException, IOException, ParseException{
		String check="error";
		try {
			JsonNode root = mapper.readTree(new File("userbase.json"));
			JsonNode contactNode = root.path("users");
            if (contactNode.isArray()) {
                for (JsonNode node : contactNode) {
                	String usr = node.path("Username").asText();
                    String pswd = node.path("Password").asText();
                    String rl = node.path("Role").asText();
                    //System.out.println("Username : " + usr);
                	if(login.equals(usr)&&password.equals(pswd)&&rl.equals("admin")) {
            			System.out.println("Hola admin");
            			check="admin";
            		}else if(login.equals(usr)&&password.equals(pswd)&&rl.equals("user")){
            			System.out.println("Hola user");
            			check="user";
            		}
                }
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}
	
	public static void menu(String check) {
		if(check=="admin") {
			menuAdmin();
		}else if(check=="user") {
			menuUser();
		}
	}
	public static void menuAdmin() {
		int option=0;
		System.out.println("Eliga opcion de menu(introducir numero):");
		System.out.println("Admin menu:");
		System.out.println("1)Option 1\n2)Option 2");
		do {
			option=sc.nextInt();
		    while (!sc.hasNextInt()) {
		        System.out.println("Introduzca un numero por favor");
		        option = sc.nextInt();
		    }
		} while (sc.hasNextInt());
	switch(option) {
		case 1:
			System.out.println("Has elegido menu admin 1");
		break;
		case 2:
			System.out.println("Has elegido menu admin 2");
		break;
	}
	}
	public static void menuUser() {
		int option=0;
		System.out.println("Eliga opcion de menu(introducir numero):");
		System.out.println("User menu");
		System.out.println("1)Option 1\n2)Option 2");
		try {
			option = sc.nextInt();
			if((option<1)||(option>3)) {
				System.out.println("No existe opcion");
				System.out.println("Introduzca de nuevo:");
				option = sc.nextInt();
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No existe opcion");
			System.out.println("Introduzca de nuevo:");
			option = sc.nextInt();
		}
		switch(option) {
		case 1:
			System.out.println("Has elegido menu user 1");
		break;
		case 2:
			System.out.println("Has elegido menu user 2");
		break;
		}
	}
}