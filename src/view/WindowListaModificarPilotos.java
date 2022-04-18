package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.Main;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class WindowListaModificarPilotos extends JFrame {
	private static Connection connect;

	public JPanel contentPane;
	private JTable jTable;
	JButton btnEliminar;
	JButton btnModificar;
	int row, id;
	private JButton btnAnadir;
	private JTextField textNumero;
	private JTextField textNombre;
	private JTextField textEquipo;
	private JTextField textNacionalidad;
	private JTextField textFecha;
	private JTextField textCampeonatos;
	int numero, campeonatos_ganados;
	String nombre, equipo, nacionalidad, fecha_nacim;
	
	public WindowListaModificarPilotos() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de pilotos");
		lblNewLabel.setBounds(281, 24, 121, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 187, 467, 234);
		contentPane.add(scrollPane);
		
		jTable = new JTable();
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResultSet rs;
				row = jTable.getSelectedRow();
				numero = (int) jTable.getModel().getValueAt(row, 0);
				nombre = (String) jTable.getModel().getValueAt(row, 1);
				equipo = (String) jTable.getModel().getValueAt(row, 2);
				nacionalidad = (String) jTable.getModel().getValueAt(row, 3);
				fecha_nacim = (String) jTable.getModel().getValueAt(row, 4);
				campeonatos_ganados = (int) jTable.getModel().getValueAt(row, 5);
				textNumero.setText(String.valueOf(numero));
				textNombre.setText(nombre);
				textEquipo.setText(equipo);
				textNacionalidad.setText(nacionalidad);
				textFecha.setText(String.valueOf(fecha_nacim));
				textCampeonatos.setText(String.valueOf(campeonatos_ganados));
				try {
				Statement stmt = connect.createStatement();
				rs = stmt.executeQuery(
						"SELECT idpiloto from pilotos where nombre = '" + nombre + "'");
				while(rs.next()){
					id = rs.getInt(1);
				}
					rs.close();
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Connection.cerrarBBDD();
		        btnModificar.setEnabled(true);
		        btnEliminar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(jTable);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(462, 153, 89, 23);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
				Main m = new Main();
				try {
					m.modificarPiloto(id, Integer.parseInt(textNumero.getText()), textNombre.getText(), textEquipo.getText(), textNacionalidad.getText(), textFecha.getText(), Integer.parseInt(textCampeonatos.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setBounds(464, 119, 89, 23);
		contentPane.add(btnModificar);
		
		btnAnadir = new JButton("Añadir");
		btnAnadir.setBounds(462, 85, 89, 23);
		contentPane.add(btnAnadir);
		
		textNumero = new JTextField();
		textNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textNumero.setBounds(66, 70, 130, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		lblNewLabel_1.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(66, 101, 130, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 104, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textEquipo = new JTextField();
		textEquipo.setBounds(66, 132, 130, 20);
		contentPane.add(textEquipo);
		textEquipo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Equipo:");
		lblNewLabel_3.setBounds(10, 135, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nacionalidad:");
		lblNewLabel_4.setBounds(226, 73, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setBounds(322, 70, 132, 20);
		contentPane.add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha nacimiento:");
		lblNewLabel_5.setBounds(226, 104, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		textFecha = new JTextField();
		textFecha.setBounds(322, 101, 132, 20);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Campeonatos ganados:");
		lblNewLabel_6.setBounds(226, 135, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		textCampeonatos = new JTextField();
		textCampeonatos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textCampeonatos.setBounds(322, 132, 132, 20);
		contentPane.add(textCampeonatos);
		textCampeonatos.setColumns(10);
		tabla();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	} 
	
	public void tabla() {
		String surl = "jdbc:mysql://localhost:3306/f1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(surl,"root","psswd");
			System.out.println ("Conexión con MySQL establecida");
			
		} catch (Exception e) {
			System.out.println ("Error de Conexión con MySQL");
			e.printStackTrace();
		}
		
		String[] columns = {"Nombre", "Equipo", "Nacionalidad", "Fecha nacimiento", "Campeonatos ganados"};
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		
		jTable.setModel(model);
		ResultSet rs;
		try {
		Statement stmt = connect.createStatement();
		rs = stmt.executeQuery(
				"SELECT idpiloto, numero, nombre, equipo, nacionalidad, fecha_nacim, campeonatos_ganados from pilotos");
		ResultSetMetaData rsmd = rs.getMetaData();
		int cantidad = rsmd.getColumnCount();
		
		model.addColumn("Numero");
		model.addColumn("Nombre");
		model.addColumn("Equipo");
		model.addColumn("Nacionalidad");
		model.addColumn("Fecha nacimiento");
		model.addColumn("Campeonatos ganados");
		while(rs.next()){
			Object [] filas = new Object[cantidad];
			int k=2;
			for(int i = 0; i < cantidad-1; i++) {
				filas[i] = rs.getObject(k);
				k++;
			}	
			model.addRow(filas);
		}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Connection.cerrarBBDD();
	}
}