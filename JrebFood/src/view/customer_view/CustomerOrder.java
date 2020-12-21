package view.customer_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.View;
import view.home_view.CustomerMenuUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerOrder extends View implements ActionListener {
	private JButton btnActive, btnHistory, backBtn;
	private JLabel lblHeader;

	public CustomerOrder() {
		super();
		this.width = 460;
		this.height = 330;
		this.x = 750;
		this.y = 360;
	}

	@Override
	public void initialize() {
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
				new CustomerOrderActive().mConfig();
			}
		});
	}

	private void historyBtn() {
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerOrderHistory().mConfig();
			}
		});
	}

	private void backBtn() {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CustomerMenuUI().config();
				setVisible(false);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
