package views.core;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginUI extends JFrame{
	private JButton btnRegister, btnLogin;
	private JTextField txtFieldEmail;
	private JPasswordField fieldPassword;
	private JLabel lblEmail, lblPassword, header;
	
	public LoginUI() {
		initialize();
	}
	
	private void initialize() {
		config();
		
		// jrabfood header text
		header = new JLabel("JrebFood");
		header.setForeground(new Color(50, 205, 50).darker());
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Longhaul", Font.PLAIN, 48));
		header.setBounds(92, 13, 251, 52);
		getContentPane().add(header);
		
		// email text field
		txtFieldEmail = new JTextField();
		txtFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFieldEmail.setForeground(Color.BLACK);
		txtFieldEmail.setToolTipText("");
		txtFieldEmail.setBounds(102, 100, 222, 26);
		getContentPane().add(txtFieldEmail);
		txtFieldEmail.setColumns(10);
		
		// password text field
		fieldPassword = new JPasswordField();
		fieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fieldPassword.setForeground(Color.BLACK);
		fieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		fieldPassword.setToolTipText("");
		fieldPassword.setBounds(102, 162, 222, 26);
		getContentPane().add(fieldPassword);
		fieldPassword.setColumns(10);
		
		// register button
		btnRegister = new JButton();
		registerBtn();
		btnRegister.setIcon(new ImageIcon("res/registBtn.png"));
		btnRegister.setBorderPainted(false); 
		btnRegister.setContentAreaFilled(false); 
		btnRegister.setFocusPainted(false); 
		btnRegister.setOpaque(false);
		btnRegister.setBounds(102, 203, 114, 40);
		getContentPane().add(btnRegister);
		
		// login button
		btnLogin = new JButton();
		loginBtn();
		btnLogin.setIcon(new ImageIcon("res/loginBtn.png"));
		btnLogin.setBorderPainted(false); 
		btnLogin.setContentAreaFilled(false); 
		btnLogin.setFocusPainted(false); 
		btnLogin.setOpaque(false);
		btnLogin.setBounds(203, 203, 96, 40);
		getContentPane().add(btnLogin);
		
		// email label
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("MADE Tommy Soft", Font.BOLD, 16));
		lblEmail.setBounds(102, 78, 43, 21);
		getContentPane().add(lblEmail);
		
		// password label
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("MADE Tommy Soft", Font.BOLD, 16));
		lblPassword.setBounds(102, 139, 75, 21);
		getContentPane().add(lblPassword);
	}
	
	private void loginBtn() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFieldEmail.getText().equals("manager")) {
					new ManagerMenuUI().setVisible(true);
					setVisible(false);
				}else if(txtFieldEmail.getText().equals("chef")) {
					new ChefMenuUI().setVisible(true);
					setVisible(false);
				}else if(txtFieldEmail.getText().equals("customer")) {
					new CustomerMenuUI().setVisible(true);
					setVisible(false);
				}else if(txtFieldEmail.getText().equals("driver")) {
					new DriverMenuUI().setVisible(true);
					setVisible(false);
				}
			}
		});	
	}
	
	private void registerBtn() {
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterUI().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void config() {
		setLocation(800, 400);
		setResizable(false);
		setSize(new Dimension(460, 300));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(new ImageIcon("res/jrebfood_logo.png").getImage());
		setTitle("JrebFood");
	}
}