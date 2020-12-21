package views_driver_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.core.View;
import views_home.DriverMenuUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DriverViewOrder extends View {
	private JButton btnOrderList, btnHistory, backBtn;
	private JLabel lblHeader;

	public DriverViewOrder() {
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
		btnOrderList = new JButton();
		orderBtn();
		btnOrderList.setIcon(new ImageIcon("res/avOrderBtn.png"));
		btnOrderList.setBorderPainted(false);
		btnOrderList.setContentAreaFilled(false);
		btnOrderList.setFocusPainted(false);
		btnOrderList.setOpaque(false);
		btnOrderList.setBounds(71, 75, 140, 140);
		getContentPane().add(btnOrderList);

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

	private void orderBtn() {
		btnOrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverOrderList().mConfig();
			}
		});
	}

	private void historyBtn() {
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverOrderHistory().mConfig();
			}
		});
	}

	private void backBtn() {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DriverMenuUI().config();
				setVisible(false);
			}
		});
	}
}
