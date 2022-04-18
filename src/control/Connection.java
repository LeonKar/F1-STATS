package control;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.WindowLogin;
import view.WindowRegistrarse;


public class Connection {
	public static int idUser = 0;
	/*
	public static String login (String nickname, String password){
		String check="error";
		try {
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT idusers, PASSWORD, ROLE FROM USERS WHERE NICKNAME='"+ nickname +"'");
		if(rs.next()){
			idUser = rs.getInt("idusers");
			System.out.println("idUser " + idUser);
			if(password.equals(rs.getString("PASSWORD"))) {
				if((rs.getString("ROLE")).equals("admin")) {
					check = "admin";
				}
				if((rs.getString("ROLE")).equals("user")) {
					check = "user";
				}
			}
		}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	public static void registrarUsuario (String nickname, String password){
		try {
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT nickname FROM USERS WHERE NICKNAME='"+ nickname +"'");
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Usuario con este nombre ya existe", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			} else {
				stmt.executeUpdate("insert into users (nickname, password, ROLE) values('" + nickname + "', '" + password + "', 'user')");
				stmt.close();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de registro", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void registrarAdmin (String nickname, String password){
		try {
		Statement stmt = connect.createStatement();
		stmt.executeUpdate("insert into users (nickname, password, ROLE) values('" + nickname + "', '" + password + "', 'admin')");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de registro", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void modificarPiloto (int idpiloto, int numero, String nombre, String equipo, String nacionalidad, String fecha_nacim, int campeonatos_ganados){
		try {
			PreparedStatement pstmt = connect.prepareStatement("update pilotos set numero = " + numero + ", nombre = '" + nombre + "', equipo = '" + equipo + "', nacionalidad = '" + nacionalidad + "', fecha_nacim = '"
				+ fecha_nacim + "', campeonatos_ganados = '" + campeonatos_ganados + "' where idpiloto = " + idpiloto);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de modificacón", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}*/
}