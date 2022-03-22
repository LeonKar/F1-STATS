import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

import model.Login;

public class Main {
	protected ArrayList<Login> loginList = new ArrayList<Login>();
	static Scanner sc = new Scanner(System.in);
    private static final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		int option=1;
		boolean cont=false;
		do {
			System.out.println("Estadistica F1");
			System.out.println("1. Regisrarse");
			System.out.println("2. Login");
            try {
                System.out.println("Escribe una de las opciones");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Registro en proceso");
                        cont=true;
                        break;
                    case 2:
                    	String login="", password="", check;
                		do {
                		System.out.println("Estadistica F1");
                		System.out.println("Introduzca su login:");
                		login = sc.next();
                		System.out.println("Introduzca su contraseña:");
                		password = sc.next();
                		
                			check = login(login, password);
                			if(check.equals("error")) {
                				System.out.println("Login o contraseña incorrecto\n");
                			}else {
                				menu(check);
                			}
                		}while(check=="error");
                		sc.close();
                        cont=true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }while(cont!=true);	
	}
	
	public static String login(String login, String password) throws FileNotFoundException, IOException, ParseException{
		String check="error";
		try {
			
			JsonNode root = mapper.readTree(new File("userbase.json"));
			JsonNode contactNode = root.path("users");
			
			/*Login lgn = new Login("1", "2", "3");
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(Paths.get("userbase.json").toFile(), lgn);
			 */
	        
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
		System.out.println("Menu\nEliga opcion de menu(introducir numero):");
		do {
            System.out.println("1. Eliminar usuario");
            System.out.println("2. Modificar estadistica");
            System.out.println("3. Añadir estadistica");
            System.out.println("4. Añadir usuario admin");
 
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
		System.out.println("Clasificación:");
		
		System.out.println("Proxima carrera: ");
		
		System.out.println("\nMenu\nEliga opcion de menu(introducir numero):");
		do {
			System.out.println("1. Editar el perfil de usuario");
            System.out.println("2. Ver lista de pilotos");
            System.out.println("3. Ver lista de carreras GP");
            System.out.println("4. Clasificación del campeonato de constructores");
            System.out.println("5. Ver caracteristicas tecnicas de los coches");
            System.out.println("6. Mejores tiempos por circuito de cada piloto");
            System.out.println("7. Ultimos resultados");
            System.out.println("8. Comparativa entre pilotos");
            System.out.println("9. Simulación de puntos");
            try {
 
                System.out.println("Escribe una de las opciones");
                option = sc.nextInt();
 
                switch (option) {
                    case 1:
                    	System.out.println("Has seleccionado la opcion 1");
                        cont=true;
                        break;
                    case 2:
                    	verPilotos();
                        cont=true;
                        break;
                        
                    case 3:
                    	verCarrerasGP();
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

	private static void verCarrerasGP() {
		// TODO Auto-generated method stub
		System.out.println("\nLista de carreras GP:\n");
		try {
			JsonNode root = mapper.readTree(new File("lista_carreras_gp.json"));
			JsonNode contactNode = root.path("lista_GP");
            if (contactNode.isArray()) {
                for (JsonNode node : contactNode) {
                	String nombre_circuito = node.path("nombre_circuito").asText();
                    String lugar = node.path("lugar").asText();
                    String distancia = node.path("distancia").asText();
                    String fecha = node.path("fecha").asText();
                    System.out.println("\tNombre circuito: " + nombre_circuito + ", lugar: " + lugar + ", distancia: " +
                    		distancia + ", fecha: " + fecha);
                	
                }
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void verPilotos() {
		// TODO Auto-generated method stub
		System.out.println("\nPilotos de la Fórmula 1:\n");
		try {
			JsonNode root = mapper.readTree(new File("pilotos.json"));
			JsonNode contactNode = root.path("pilotos");
            if (contactNode.isArray()) {
                for (JsonNode node : contactNode) {
                	String numero = node.path("numero").asText();
                    String nombre = node.path("nombre").asText();
                    String equipo = node.path("equipo").asText();
                    String nacionalidad = node.path("nacionalidad").asText();
                    String edad = node.path("edad").asText();
                    String campeonatos_ganados = node.path("campeonatos_ganados").asText();
                    System.out.println("\tNumero: " + numero + ", nombre: " + nombre + ", equipo: " +
                    equipo + ", nacionalidad: " + nacionalidad + ", edad: " + edad + ", campeonatos ganados: " + campeonatos_ganados);
                	
                }
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}