package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import control.Connection;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;

public class WindowMenuUser extends JFrame{
	public JPanel panelMultiple;
	public JPanel panel_2;
	JPanel panelPilotos;
	JPanel panelTablePilotos;
	JPanel panelTableCarreras;
	JPanel panelPerfilUsuario;
	JComboBox comboBox;
	String []cmbxSexo = {"ALIEN", "HOMBRE", "MUJER"};
	String nombre;
	private JTable tablePilotos;
	private JTable tableCarreras;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtFechaN;
	
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
		panelPerfil.setBounds(0, 149, 270, 60);
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
		panelCarreras.setBounds(0, 210, 270, 60);
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
		panelPilotos.setBounds(0, 271, 270, 60);
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
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.MAGENTA);
		panel_2.setBounds(0, 0, 515, 561);
	}
	public void tablaPilotos() {
		
		String[] columns = {"Nombre", "Equipo", "Nacionalidad", "Fecha nacimiento", "Campeonatos ganados"};
		DefaultTableModel model = new DefaultTableModel();
		tablePilotos.setModel(model);
				//"SELECT numero, nombre, equipo, nacionalidad, fecha_nacim, campeonatos_ganados FROM PILOTOS");
		int cantidad = 10;
		
		model.addColumn("Numero");
		model.addColumn("Nombre");
		model.addColumn("Equipo");
		model.addColumn("Nacionalidad");
		model.addColumn("Fecha nacimiento");
		model.addColumn("Campeonatos ganados");
		//while(rs.next()){
			Object [] filas = new Object[cantidad];
			for(int i = 1; i <= cantidad; i++) {
				//filas[i-1] = rs.getObject(i);
			model.addRow(filas);
		}
	}
	public void tablaCarreras() {
		DefaultTableModel model = new DefaultTableModel();
		tableCarreras.setModel(model);
		//"SELECT nombre_circuito, lugar, distancia, fecha FROM carreras_gp");
		int cantidad = 10;
		
		model.addColumn("Nombre circuito");
		model.addColumn("Lugar");
		model.addColumn("Distancia");
		model.addColumn("Fecha");
		//while(rs.next()){
			Object [] filas = new Object[cantidad];
			for(int i = 1; i <= cantidad; i++) {
				//filas[i-1] = rs.getObject(i);
			}	
			model.addRow(filas);
	}
	public void consultPerfil() {
		txtNombre.setText("TU NOMBRE");
		txtApellido.setText("TU APELLIDO");
		txtCorreo.setText("TU CORREO");
		txtFechaN.setText("dd/mm/yyyy");
		//"SELECT nombre, apellido, correo, fecha_nacim, sexo from user where usersid = " + Connection.idUser);
		//while(rs.next()){
		/*
			txtNombre.setText(rs.getString("nombre"));
			txtApellido.setText(rs.getString("apellido"));
			txtCorreo.setText(rs.getString("correo"));
			txtFechaN.setText(rs.getString("fecha_nacim"));
			if(rs.getString("sexo").equals("hombre")) {
				comboBox.setSelectedIndex(1);
			}else {
				comboBox.setSelectedIndex(2);
			}
			*/
	}
}