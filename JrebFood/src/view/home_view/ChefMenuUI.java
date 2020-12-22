package view.home_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.ChefController;
import controller.HomeController;
import core.View;
import view.chef_view.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChefMenuUI extends View {
	JButton btnOrders, btnMngMenu, btnViewMenu, btnFoodStat, btnLogout;
	JLabel lblHeader;

	public ChefMenuUI() {
		super();
		this.width = 460;
		this.height = 470;
		this.x = 750;
		this.y = 360;
	}
	
	@Override
	public void initialize() {
		/// lblHeader label
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
		
		// logout btn
		btnLogout = new JButton();
		logOutBtn();
		btnLogout.setIcon(new ImageIcon("res/logoutBtn.png"));
		btnLogout.setBounds(175, 375, 85, 40);
		btnLogout.setBorderPainted(false); 
		btnLogout.setContentAreaFilled(false); 
		btnLogout.setFocusPainted(false); 
		btnLogout.setOpaque(false);
		getContentPane().add(btnLogout);
	}
	
	private void logOutBtn() {
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeController.getInstance().viewLoginUI();
				setVisible(false);
			}
		});
	}
	
	private void viewMenuBtn() {
		btnViewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("going into view menu");
				ChefController.getInstance().viewMenu();
			}
		});
	}
	
	private void mngMenuBtn() {
		btnMngMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChefController.getInstance().viewManageMenu();
			}
		});
	}
	
	private void foodStatBtn() {
		btnFoodStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChefController.getInstance().viewFoodStatus();
			}
		});
	}
	
	private void ordersBtn() {
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChefController.getInstance().viewChefOrder();
			}
		});
	}
	
}
