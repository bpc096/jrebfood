package views.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views_manager_menu.ManagerFinancialSummary;
import views_manager_menu.ManagerMngEmployee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMenuUI extends JFrame {
	private JButton btnFinSum, btnMngEmployee;
	private JLabel lblHeader;

	public ManagerMenuUI() {
		initialize();
	}
	
	private void initialize() {
		config();
		
		// headeh label
		lblHeader = new JLabel("MANAGER MENU");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 42));
		lblHeader.setBounds(42, 13, 360, 39);
		getContentPane().add(lblHeader);
		
		// financial summary btn
		btnFinSum = new JButton();
		finSumBtn();
		btnFinSum.setIcon(new ImageIcon("res/finSumBtn.png"));
		btnFinSum.setBorderPainted(false); 
		btnFinSum.setContentAreaFilled(false); 
		btnFinSum.setFocusPainted(false); 
		btnFinSum.setOpaque(false);
		btnFinSum.setBounds(71, 93, 140, 140);
		getContentPane().add(btnFinSum);
		
		// manage employee btn
		btnMngEmployee = new JButton();
		mngEmployeeBtn();
		btnMngEmployee.setIcon(new ImageIcon("res/mngEmpBtn.png"));
		btnMngEmployee.setBorderPainted(false); 
		btnMngEmployee.setContentAreaFilled(false); 
		btnMngEmployee.setFocusPainted(false); 
		btnMngEmployee.setOpaque(false);
		btnMngEmployee.setBounds(232, 93, 140, 140);
		getContentPane().add(btnMngEmployee);
	}
	
	private void finSumBtn() {
		btnFinSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerFinancialSummary().setVisible(true);
			}
		});
	}
	
	private void mngEmployeeBtn() {
		btnMngEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerMngEmployee().setVisible(true);
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
