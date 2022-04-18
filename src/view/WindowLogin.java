package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import control.Main;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.SwingConstants;


public class WindowLogin extends JFrame {

	public JPanel contentPane;
	public JTextField txtUsername;
	public JTextField txtPassword;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	private JSeparator separator_1;
	private Panel btnRegistrarse;
	private Panel btnLogin;
	private JLabel lblNewLabel_4;

	public WindowLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtUsername.getText().equals("Ingrese su nombre de usuario")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.black);
				}
				if(String.valueOf(((JPasswordField) txtPassword).getPassword()).isEmpty()) {
					txtPassword.setText("********");
					txtPassword.setForeground(Color.gray);
				}	
			}
		});
		txtUsername.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtUsername.setBorder(null);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setText("Ingrese su nombre de usuario");
		txtUsername.setBounds(222, 211, 226, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.GRAY);
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
			}
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBorder(null);
		txtPassword.setText("********");
		txtPassword.setBounds(222, 267, 226, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("INICIAR SESI\u00D3N");
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel.setBounds(222, 120, 152, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_1.setBounds(221, 186, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_2.setBounds(221, 242, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(222, 230, 226, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(222, 286, 226, 2);
		contentPane.add(separator_1);
		
		btnLogin = new Panel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Main.login(txtUsername.getText(), txtPassword.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtUsername.setText("");
				txtPassword.setText("");
				closeFrame();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 134, 190));
			}
		});
		btnLogin.setBackground(new Color(0, 134, 190));
		btnLogin.setBounds(222, 312, 110, 29);
		contentPane.add(btnLogin);
		btnLogin.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ENTRAR");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 110, 29);
		btnLogin.add(lblNewLabel_3);
		
		btnRegistrarse = new Panel();
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowRegistrarse frame = new WindowRegistrarse();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
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
		btnRegistrarse.setLayout(null);
		btnRegistrarse.setBackground(new Color(0, 134, 190));
		btnRegistrarse.setBounds(338, 312, 110, 29);
		contentPane.add(btnRegistrarse);
		
		lblNewLabel_4 = new JLabel("REGISTRARSE");
		lblNewLabel_4.setBounds(0, 0, 110, 29);
		btnRegistrarse.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Ebrima", Font.BOLD, 14));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void closeFrame() {
        dispose();  
    } 
}
