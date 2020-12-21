package views_home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.core.View;
import views_driver_menu.DriverOrderStatus;
import views_driver_menu.DriverViewOrder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DriverMenuUI extends View {
	private JLabel lblHeader;
	private JButton btnOrder, btnOrderStatus, btnLogout;

	public DriverMenuUI() {
		super();
		this.width = 460;
		this.height = 340;
		this.x = 750;
		this.y = 360;
	}
	
	@Override
	public void initialize() {
		/// header label
		lblHeader = new JLabel("DRIVER MENU");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 42));
		lblHeader.setBounds(42, 13, 360, 39);
		getContentPane().add(lblHeader);
		
		// orders btn
		btnOrder = new JButton();
		orderBtn();
		btnOrder.setIcon(new ImageIcon("res/ordersBtn.png"));
		btnOrder.setBorderPainted(false); 
		btnOrder.setContentAreaFilled(false); 
		btnOrder.setFocusPainted(false); 
		btnOrder.setOpaque(false);
		btnOrder.setBounds(72, 84, 140, 140);
		getContentPane().add(btnOrder);
		
		// deliver order
		btnOrderStatus = new JButton();
		statusBtn();
		btnOrderStatus.setIcon(new ImageIcon("res/orderStatBtn.png"));
		btnOrderStatus.setBorderPainted(false); 
		btnOrderStatus.setContentAreaFilled(false); 
		btnOrderStatus.setFocusPainted(false); 
		btnOrderStatus.setOpaque(false);
		btnOrderStatus.setBounds(233, 84, 140, 140);
		getContentPane().add(btnOrderStatus);
		
		// logout btn
		btnLogout = new JButton();
		logOutBtn();
		btnLogout.setIcon(new ImageIcon("res/logoutBtn.png"));
		btnLogout.setBounds(175, 240, 85, 40);
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
	
	private void statusBtn() {
		btnOrderStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverOrderStatus().config();
				setVisible(false);
			}
		});
	}
	
	private void orderBtn() {
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverViewOrder().config();
				setVisible(false);
			}
		});
	}
}
