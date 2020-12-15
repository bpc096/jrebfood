package views.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views_customer_menu.CustomerCart;
import views_customer_menu.CustomerCheckout;
import views_customer_menu.CustomerOrder;
import views_customer_menu.CustomerViewMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMenuUI extends JFrame{
	private JButton btnViewMenu, btnViewCart, btnCheckOut, btnHistory;
	private JLabel lblHeader;

	public CustomerMenuUI() {
		initialize();
	}

	private void initialize() {
		config();
		
		// lblHeader label
		lblHeader = new JLabel("CUSTOMER MENU");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 42));
		lblHeader.setBounds(44, 13, 371, 39);
		getContentPane().add(lblHeader);
		
		// view menu btn
		btnViewMenu = new JButton();
		menuBtn();
		btnViewMenu.setIcon(new ImageIcon("res/menuBtn.png"));
		btnViewMenu.setBorderPainted(false); 
		btnViewMenu.setContentAreaFilled(false); 
		btnViewMenu.setFocusPainted(false); 
		btnViewMenu.setOpaque(false);
		btnViewMenu.setBounds(71, 74, 140, 140);
		getContentPane().add(btnViewMenu);
		
		// view cart btn
		btnViewCart = new JButton();
		cartBtn();
		btnViewCart.setIcon(new ImageIcon("res/cartBtn.png"));
		btnViewCart.setBorderPainted(false); 
		btnViewCart.setContentAreaFilled(false); 
		btnViewCart.setFocusPainted(false); 
		btnViewCart.setOpaque(false);
		btnViewCart.setBounds(232, 74, 140, 140);
		getContentPane().add(btnViewCart);
		
		// checkout btn
		btnCheckOut = new JButton();
		checkoutBtn();
		btnCheckOut.setIcon(new ImageIcon("res/checkOutBtn.png"));
		btnCheckOut.setBounds(71, 229, 140, 140);
		btnCheckOut.setBorderPainted(false); 
		btnCheckOut.setContentAreaFilled(false); 
		btnCheckOut.setFocusPainted(false); 
		btnCheckOut.setOpaque(false);
		getContentPane().add(btnCheckOut);
		
		// orders btn
		btnHistory = new JButton();
		historyBtn();
		btnHistory.setIcon(new ImageIcon("res/ordersBtn.png"));
		btnHistory.setBounds(232, 227, 140, 140);
		btnHistory.setBorderPainted(false); 
		btnHistory.setContentAreaFilled(false); 
		btnHistory.setFocusPainted(false); 
		btnHistory.setOpaque(false);
		getContentPane().add(btnHistory);
	}
	
	private void historyBtn() {
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerOrder().setVisible(true);
				setVisible(false);
			}
		});
	}

	private void checkoutBtn() {
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerCheckout().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void cartBtn() {
		btnViewCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerCart().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void menuBtn() {
		btnViewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerViewMenu().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void config() {
		setLocation(750, 360);
		setResizable(false);
		setSize(new Dimension(460, 430));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(new ImageIcon("res/jrebfood_logo.png").getImage());
		setTitle("JrebFood");
	}
}
