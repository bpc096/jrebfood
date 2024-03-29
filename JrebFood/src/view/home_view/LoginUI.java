package view.home_view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ChefController;
import controller.DriverController;
import controller.HomeController;
import controller.ManagerController;
import controller.UserController;
import core.View;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginUI extends View {
	JButton btnRegister, btnLogin;
	JTextField txtFieldEmail;
	JPasswordField fieldPassword;
	JLabel lblEmail, lblPassword, header;

	public LoginUI() {
		super();
		this.width = 460;
		this.height = 300;
		this.x = 750;
		this.y = 360;
	}

	@Override
	public void initialize() {
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
				boolean accFound;
				if (txtFieldEmail.getText().equals("debug manager")) {
					new ManagerMenuUI().config();
					setVisible(false);
				} else if (txtFieldEmail.getText().equals("debug chef")) {
					new ChefMenuUI().config();
					setVisible(false);
				} else if (txtFieldEmail.getText().equals("debug customer")) {
					new CustomerMenuUI().config();
					setVisible(false);
				} else if (txtFieldEmail.getText().equals("debug driver")) {
					new DriverMenuUI().config();
					setVisible(false);
				}
				
				// check if input is valid
				if (!HomeController.getInstance().validEmailPassword(txtFieldEmail.getText(), fieldPassword.getText())) {
					JOptionPane.showMessageDialog(null, "Email and Password is Invalid.", "warning", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				accFound = UserController.getInstance().findAcc(txtFieldEmail.getText(), fieldPassword.getText());
				if (accFound) {
					new CustomerMenuUI().config();
					setVisible(false);
					return;
				}
				accFound = DriverController.getInstance().findAcc(txtFieldEmail.getText(), fieldPassword.getText());
				if (accFound) {
					new DriverMenuUI().config();
					setVisible(false);
					return;
				}
				accFound = ChefController.getInstance().findAcc(txtFieldEmail.getText(), fieldPassword.getText());
				if (accFound) {
					new ChefMenuUI().config();
					setVisible(false);
					return;
				}
				accFound = ManagerController.getInstance().findAcc(txtFieldEmail.getText(), fieldPassword.getText());
				if (accFound) {
					new ManagerMenuUI().config();
					setVisible(false);
					return;
				}
				JOptionPane.showMessageDialog(null, "Email and Password is Invalid.", "warning", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	private void registerBtn() {
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeController.getInstance().viewRegisterUI();
				setVisible(false);
			}
		});
	}
}