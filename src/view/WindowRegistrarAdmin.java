package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Main;
import control.Connection;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class WindowRegistrarAdmin extends JFrame {

	public JPanel contentPane;
	public JTextField txtUsername;
	public JTextField txtPassword;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public  JButton btnRegistrar;

	public WindowRegistrarAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Main.registrarAdmin(txtUsername.getText(), txtPassword.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtUsername.setText("");
				txtPassword.setText("");
				closeFrame();
			}
		});
		btnRegistrar.setBounds(222, 334, 217, 23);
		contentPane.add(btnRegistrar);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(222, 201, 217, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(222, 252, 217, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Registrar admin");
		lblNewLabel.setBounds(282, 110, 121, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(221, 176, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(221, 232, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void closeFrame() {
        dispose();  
    } 
}
