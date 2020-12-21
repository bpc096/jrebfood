package views_customer_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views.core.CustomerMenuUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerOrder extends JFrame implements ActionListener{
	private JButton btnActive, btnHistory, backBtn;
	private JLabel lblHeader;

	public CustomerOrder() {
		initialize();
	}

	private void initialize() {
		config();
		
		// view menu label
		lblHeader = new JLabel("VIEW ORDER");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(12, 13, 418, 49);
		getContentPane().add(lblHeader);
		
		// active order btn
		btnActive = new JButton();
		activeBtn();
		btnActive.setIcon(new ImageIcon("res/activeBtn.png"));
		btnActive.setBorderPainted(false); 
		btnActive.setContentAreaFilled(false); 
		btnActive.setFocusPainted(false); 
		btnActive.setOpaque(false);
		btnActive.setBounds(71, 75, 140, 140);
		getContentPane().add(btnActive);
		
		// history order btn
		btnHistory = new JButton();
		historyBtn();
		btnHistory.setIcon(new ImageIcon("res/historyBtn.png"));
		btnHistory.setBorderPainted(false); 
		btnHistory.setContentAreaFilled(false); 
		btnHistory.setFocusPainted(false); 
		btnHistory.setOpaque(false);
		btnHistory.setBounds(232, 75, 140, 140);
		getContentPane().add(btnHistory);
		
		// back btn
		backBtn = new JButton();
		backBtn.setIcon(new ImageIcon("res/backBtn.png"));
		backBtn.setBorderPainted(false); 
		backBtn.setContentAreaFilled(false); 
		backBtn.setFocusPainted(false); 
		backBtn.setOpaque(false);
		backBtn();
		backBtn.setBounds(172, 240, 97, 37);
		getContentPane().add(backBtn);
	}
	
	private void activeBtn() {
		btnActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerOrderActive().setVisible(true);
			}
		});
	}
	
	private void historyBtn() {
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerOrderHistory().setVisible(true);
			}
		});
	}
	
	private void backBtn() {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CustomerMenuUI().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void config() {
		setLocation(750, 360);
		setResizable(false);
		setSize(new Dimension(460, 330));
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(new ImageIcon("res/jrebfood_logo.png").getImage());
		setTitle("JrebFood");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
