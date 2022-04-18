package control;

import java.awt.EventQueue;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import view.WindowLogin;
import view.WindowMenuUser;
import view.WindowMenuAdmin;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.*;

import model.User;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowLogin frame = new WindowLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static void login(String login, String password) throws IOException {
		boolean check = false;
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("userbase.json");
			ob = jp.parse(file);
			jrr=(JSONArray) ob;
			file.close();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = jrr.size();
		obj.put("username", login);
		obj.put("password", password);
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String name = (String) row.get("username");
			String psswd = (String) row.get("password");
			String role = (String) row.get("role");
			if(obj.get("username").equals(name)&&obj.get("password").equals(psswd)) {
				if(role.equals("admin")) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								WindowMenuAdmin frame = new WindowMenuAdmin();
								frame.setVisible(true);
								WindowLogin windowLogin = new WindowLogin();
								windowLogin.closeFrame();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}else if(role.equals("user")) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								WindowMenuUser frame = new WindowMenuUser();
								frame.setVisible(true);
								WindowLogin windowLogin = new WindowLogin();
								windowLogin.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				check = true;
			}
		}
		if(!check) {
			JOptionPane.showMessageDialog(null, "Login o password incorrecto, prueba de nuevo", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void registrarse(String login, String password) throws IOException {
		boolean newUser = true;
		/*
        if(login.equals(usr)) {
			JOptionPane.showMessageDialog(null, "Usuario con este nombre ya existe", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			newUser = false;
        }*/
		if(newUser) {
			JSONObject obj = new JSONObject();
			JSONArray jrr = new JSONArray();
			JSONArray jrr2 = new JSONArray();
			JSONParser jp = new JSONParser();
			
			try {
				FileReader file = new FileReader("userbase.json");
				jrr =  (JSONArray)jp.parse(file);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			obj.put("username", login);
			obj.put("password", password);
			obj.put("role", "user");
			
			int size = jrr.size();
			boolean registro = true;
			for(int i=0; i<size; i++) {
				JSONObject row = (JSONObject) jrr.get(i);
				String name = (String) row.get("username");
				String name2 = (String) obj.get("username");
				if(name.equals(name2)) {
					registro = false;
				}
			}
			if(!registro) {
				JOptionPane.showMessageDialog(null, "Usuario ya existe", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			}else {
				jrr.add(obj);
				
				try {
					FileWriter file = new FileWriter("userbase.json");
					file.write(jrr.toJSONString());
					file.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Has registrado en sistema, ahora puedes entrar", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowLogin frame = new WindowLogin();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}
	public static void registrarAdmin(String login, String password) throws IOException {
		//Connection.registrarAdmin(login, password);
		JOptionPane.showMessageDialog(null, "Has registrado usuario admin", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	@SuppressWarnings("static-access")
	public void modificarPiloto(int idpiloto, int numero, String nombre, String equipo, String nacionalidad, String fecha_nacim, int campeonatos_ganados) {
		// TODO Auto-generated method stub
		Connection mc = new Connection();
		//mc.modificarPiloto(idpiloto, numero, nombre, equipo, nacionalidad, fecha_nacim, campeonatos_ganados);
	}
}