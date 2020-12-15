package views.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views_chef_menu.ChefFoodStatus;
import views_chef_menu.ChefManageMenu;
import views_chef_menu.ChefOrders;
import views_chef_menu.ChefViewMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChefMenuUI extends JFrame{
	JButton btnOrders, btnMngMenu, btnViewMenu, btnFoodStat;
	JLabel lblHeader;

	public ChefMenuUI() {
		initialize();
	}

	private void initialize() {
		config();
		
		// lblHeader label
		lblHeader = new JLabel("CHEF MENU");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 42));
		lblHeader.setBounds(71, 13, 311, 39);
		getContentPane().add(lblHeader);
		
		// view menu btn
		btnViewMenu = new JButton();
		viewMenuBtn();
		btnViewMenu.setIcon(new ImageIcon("res/menuBtn.png"));
		btnViewMenu.setBorderPainted(false); 
		btnViewMenu.setContentAreaFilled(false); 
		btnViewMenu.setFocusPainted(false); 
		btnViewMenu.setOpaque(false);
		btnViewMenu.setBounds(71, 74, 140, 140);
		getContentPane().add(btnViewMenu);
		
		// manage menu btn
		btnMngMenu = new JButton();
		mngMenuBtn();
		btnMngMenu.setIcon(new ImageIcon("res/mngMenuBtn.png"));
		btnMngMenu.setBorderPainted(false); 
		btnMngMenu.setContentAreaFilled(false); 
		btnMngMenu.setFocusPainted(false); 
		btnMngMenu.setOpaque(false);
		btnMngMenu.setBounds(232, 74, 140, 140);
		getContentPane().add(btnMngMenu);
		
		// food stat btn
		btnFoodStat = new JButton();
		foodStatBtn();
		btnFoodStat.setIcon(new ImageIcon("res/foodStatBtn.png"));
		btnFoodStat.setBounds(71, 229, 140, 140);
		btnFoodStat.setBorderPainted(false); 
		btnFoodStat.setContentAreaFilled(false); 
		btnFoodStat.setFocusPainted(false); 
		btnFoodStat.setOpaque(false);
		getContentPane().add(btnFoodStat);
		
		// order btn
		btnOrders = new JButton();
		ordersBtn();
		btnOrders.setIcon(new ImageIcon("res/ordersBtn.png"));
		btnOrders.setBounds(232, 227, 140, 140);
		btnOrders.setBorderPainted(false); 
		btnOrders.setContentAreaFilled(false); 
		btnOrders.setFocusPainted(false); 
		btnOrders.setOpaque(false);
		getContentPane().add(btnOrders);
	}
	
	private void ordersBtn() {
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefOrders().setVisible(true);
			}
		});
	}
	
	private void foodStatBtn() {
		btnFoodStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefFoodStatus().setVisible(true);
			}
		});
	}
	
	private void mngMenuBtn() {
		btnMngMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefManageMenu().setVisible(true);
			}
		});
	}
	
	private void viewMenuBtn() {
		btnViewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ChefViewMenu().setVisible(true);
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
