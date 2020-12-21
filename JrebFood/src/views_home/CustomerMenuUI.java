package views_home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.core.View;
import views_customer_menu.CustomerCart;
import views_customer_menu.CustomerCheckout;
import views_customer_menu.CustomerOrder;
import views_customer_menu.CustomerViewMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMenuUI extends View {
	private JButton btnViewMenu, btnViewCart, btnCheckOut, btnHistory, btnLogout;
	private JLabel lblHeader;

	public CustomerMenuUI() {
		super();
		this.width = 460;
		this.height = 470;
		this.x = 750;
		this.y = 360;
	}

	@Override
	public void initialize() {
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
				new LoginUI().config();
				setVisible(false);
			}
		});
	}

	private void historyBtn() {
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerOrder().config();
				setVisible(false);
			}
		});
	}

	private void checkoutBtn() {
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerCheckout().config();
				setVisible(false);
			}
		});
	}

	private void cartBtn() {
		btnViewCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerCart().config();
				setVisible(false);
			}
		});
	}

	private void menuBtn() {
		btnViewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerViewMenu().config();
				setVisible(false);
			}
		});
	}
}
