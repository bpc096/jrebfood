package views_driver_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views.core.DriverMenuUI;

public class DriverRestoOrder extends JFrame{
	private JLabel lblHeader, lblStats, lblOrderStatus;
	private JButton orderRestoBtn, backBtn;

	public DriverRestoOrder() {
		initialize();
	}

	private void initialize() {
		config();
		
		// lblHeader label
		lblHeader = new JLabel("RESTAURANT ORDER");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(22, 13, 404, 49);
		getContentPane().add(lblHeader);
		
		// order status label
		lblStats = new JLabel("Current Order Status :");
		lblStats.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblStats.setBounds(12, 98, 219, 16);
		getContentPane().add(lblStats);
		
		// curr order lable
		lblOrderStatus = new JLabel("No Active Order.");
		lblOrderStatus.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblOrderStatus.setBounds(243, 98, 198, 16);
		getContentPane().add(lblOrderStatus);
		
		// order to resto btn
		orderRestoBtn = new JButton();
		restoBtn();
		orderRestoBtn.setIcon(new ImageIcon("res/restoOrderBtn.png"));
		orderRestoBtn.setBorderPainted(false); 
		orderRestoBtn.setContentAreaFilled(false); 
		orderRestoBtn.setFocusPainted(false); 
		orderRestoBtn.setOpaque(false);
		orderRestoBtn.setBounds(202, 132, 168, 49);
		getContentPane().add(orderRestoBtn);
		
		// back btn
		backBtn = new JButton();
		backBtn.setIcon(new ImageIcon("res/backBtn.png"));
		backBtn.setBorderPainted(false); 
		backBtn.setContentAreaFilled(false); 
		backBtn.setFocusPainted(false); 
		backBtn.setOpaque(false);
		backBtn();
		backBtn.setBounds(73, 127, 97, 54);
		getContentPane().add(backBtn);
	}
	
	private void restoBtn() {
		orderRestoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverMenuUI().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void backBtn() {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverOrderStatus().setVisible(true);
				setVisible(false);
			}
		});
	}

	private void config() {
		setLocation(750, 360);
		setResizable(false);
		setSize(new Dimension(470, 240));
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(new ImageIcon("res/jrebfood_logo.png").getImage());
		setTitle("JrebFood");
	}
}
