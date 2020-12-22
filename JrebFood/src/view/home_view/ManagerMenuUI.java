package view.home_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.View;
import view.manager_view.ManagerFinancialSummary;
import view.manager_view.ManagerMngEmployee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMenuUI extends View {
	private JButton btnFinSum, btnMngEmployee, btnLogout;
	private JLabel lblHeader;

	public ManagerMenuUI() {
		super();
		this.width = 460;
		this.height = 340;
		this.x = 750;
		this.y = 360;
	}

	@Override
	public void initialize() {
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

	private void finSumBtn() {
		btnFinSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerFinancialSummary().config();
			}
		});
	}

	private void mngEmployeeBtn() {
		btnMngEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerMngEmployee().config();
				setVisible(false);
			}
		});
	}
}
