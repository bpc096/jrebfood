package views_driver_menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.core.View;
import views_home.DriverMenuUI;

public class DriverDeliverOrder extends View {
	private JLabel lblHeader, lblStats, lblOrderStatus;
	private JButton deliverBtn, backBtn;

	public DriverDeliverOrder() {
		super();
		this.width = 470;
		this.height = 240;
		this.x = 750;
		this.y = 360;
	}

	@Override
	public void initialize() {
		// lblHeader label
		lblHeader = new JLabel("DELIVER ORDER");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(12, 13, 404, 49);
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

		// back btn
		deliverBtn = new JButton();
		deliverOrderBtn();
		deliverBtn.setIcon(new ImageIcon("res/deliverOrderBtn.png"));
		deliverBtn.setBorderPainted(false);
		deliverBtn.setContentAreaFilled(false);
		deliverBtn.setFocusPainted(false);
		deliverBtn.setOpaque(false);
		deliverBtn.setBounds(253, 132, 117, 49);
		getContentPane().add(deliverBtn);

		// deliver order btn
		backBtn = new JButton();
		backBtn.setIcon(new ImageIcon("res/backBtn.png"));
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setOpaque(false);
		backBtn();
		backBtn.setBounds(101, 127, 97, 54);
		getContentPane().add(backBtn);
	}

	private void deliverOrderBtn() {
		deliverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverMenuUI().config();
				setVisible(false);
			}
		});
	}

	private void backBtn() {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DriverOrderStatus().config();
				setVisible(false);
			}
		});
	}
}
