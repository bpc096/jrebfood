package views.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views_driver_menu.DriverOrderStatus;
import views_driver_menu.DriverViewOrder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DriverMenuUI extends JFrame {
	private JLabel lblHeader;
	private JButton btnOrder, btnOrderStatus;

	public DriverMenuUI() {
		initialize();
	}

	private void initialize() {
		config();
		
		// header label
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
		btnOrderStatus.setIcon(new ImageIcon("res/cartBtn.png"));
		btnOrderStatus.setBorderPainted(false); 
		btnOrderStatus.setContentAreaFilled(false); 
		btnOrderStatus.setFocusPainted(false); 
		btnOrderStatus.setOpaque(false);
		btnOrderStatus.setBounds(233, 84, 140, 140);
		getContentPane().add(btnOrderStatus);
	}
	
	private void statusBtn() {
		btnOrderStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverOrderStatus().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void orderBtn() {
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverViewOrder().setVisible(true);
				setVisible(false);
			}
		});
	}

	private void config() {
		setLocation(750, 360);
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
