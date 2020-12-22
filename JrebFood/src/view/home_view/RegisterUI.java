package view.home_view;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.HomeController;
import controller.UserController;
import core.View;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class RegisterUI extends View implements ActionListener {
	private JLabel lblPassword, lblPhone, lblName, lblEmail, lblRole, header, lblSplash;
	private JButton btnLogin, btnRegister;
	private JTextField textFieldName, textFieldEmail, textFieldPhone, textFieldPassword;
	private JRadioButton rdbtnCustomer, rdbtnDriver, rdbtnChef;
	private ButtonGroup rdbuttonGroup;
	private JTable table;
//	DefaultTableModel dtm;
	Vector<Object> tableContent;

	public RegisterUI() {
		// loadUser();
		super();
		this.width = 700;
		this.height = 600;
		this.x = 600;
		this.y = 270;
	}

	@Override
	public void initialize() {
		// header label
		header = new JLabel("REGISTER");
		header.setForeground(new Color(50, 205, 50).darker());
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Longhaul", Font.PLAIN, 38));
		header.setBounds(405, 13, 176, 49);
		getContentPane().add(header);

		// name label
		lblName = new JLabel("Name");
		lblName.setFont(new Font("MADE Tommy Soft", Font.BOLD, 18));
		lblName.setBounds(374, 75, 109, 16);
		getContentPane().add(lblName);

		// email label
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("MADE Tommy Soft", Font.BOLD, 18));
		lblEmail.setBounds(374, 154, 56, 16);
		getContentPane().add(lblEmail);

		// phone number label
		lblPhone = new JLabel("Phone Number");
		lblPhone.setFont(new Font("MADE Tommy Soft", Font.BOLD, 18));
		lblPhone.setBounds(374, 234, 140, 16);
		getContentPane().add(lblPhone);

		// password label
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("MADE Tommy Soft", Font.BOLD, 18));
		lblPassword.setBounds(374, 313, 99, 16);
		getContentPane().add(lblPassword);

		// name textfield
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldName.setBounds(374, 94, 235, 36);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		// email textfield
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEmail.setBounds(374, 175, 235, 36);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		// phone number textfield
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPhone.setBounds(374, 255, 235, 34);
		getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);

		// password textfield
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPassword.setBounds(374, 333, 235, 34);
		getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);

		// register button
		btnRegister = new JButton();
		// insert new user
		btnRegister.addActionListener(this);
		btnRegist();
		btnRegister.setIcon(new ImageIcon("res/registBtn.png"));
		btnRegister.setBorderPainted(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setFocusPainted(false);
		btnRegister.setOpaque(false);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.setBounds(440, 467, 86, 34);
		getContentPane().add(btnRegister);

		btnLogin = new JButton("Already have an account? Login here");
		btnLogin();
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setForeground(Color.GRAY);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		btnLogin.setFont(new Font("MADE Tommy Soft", Font.BOLD, 13));
		btnLogin.setBounds(354, 503, 278, 25);
		getContentPane().add(btnLogin);

//		// role label
//		lblRole = new JLabel("Role");
//		lblRole.setFont(new Font("MADE Tommy Soft", Font.BOLD, 18));
//		lblRole.setBounds(374, 392, 56, 16);
//		getContentPane().add(lblRole);
//
//		// driver radio btn
//		rdbtnDriver = new JRadioButton("Driver");
//		rdbtnDriver.setBorderPainted(false);
//		rdbtnDriver.setContentAreaFilled(false);
//		rdbtnDriver.setFocusPainted(false);
//		rdbtnDriver.setOpaque(false);
//		rdbtnDriver.setBounds(468, 417, 71, 25);
//		getContentPane().add(rdbtnDriver);
//
//		// chef radio btn
//		rdbtnChef = new JRadioButton("Chef");
//		rdbtnChef.setBorderPainted(false);
//		rdbtnChef.setContentAreaFilled(false);
//		rdbtnChef.setFocusPainted(false);
//		rdbtnChef.setOpaque(false);
//		rdbtnChef.setBounds(543, 417, 71, 25);
//		getContentPane().add(rdbtnChef);
//
//		// manager radio btn
//		rdbtnCustomer = new JRadioButton("Customer");
//		rdbtnCustomer.setBorderPainted(false);
//		rdbtnCustomer.setContentAreaFilled(false);
//		rdbtnCustomer.setFocusPainted(false);
//		rdbtnCustomer.setOpaque(false);
//		rdbtnCustomer.setBounds(374, 417, 86, 25);
//		getContentPane().add(rdbtnCustomer);

		// splash screen
		lblSplash = new JLabel();
		lblSplash.setHorizontalAlignment(SwingConstants.CENTER);
		lblSplash.setIcon(new ImageIcon("res/splash.png"));
		lblSplash.setBounds(0, 0, 342, 565);
		getContentPane().add(lblSplash);

		// button group
		rdbuttonGroup = new ButtonGroup();
		rdbuttonGroup.add(rdbtnDriver);
		rdbuttonGroup.add(rdbtnChef);
		rdbuttonGroup.add(rdbtnCustomer);
	}

	private void btnRegist() {
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean status;
				status = UserController.getInstance().insert(textFieldName.getText(), textFieldEmail.getText(), textFieldPhone.getText(), textFieldPhone.getText());
				if (status == true) {
					JOptionPane.showMessageDialog(null, "Register Successful!", "", JOptionPane.DEFAULT_OPTION);
					HomeController.getInstance().viewLoginUI();
					setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Input: Register Failed.", "Warning", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	private void btnLogin() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeController.getInstance().viewLoginUI();
				setVisible(false);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
