package views_driver_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views.core.DriverMenuUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DriverOrderStatus extends JFrame {
	private JButton btnOrderResto, btnDeliver, backBtn;
	private JLabel lblHeader;

	public DriverOrderStatus() {
		initialize();
	}

	private void initialize() {
		config();
		
		// view menu label
		lblHeader = new JLabel("ORDER STATUS");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(12, 13, 418, 49);
		getContentPane().add(lblHeader);
		
		// order btn
		btnOrderResto = new JButton();
		restoBtn();
		btnOrderResto.setIcon(new ImageIcon("res/restoBtn.png"));
		btnOrderResto.setBorderPainted(false); 
		btnOrderResto.setContentAreaFilled(false); 
		btnOrderResto.setFocusPainted(false); 
		btnOrderResto.setOpaque(false);
		btnOrderResto.setBounds(71, 75, 140, 140);
		getContentPane().add(btnOrderResto);
		
		// deliver order btn
		btnDeliver = new JButton();
		deliverBtn();
		btnDeliver.setIcon(new ImageIcon("res/deliverBtn.png"));
		btnDeliver.setBorderPainted(false); 
		btnDeliver.setContentAreaFilled(false); 
		btnDeliver.setFocusPainted(false); 
		btnDeliver.setOpaque(false);
		btnDeliver.setBounds(232, 75, 140, 140);
		getContentPane().add(btnDeliver);

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
	
	private void restoBtn() {
		btnOrderResto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverRestoOrder().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void deliverBtn() {
		btnDeliver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverDeliverOrder().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void backBtn() {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DriverMenuUI().setVisible(true);
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
}
