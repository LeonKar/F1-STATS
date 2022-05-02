package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import control.AdminFunctions;
import control.Connection;
import control.Main;
import control.UserFunctions;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class WindowMenuUser extends JFrame{
	public JPanel panelMultiple;
	public JPanel panel_2;
	JPanel panelPilotos;
	JPanel panelTablePilotos;
	JPanel panelTableCarreras;
	JPanel panelPerfilUsuario;
	JPanel panelClasificacion;
	JPanel panelCaracteristicas;
	JComboBox comboBox;
	String []cmbxSexo = {"HOMBRE", "MUJER"};
	String nombre;
	private JTable tablePilotos;
	private JTable tableCarreras;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtFechaN;
	private JTable tableInfo;
	private JTable tableCaracteristicas;
	
	UserFunctions uf = new UserFunctions();
	
	@SuppressWarnings("serial")
	public WindowMenuUser() throws IOException {
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
		
		JPanel panelPerfil = new JPanel();
		panelPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelPerfil.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelPerfil.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
				panelPerfilUsuario.setVisible(true);
				panelMultiple.add(panelPerfilUsuario);
				consultPerfil();
			}
			
		});
		panelPerfil.setBackground(new Color(20, 91, 173));
		panelPerfil.setBounds(0, 210, 270, 60);
		panelMenu.add(panelPerfil);
		panelPerfil.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PERFIL");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1.setBounds(0, 0, 270, 60);
		panelPerfil.add(lblNewLabel_1);
		
		JPanel panelCarreras = new JPanel();
		panelCarreras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelCarreras.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelCarreras.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate(); 
				panelTableCarreras.setVisible(true);
				panelMultiple.add(panelTableCarreras);
				tablaCarreras();
			}
		});
		panelCarreras.setBackground(new Color(20, 91, 173));
		panelCarreras.setBounds(0, 271, 270, 60);
		panelMenu.add(panelCarreras);
		panelCarreras.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("LISTA DE CARRERAS");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 0, 270, 60);
		panelCarreras.add(lblNewLabel_1_1);
		
		panelPilotos = new JPanel();
		
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
				panelTablePilotos.setVisible(true);
				panelMultiple.add(panelTablePilotos);
				tablaPilotos();
			}
		});
		panelPilotos.setBackground(new Color(20, 91, 173));
		panelPilotos.setBounds(0, 332, 270, 60);
		panelMenu.add(panelPilotos);
		panelPilotos.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("LISTA DE PILOTOS");
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
		panelExit.setBounds(0, 454, 270, 60);
		panelMenu.add(panelExit);
		panelExit.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SALIR");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(0, 0, 270, 60);
		panelExit.add(lblNewLabel_1_1_1_1);
		
		JPanel panelClasificacionMenu = new JPanel();
		panelClasificacionMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelClasificacionMenu.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelClasificacionMenu.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
				panelClasificacion.setVisible(true);
				panelMultiple.add(panelClasificacion);
				tablaClasificacion();
			}
		});
		panelClasificacionMenu.setLayout(null);
		panelClasificacionMenu.setBackground(new Color(20, 91, 173));
		panelClasificacionMenu.setBounds(0, 149, 270, 60);
		panelMenu.add(panelClasificacionMenu);
		
		JLabel lblClasificacion = new JLabel("CLASIFICACI\u00D3N");
		lblClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacion.setForeground(Color.WHITE);
		lblClasificacion.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblClasificacion.setBounds(0, 0, 270, 60);
		panelClasificacionMenu.add(lblClasificacion);
		
		JPanel panelCaracteristicasMenu = new JPanel();
		panelCaracteristicasMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelCaracteristicasMenu.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelCaracteristicasMenu.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
				panelCaracteristicas.setVisible(true);
				panelMultiple.add(panelCaracteristicas);
				tablaCaracteristicas();
			}
		});
		panelCaracteristicasMenu.setLayout(null);
		panelCaracteristicasMenu.setBackground(new Color(20, 91, 173));
		panelCaracteristicasMenu.setBounds(0, 393, 270, 60);
		panelMenu.add(panelCaracteristicasMenu);
		
		JLabel lblCaracteristicas = new JLabel("CARACTERISTICAS");
		lblCaracteristicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaracteristicas.setForeground(Color.WHITE);
		lblCaracteristicas.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblCaracteristicas.setBounds(0, 0, 270, 60);
		panelCaracteristicasMenu.add(lblCaracteristicas);
		
		panelMultiple = new JPanel();
		panelMultiple.setBackground(Color.WHITE);
		panelMultiple.setBounds(269, 0, 515, 561);
		panel.add(panelMultiple);
		panelMultiple.setLayout(null);
		
		JPanel panelEst = new JPanel();
		panelEst.setLayout(null);
		panelEst.setBackground(new Color(25, 118, 209));
		panelEst.setBounds(0, 41, 515, 120);
		panelMultiple.add(panelEst);
		
		JLabel lblNewLabel_3_1 = new JLabel("ESTADISTICA DE FORMULA 1");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(0, 0, 515, 119);
		panelEst.add(lblNewLabel_3_1);
		
		JPanel panelBnv = new JPanel();
		panelBnv.setBackground(Color.WHITE);
		panelBnv.setBounds(20, 182, 160, 44);
		panelMultiple.add(panelBnv);
		panelBnv.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(0, 0, 160, 44);
		panelBnv.add(lblBienvenido);
		lblBienvenido.setFont(new Font("Ebrima", Font.BOLD, 18));
		
		panelTablePilotos = new JPanel();
		panelTablePilotos.setBackground(Color.WHITE);
		panelTablePilotos.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelTablePilotos);
		panelTablePilotos.setLayout(null);
		panelTablePilotos.setVisible(false);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBounds(0, 41, 515, 120);
		panel_4_1_1.setBackground(new Color(25, 118, 209));
		panelTablePilotos.add(panel_4_1_1);
		panel_4_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("LISTA DE PILOTOS");
		lblNewLabel_3_1_1.setBounds(0, 0, 515, 119);
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		panel_4_1_1.add(lblNewLabel_3_1_1);
		
		JScrollPane scrollPanePilotos = new JScrollPane();
		scrollPanePilotos.setBounds(10, 226, 495, 324);
		panelTablePilotos.add(scrollPanePilotos);
		
		tablePilotos = new JTable(){
			@SuppressWarnings("unused")
			public boolean isCellEditable(int row, int column) {
			    return false;
			}
		};
		tablePilotos.setSelectionBackground(new Color(25, 118, 209));
		tablePilotos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//int row = tablePilotos.getSelectedRow();
				//nombre = (String) tablePilotos.getModel().getValueAt(row, 0);
			}
		});
		scrollPanePilotos.setViewportView(tablePilotos);
		
		panelTableCarreras = new JPanel();
		panelTableCarreras.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelTableCarreras);
		panelTableCarreras.setLayout(null);
		panelTableCarreras.setVisible(false);
		
		JPanel panelLblCarreras = new JPanel();
		panelLblCarreras.setBounds(0, 41, 515, 120);
		panelLblCarreras.setLayout(null);
		panelLblCarreras.setBackground(new Color(25, 118, 209));
		panelTableCarreras.add(panelLblCarreras);
		
		JLabel lblCarreras = new JLabel("LISTA DE CARRERAS");
		lblCarreras.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarreras.setForeground(Color.WHITE);
		lblCarreras.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblCarreras.setBounds(0, 0, 515, 119);
		panelLblCarreras.add(lblCarreras);
		
		JScrollPane scrollPaneCarreras = new JScrollPane();
		scrollPaneCarreras.setBounds(10, 226, 495, 324);
		panelTableCarreras.add(scrollPaneCarreras);
		
		tableCarreras = new JTable(){
			@SuppressWarnings("unused")
			public boolean isCellEditable(int row, int column) {
			    return false;
			}
		};
		tableCarreras.setSelectionBackground(new Color(25, 118, 209));
		tableCarreras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//int row = tableCarreras.getSelectedRow();
				//nombre = (String) tableCarreras.getModel().getValueAt(row, 0);
			}
		});
		scrollPaneCarreras.setViewportView(tableCarreras);
		
		panelPerfilUsuario = new JPanel();
		panelPerfilUsuario.setBackground(Color.WHITE);
		panelPerfilUsuario.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelPerfilUsuario);
		panelPerfilUsuario.setLayout(null);
		panelPerfilUsuario.setVisible(false);
		
		JPanel panelLblPerfil = new JPanel();
		panelLblPerfil.setBounds(0, 41, 515, 120);
		panelLblPerfil.setBackground(new Color(25, 118, 209));
		panelPerfilUsuario.add(panelLblPerfil);
		panelLblPerfil.setLayout(null);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setBounds(0, 0, 515, 120);
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Ebrima", Font.BOLD, 18));
		panelLblPerfil.add(lblPerfil);
		
		JPanel panelLblNombre = new JPanel();
		panelLblNombre.setBackground(Color.WHITE);
		panelLblNombre.setBounds(20, 181, 160, 25);
		panelPerfilUsuario.add(panelLblNombre);
		panelLblNombre.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNombre.setBounds(0, 0, 160, 25);
		panelLblNombre.add(lblNombre);
		
		JPanel paneltxtNombre = new JPanel();
		paneltxtNombre.setBounds(189, 181, 190, 25);
		panelPerfilUsuario.add(paneltxtNombre);
		paneltxtNombre.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtNombre.setBorder(null);
		txtNombre.setBounds(0, 0, 190, 25);
		paneltxtNombre.add(txtNombre);
		txtNombre.setColumns(10);
		
		JSeparator separatorNombre = new JSeparator();
		separatorNombre.setBackground(Color.BLACK);
		separatorNombre.setBounds(189, 205, 170, 2);
		panelPerfilUsuario.add(separatorNombre);
		
		JPanel panelLblApellido = new JPanel();
		panelLblApellido.setLayout(null);
		panelLblApellido.setBackground(Color.WHITE);
		panelLblApellido.setBounds(20, 217, 160, 25);
		panelPerfilUsuario.add(panelLblApellido);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblApellido.setBounds(0, 0, 160, 25);
		panelLblApellido.add(lblApellido);
		
		JPanel paneltxtApellido = new JPanel();
		paneltxtApellido.setLayout(null);
		paneltxtApellido.setBounds(189, 217, 190, 25);
		panelPerfilUsuario.add(paneltxtApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBorder(null);
		txtApellido.setBounds(0, 0, 190, 25);
		paneltxtApellido.add(txtApellido);
		
		JSeparator separatorNombre_1 = new JSeparator();
		separatorNombre_1.setBackground(Color.BLACK);
		separatorNombre_1.setBounds(189, 241, 170, 2);
		panelPerfilUsuario.add(separatorNombre_1);
		
		comboBox = new JComboBox(cmbxSexo);
		comboBox.setFont(new Font("Ebrima", Font.PLAIN, 14));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(189, 253, 170, 25);
		panelPerfilUsuario.add(comboBox);
		
		JPanel panelLblSexo = new JPanel();
		panelLblSexo.setLayout(null);
		panelLblSexo.setBackground(Color.WHITE);
		panelLblSexo.setBounds(20, 253, 160, 25);
		panelPerfilUsuario.add(panelLblSexo);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblSexo.setBounds(0, 0, 160, 25);
		panelLblSexo.add(lblSexo);
		
		JPanel panelLblCorreo = new JPanel();
		panelLblCorreo.setLayout(null);
		panelLblCorreo.setBackground(Color.WHITE);
		panelLblCorreo.setBounds(20, 289, 160, 25);
		panelPerfilUsuario.add(panelLblCorreo);
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblCorreo.setBounds(0, 0, 160, 25);
		panelLblCorreo.add(lblCorreo);
		
		JPanel panelLblFechaN = new JPanel();
		panelLblFechaN.setLayout(null);
		panelLblFechaN.setBackground(Color.WHITE);
		panelLblFechaN.setBounds(20, 325, 160, 25);
		panelPerfilUsuario.add(panelLblFechaN);
		
		JLabel lblFechaN = new JLabel("FECHA NACIMIENTO");
		lblFechaN.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblFechaN.setBounds(0, 0, 160, 25);
		panelLblFechaN.add(lblFechaN);
		
		JPanel paneltxtCorreo = new JPanel();
		paneltxtCorreo.setLayout(null);
		paneltxtCorreo.setBounds(189, 289, 190, 25);
		panelPerfilUsuario.add(paneltxtCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(0, 0, 190, 25);
		paneltxtCorreo.add(txtCorreo);
		
		JPanel paneltxtFechaN = new JPanel();
		paneltxtFechaN.setLayout(null);
		paneltxtFechaN.setBounds(189, 326, 190, 25);
		panelPerfilUsuario.add(paneltxtFechaN);
		
		txtFechaN = new JTextField();
		txtFechaN.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtFechaN.setColumns(10);
		txtFechaN.setBorder(null);
		txtFechaN.setBounds(0, 0, 190, 25);
		paneltxtFechaN.add(txtFechaN);
		
		JPanel panelGuardar = new JPanel();
		panelGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelGuardar.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelGuardar.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JSONObject obj = new JSONObject();
				JSONArray jrr = new JSONArray();
				JSONParser jp = new JSONParser();
				
				try {
					FileReader file = new FileReader("userbase.json");
					jrr =  (JSONArray)jp.parse(file);
				} catch (ParseException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for(int i=0; i<jrr.size(); i++) {
					JSONObject row = (JSONObject) jrr.get(i);
					String nick = (String) row.get("username");
					if(nick.equals(Main.nickname)) {
						String password = (String) row.get("password");
						obj.put("password", password);
						obj.put("role", "user");
						obj.put("username", Main.nickname);
						obj.put("correo", txtCorreo.getText());
						if(comboBox.getSelectedItem().equals("HOMBRE")) {
							obj.put("sexo", "hombre");
						}else if(comboBox.getSelectedItem().equals("MUJER")){
							obj.put("sexo", "mujer");
						}
						obj.put("fecha_nacim", txtFechaN.getText());
						obj.put("nombre", txtNombre.getText());
						obj.put("apellido", txtApellido.getText());
						
						if(nick!=null) {
							jrr.remove(i);
						}
					}
				}
				jrr.add(obj);
				
				try {
					FileWriter file = new FileWriter("userbase.json");
					file.write(jrr.toJSONString());
					file.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Guardado", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panelGuardar.setLayout(null);
		panelGuardar.setBackground(new Color(20, 91, 173));
		panelGuardar.setBounds(189, 361, 170, 44);
		panelPerfilUsuario.add(panelGuardar);
		
		JLabel lblGuardar = new JLabel("GUARDAR");
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.WHITE);
		lblGuardar.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblGuardar.setBounds(0, 0, 170, 44);
		panelGuardar.add(lblGuardar);
		
		JSeparator separatorNombre_1_1_1 = new JSeparator();
		separatorNombre_1_1_1.setBackground(Color.BLACK);
		separatorNombre_1_1_1.setBounds(189, 350, 170, 2);
		panelPerfilUsuario.add(separatorNombre_1_1_1);
		
		JSeparator separatorNombre_1_1_1_1 = new JSeparator();
		separatorNombre_1_1_1_1.setBackground(Color.BLACK);
		separatorNombre_1_1_1_1.setBounds(189, 313, 170, 2);
		panelPerfilUsuario.add(separatorNombre_1_1_1_1);
		
		panelClasificacion = new JPanel();
		panelClasificacion.setBackground(Color.WHITE);
		panelClasificacion.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelClasificacion);
		panelClasificacion.setLayout(null);
		panelClasificacion.setVisible(false);
		
		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setBounds(0, 41, 515, 120);
		panel_4_1_1_1.setBackground(new Color(25, 118, 209));
		panelClasificacion.add(panel_4_1_1_1);
		panel_4_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("CLASIFICACI\u00D3N");
		lblNewLabel_3_1_1_1.setBounds(0, 0, 515, 119);
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		panel_4_1_1_1.add(lblNewLabel_3_1_1_1);
		
		JScrollPane scrollPaneClasificacion = new JScrollPane();
		scrollPaneClasificacion.setBounds(10, 226, 495, 324);
		panelClasificacion.add(scrollPaneClasificacion);
		
		tableInfo = new JTable(){
			@SuppressWarnings("unused")
			public boolean isCellEditable(int row, int column) {
			    return false;
			}
		};
		tableInfo.setSelectionBackground(new Color(25, 118, 209));
		scrollPaneClasificacion.setViewportView(tableInfo);
		
		JPanel panelInfo = new JPanel();
		panelInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelInfo.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelInfo.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate(); 
				panelClasificacion.setVisible(true);
				panelMultiple.add(panelClasificacion);
				tablaInfo();
			}
		});
		panelInfo.setLayout(null);
		panelInfo.setBackground(new Color(20, 91, 173));
		panelInfo.setBounds(10, 171, 170, 44);
		panelClasificacion.add(panelInfo);
		
		JLabel lblResultados_1 = new JLabel("INFO");
		lblResultados_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultados_1.setForeground(Color.WHITE);
		lblResultados_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblResultados_1.setBounds(0, 0, 170, 44);
		panelInfo.add(lblResultados_1);
		
		panelCaracteristicas = new JPanel();
		panelCaracteristicas.setBackground(Color.WHITE);
		panelCaracteristicas.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelCaracteristicas);
		panelCaracteristicas.setLayout(null);
		
		JPanel panel_4_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1.setBackground(new Color(25, 118, 209));
		panel_4_1_1_1_1.setBounds(0, 41, 515, 120);
		panelCaracteristicas.add(panel_4_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("CARACTERISTICAS DE COCHES");
		lblNewLabel_3_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblNewLabel_3_1_1_1_1.setBounds(0, 0, 515, 119);
		panel_4_1_1_1_1.add(lblNewLabel_3_1_1_1_1);
		
		JScrollPane scrollPaneCaracteristicas = new JScrollPane();
		scrollPaneCaracteristicas.setBounds(10, 226, 495, 324);
		panelCaracteristicas.add(scrollPaneCaracteristicas);
		panelCaracteristicas.setVisible(false);
		
		tableCaracteristicas = new JTable(){
			@SuppressWarnings("unused")
			public boolean isCellEditable(int row, int column) {
			    return false;
			}
		};
		tableCaracteristicas.setSelectionBackground(new Color(25, 118, 209));
		scrollPaneCaracteristicas.setViewportView(tableCaracteristicas);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.MAGENTA);
		panel_2.setBounds(0, 0, 515, 561);
	}
		
	public void tablaPilotos() {
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("pilotos.json");
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
		
		int size = jrr.size();
		
		DefaultTableModel model = new DefaultTableModel();
		tablePilotos.setModel(model);
		
		model.addColumn("Numero");
		model.addColumn("Nombre");
		model.addColumn("Equipo");
		model.addColumn("Nacionalidad");
		model.addColumn("Edad");
		model.addColumn("Campeonatos ganados");
		
		Object [] filas = new Object[size];
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String name = (String) row.get("numero");
			String nombre = (String) row.get("nombre");
			String equipo = (String) row.get("equipo");
			String nacionalidad = (String) row.get("nacionalidad");
			String edad = (String) row.get("edad");
			String campeonatos_ganados = (String) row.get("campeonatos_ganados");
			filas[0] = name;
			filas[1] = nombre;
			filas[2] = equipo;
			filas[3] = nacionalidad;
			filas[4] = edad;
			filas[5] = campeonatos_ganados;
			model.addRow(filas);
		}
	}
	public void tablaCarreras() {
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("lista_carreras_gp.json");
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
		
		int size = jrr.size();
		
		DefaultTableModel model = new DefaultTableModel();
		tableCarreras.setModel(model);
		
		model.addColumn("Nombre circuito");
		model.addColumn("Lugar");
		model.addColumn("Distancia");
		model.addColumn("Fecha");
		
		Object [] filas = new Object[size];
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String nombre_circuito = (String) row.get("nombre_circuito");
			String lugar = (String) row.get("lugar");
			String distancia = (String) row.get("distancia");
			String fecha = (String) row.get("fecha");
			filas[0] = nombre_circuito;
			filas[1] = lugar;
			filas[2] = distancia;
			filas[3] = fecha;
			model.addRow(filas);
		}
	}
	public void consultPerfil() {
		txtNombre.setText("TU NOMBRE");
		txtApellido.setText("TU APELLIDO");
		txtCorreo.setText("TU CORREO");
		txtFechaN.setText("dd/mm/yyyy");
		
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("userbase.json");
			jrr =  (JSONArray)jp.parse(file);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = jrr.size();
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String name = (String) row.get("username");
			if(name.equals(Main.nickname)) {
				String nameU = (String) row.get("nombre");
				String apellidoU = (String) row.get("apellido");
				String sexo = (String) row.get("sexo");
				String correoU = (String) row.get("correo");
				String fecha_nacimU = (String) row.get("fecha_nacim");
				if(nameU != null) {
					txtNombre.setText(nameU);
				}
				if(nameU != null) {
					txtApellido.setText(apellidoU);
				}
				if(sexo != null) {
					if(sexo.equals("mujer")) {
						comboBox.setSelectedIndex(1);
					}else {
						comboBox.setSelectedIndex(0);
					}
				}
				txtCorreo.setText(correoU);
				if(fecha_nacimU != null) {
					txtFechaN.setText(fecha_nacimU);
				}
			}
		}
	}

	public void tablaInfo() {
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("ultimos_resultados.json");
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
		
		int size = jrr.size();
		
		Object [][] filas = new Object[size][2];
		
		DefaultTableModel model = new DefaultTableModel();
		tableInfo.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Numero");
		
		for(int i=0; i<size; i++) {
			int suma = 0;
			JSONObject row = (JSONObject) jrr.get(i);
			String nombre = (String) row.get("piloto");
			filas[i][0] = nombre;
			filas[i][1] = 0;
			for(int j=1; j<22; j++) {
				String numCirc = String.valueOf(j) + " GP";
				String points = (String) row.get(numCirc);
				int pointsInt = Integer.valueOf(points);
				switch(pointsInt) {
				case 1:
					suma +=25;
				break;
				case 2:
					suma +=18;
				break;
				case 3:
					suma +=15;
				break;
				case 4:
					suma +=10;
				break;
				case 5:
					suma +=8;
				break;
				case 6:
					suma +=6;
				break;
				case 7:
					suma +=5;
				break;
				case 8:
					suma +=3;
				break;
				case 9:
					suma +=2;
				break;
				case 10:
					suma +=1;
				break;
				}
			}
			filas[i][1] += String.valueOf(suma);
			model.addRow(filas[i]);
		}	
	}
	public void tablaClasificacion() {
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("mejores_tiempos_circuitos.json");
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
		
		int size = jrr.size();
		
		DefaultTableModel model = new DefaultTableModel();
		tableInfo.setModel(model);
		
		model.addColumn("Nombre circuito");
		model.addColumn("Piloto");
		model.addColumn("Tiempo");
		model.addColumn("AÃ±o");
		
		Object [] filas = new Object[size];
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String nombre_circuito = (String) row.get("nombre_circuito");
			String piloto = (String) row.get("Piloto");
			String tiempo = (String) row.get("Tiempo");
			String ano = (String) row.get("Año");
			filas[0] = nombre_circuito;
			filas[1] = piloto;
			filas[2] = tiempo;
			filas[3] = ano;
			model.addRow(filas);
		}
	}
	public void tablaCaracteristicas() {
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("especificaciones_coche.json");
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
		
		int size = jrr.size();
		
		DefaultTableModel model = new DefaultTableModel();
		tableCaracteristicas.setModel(model);
		
		model.addColumn("Nombre circuito");
		model.addColumn("Motor");
		model.addColumn("Peso");
		model.addColumn("Carroceria");
		model.addColumn("Frenos");
		model.addColumn("Caja de cambios");
		model.addColumn("Suspension delantera");
		model.addColumn("Suspension trasera");
		model.addColumn("Ruedas");
		
		Object [] filas = new Object[size];
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String nombre = (String) row.get("Nombre");
			String motor = (String) row.get("Motor");
			String tiempo = (String) row.get("Peso");
			String carroceria = (String) row.get("Carroceria");
			String frenos = (String) row.get("Frenos");
			String caja_cambios = (String) row.get("Caja de cambios");
			String suspension_delantera = (String) row.get("Suspension delantera");
			String suspension_trasera = (String) row.get("Suspension trasera");
			String ruedas = (String) row.get("Ruedas");
			filas[0] = nombre;
			filas[1] = motor;
			filas[2] = tiempo;
			filas[3] = carroceria;
			filas[4] = frenos;
			filas[5] = caja_cambios;
			filas[6] = suspension_delantera;
			filas[7] = suspension_trasera;
			filas[8] = ruedas;
			model.addRow(filas);
		}
	}
}