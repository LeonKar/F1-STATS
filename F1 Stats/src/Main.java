import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		int option=1;
		boolean cont=false;
		System.out.println("Eliga opcion de menu(introducir numero):");
		System.out.println("Admin menu:");
		do {
            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                option = sc.nextInt();
 
                switch (option) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        cont=true;
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        cont=true;
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        cont=true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }while(cont!=true);
	}
	public static void menuUser() {
		int option=1;
		boolean cont=false;
		System.out.println("Eliga opcion de menu(introducir numero):");
		System.out.println("User menu");
		do {
            System.out.println("1. Lista de pilotos");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                option = sc.nextInt();
 
                switch (option) {
                    case 1:
                        verPilotos();
                        cont=true;
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        cont=true;
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        cont=true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }while(cont!=true);
	}

	private static void verPilotos() {
		// TODO Auto-generated method stub
		try {
			JsonNode root = mapper.readTree(new File("pilotos.json"));
			JsonNode contactNode = root.path("pilotos");
            if (contactNode.isArray()) {
                for (JsonNode node : contactNode) {
                	String numero = node.path("numero").asText();
                    String nombre = node.path("nombre").asText();
                    String equipo = node.path("equipo").asText();
                    String chasis = node.path("chasis").asText();
                    String motor = node.path("motor").asText();
                    System.out.println("Numero: " + numero + ", nombre: " + nombre + ", equipo: " +
                    equipo + ", chasis: " + chasis + ", motor: " + motor);
                	
                }
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}