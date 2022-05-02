package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import control.Main;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;


public class WindowRegistrarse extends JFrame {

	public JPanel contentPane;
	public JTextField txtUsername;
	public JTextField txtPassword;
	public JTextField txtConfirmarPassword;
	private JLabel lblRegistrarse;
	private JLabel lblNewLabel;
	private Panel btnRegistrarse;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_2;
	private JSeparator separator_2;
	private JLabel lblCorreo;
	private JTextField txtCorreo;

	public WindowRegistrarse() {
		super();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 497);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUsername.getText().equals("Ingrese su nombre de usuario")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.black);
				}
				if(String.valueOf(((JPasswordField) txtPassword).getPassword()).isEmpty()) {
					txtPassword.setText("********");
					txtPassword.setForeground(Color.gray);
				}	
				if(String.valueOf(((JPasswordField) txtConfirmarPassword).getPassword()).isEmpty()) {
					txtConfirmarPassword.setText("********");
					txtConfirmarPassword.setForeground(Color.gray);
				}
				if(txtCorreo.getText().isEmpty()) {
					txtCorreo.setText("Ingrese su correo electronico");
					txtCorreo.setForeground(Color.gray);
				}
			}
		});
		
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setText("Ingrese su nombre de usuario");
		txtUsername.setBorder(null);
		txtUsername.setBounds(222, 155, 226, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(String.valueOf(((JPasswordField) txtPassword).getPassword()).equals("********")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.black);
				}
				if(txtUsername.getText().isEmpty()) {
					txtUsername.setText("Ingrese su nombre de usuario");
					txtUsername.setForeground(Color.gray);
				}
				if(String.valueOf(((JPasswordField) txtConfirmarPassword).getPassword()).isEmpty()) {
					txtConfirmarPassword.setText("********");
					txtConfirmarPassword.setForeground(Color.gray);
				}
				if(txtCorreo.getText().isEmpty()) {
					txtCorreo.setText("Ingrese su correo electronico");
					txtCorreo.setForeground(Color.gray);
				}
			}
		});
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setText("********");
		txtPassword.setBorder(null);
		txtPassword.setBounds(222, 267, 226, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblRegistrarse.setBounds(222, 75, 152, 14);
		contentPane.add(lblRegistrarse);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel.setBounds(221, 130, 70, 14);
		contentPane.add(lblNewLabel);
		
		btnRegistrarse = new Panel();
		
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUsername.getText().length() < 4 || txtCorreo.getText().length() < 4 || String.valueOf(((JPasswordField) txtPassword).getPassword()).length() < 4) {
					JOptionPane.showMessageDialog(null, "Numero de caracteres no puede menor que 4", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
				}else if(txtUsername.getText().equals("Ingrese su nombre de usuario") || txtCorreo.getText().equals("Ingrese su correo electronico") || String.valueOf(((JPasswordField) txtPassword).getPassword()).equals("********")){
					JOptionPane.showMessageDialog(null, "No has introducido login, contraseña o correo", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
				}else {
					if((String.valueOf(((JPasswordField) txtPassword).getPassword())).equals(String.valueOf(((JPasswordField) txtConfirmarPassword).getPassword()))) {
						try {
							Main.registrarse(txtUsername.getText(), txtCorreo.getText(), txtPassword.getText());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						txtUsername.setText("");
						txtCorreo.setText("");
						txtPassword.setText("");
						txtConfirmarPassword.setText("");
						//closeFrame();
					}else {
						JOptionPane.showMessageDialog(null, "Contraseñas no son los mismos", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
						txtPassword.setText("");
						txtConfirmarPassword.setText("");
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrarse.setBackground(new Color(0, 156, 223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrarse.setBackground(new Color(0, 134, 190));
			}
		});
		btnRegistrarse.setBackground(new Color(0, 134, 190));
		btnRegistrarse.setBounds(224, 368, 110, 29);
		contentPane.add(btnRegistrarse);
		
		lblNewLabel_1 = new JLabel("REGISTRARSE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_1.setBounds(0, 0, 110, 29);
		btnRegistrarse.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_3.setBounds(221, 242, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(222, 230, 226, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(222, 286, 226, 2);
		contentPane.add(separator_1);
		
		lblNewLabel_2 = new JLabel("Confirmar contraseña");
		lblNewLabel_2.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_2.setBounds(222, 298, 152, 14);
		contentPane.add(lblNewLabel_2);
		
		txtConfirmarPassword = new JPasswordField();
		txtConfirmarPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmarPassword.setForeground(Color.GRAY);
		txtConfirmarPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(String.valueOf(((JPasswordField) txtConfirmarPassword).getPassword()).equals("********")) {
					txtConfirmarPassword.setText("");
					txtConfirmarPassword.setForeground(Color.black);
				}
				if(txtUsername.getText().isEmpty()) {
					txtUsername.setText("Ingrese su nombre de usuario");
					txtUsername.setForeground(Color.gray);
				}
				if(String.valueOf(((JPasswordField) txtPassword).getPassword()).isEmpty()) {
					txtPassword.setText("********");
					txtPassword.setForeground(Color.gray);
				}
				if(txtCorreo.getText().isEmpty()) {
					txtCorreo.setText("Ingrese su correo electronico");
					txtCorreo.setForeground(Color.gray);
				}
			}
		});
		txtConfirmarPassword.setText("********");
		txtConfirmarPassword.setColumns(10);
		txtConfirmarPassword.setBorder(null);
		txtConfirmarPassword.setBounds(222, 323, 226, 20);
		contentPane.add(txtConfirmarPassword);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(222, 342, 226, 2);
		contentPane.add(separator_2);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblCorreo.setBounds(221, 186, 70, 14);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtCorreo.getText().equals("Ingrese su correo electronico")) {
					txtCorreo.setText("");
					txtCorreo.setForeground(Color.black);
				}
				if(String.valueOf(((JPasswordField) txtPassword).getPassword()).isEmpty()) {
					txtPassword.setText("********");
					txtPassword.setForeground(Color.gray);
				}	
				if(String.valueOf(((JPasswordField) txtConfirmarPassword).getPassword()).isEmpty()) {
					txtConfirmarPassword.setText("********");
					txtConfirmarPassword.setForeground(Color.gray);
				}
				if(txtUsername.getText().isEmpty()) {
					txtUsername.setText("Ingrese su nombre de usuario");
					txtUsername.setForeground(Color.gray);
				}
			}
		});
		txtCorreo.setText("Ingrese su correo electronico");
		txtCorreo.setForeground(Color.GRAY);
		txtCorreo.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(222, 211, 226, 20);
		contentPane.add(txtCorreo);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(222, 174, 226, 2);
		contentPane.add(separator_3);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void closeFrame() {
        dispose();  
    } 
}
