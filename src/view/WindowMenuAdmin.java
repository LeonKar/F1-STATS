package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import control.AdminFunctions;
import control.Connection;

import javax.swing.JSeparator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WindowMenuAdmin extends JFrame{
	public JPanel panelMultiple;
	public JPanel panel_2;
	public JPanel panelTableUsers;
	JPanel btnEliminar;
	private JTable table;
	String nombre;
	
	AdminFunctions af = new AdminFunctions();
	
	@SuppressWarnings("serial")
	public WindowMenuAdmin() throws IOException {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(100, 100, 800, 600);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 561);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 270, 561);
		panelMenu.setBackground(new Color(13, 72, 162));
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(13, 72, 162));
		panel_1.setBounds(0, 0, 270, 101);
		panelMenu.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("F1");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 33, 270, 40);
		panel_1.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 71, 190, 2);
		panel_1.add(separator);
		
		JPanel panelUsers = new JPanel();
		panelUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUsers.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelUsers.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate(); 
				panelTableUsers.setVisible(true);
				panelMultiple.add(panelTableUsers);
				tablaUsers();
			}
		});
		panelUsers.setBackground(new Color(20, 91, 173));
		panelUsers.setBounds(0, 149, 270, 60);
		panelMenu.add(panelUsers);
		panelUsers.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GESTI\u00D3N DE USUARIOS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1.setBounds(0, 0, 270, 60);
		panelUsers.add(lblNewLabel_1);
		
		JPanel panelAdministradores = new JPanel();
		panelAdministradores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAdministradores.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelAdministradores.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
			}
		});
		panelAdministradores.setBackground(new Color(20, 91, 173));
		panelAdministradores.setBounds(0, 210, 270, 60);
		panelMenu.add(panelAdministradores);
		panelAdministradores.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("GESTI\u00D3N DE ADMINISTRADORES");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 0, 270, 60);
		panelAdministradores.add(lblNewLabel_1_1);
		
		JPanel panelPilotos = new JPanel();
		panelPilotos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelPilotos.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelPilotos.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
			}
		});
		panelPilotos.setBackground(new Color(20, 91, 173));
		panelPilotos.setBounds(0, 271, 270, 60);
		panelMenu.add(panelPilotos);
		panelPilotos.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("GESTI\u00D3N DE PILOTOS");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(0, 0, 270, 60);
		panelPilotos.add(lblNewLabel_1_1_1);
		
		JPanel panelExit = new JPanel();
		panelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelExit.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelExit.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panelExit.setBackground(new Color(20, 91, 173));
		panelExit.setBounds(0, 332, 270, 60);
		panelMenu.add(panelExit);
		panelExit.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SALIR");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(0, 0, 270, 60);
		panelExit.add(lblNewLabel_1_1_1_1);
		
		panelMultiple = new JPanel();
		panelMultiple.setBounds(269, 0, 515, 561);
		panel.add(panelMultiple);
		panelMultiple.setLayout(null);
		
		panelTableUsers = new JPanel();
		panelTableUsers.setBackground(Color.WHITE);
		panelTableUsers.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelTableUsers);
		panelTableUsers.setVisible(false);
		panelTableUsers.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 226, 495, 324);
		panelTableUsers.add(scrollPane);
		
		table = new JTable() {
			@SuppressWarnings("unused")
			public boolean isCellEditable(int row, int column) {
			    return false;
			}
		};
		table.setSelectionBackground(new Color(25, 118, 209));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				nombre = (String) table.getModel().getValueAt(row, 0);
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 41, 515, 119);
		panel_4.setBackground(new Color(25, 118, 209));
		panelTableUsers.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("TABLA DE USUARIOS");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 0, 515, 119);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Ebrima", Font.BOLD, 18));
		
		btnEliminar = new JPanel();
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setBackground(new Color(20, 91, 173));
			}
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowUser = table.getSelectedRow();
				JSONObject obj = new JSONObject();
				JSONArray jrr = new JSONArray();
				Object ob = null;
				JSONParser jp = new JSONParser();
				
				try {
					FileReader file = new FileReader("userbase.json");
					ob = jp.parse(file);
					jrr=(JSONArray) ob;
					file.close();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					FileWriter file = new FileWriter("userbase.json");
					jrr.remove(rowUser);
					file.write(jrr.toJSONString());
					file.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tablaUsers();
			}
		});
		btnEliminar.setBounds(350, 171, 155, 44);
		btnEliminar.setBackground(new Color(20, 101, 193));
		panelTableUsers.add(btnEliminar);
		btnEliminar.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("ELIMINAR");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(0, 0, 155, 44);
		btnEliminar.add(lblNewLabel_4);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(25, 118, 209));
		panel_4_1.setBounds(0, 41, 515, 120);
		panelMultiple.add(panel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("ESTADISTICA DE FORMULA 1");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(0, 0, 515, 119);
		panel_4_1.add(lblNewLabel_3_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 182, 160, 44);
		panelMultiple.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(0, 0, 160, 44);
		panel_3.add(lblBienvenido);
		lblBienvenido.setFont(new Font("Ebrima", Font.BOLD, 18));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.MAGENTA);
		panel_2.setBounds(0, 0, 515, 561);
	}
	public void tablaUsers() {
		JSONArray jrr = new JSONArray();
		jrr = af.leerFichero("userbase.json");
		int size = jrr.size();
		
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Correo");
		model.addColumn("Role");
		
		Object [] filas = new Object[3];
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String name = (String) row.get("username");
			String correo = (String) row.get("correo");
			String role = (String) row.get("role");
			filas[0] = name;
			filas[1] = correo;
			filas[2] = role;
			model.addRow(filas);
		}
	}
}