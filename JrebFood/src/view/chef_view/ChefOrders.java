package view.chef_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import core.View;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChefOrders extends View {
	private JButton btnOk;
	private JScrollPane scroll;
	private JList listMenu;
	private JLabel lblHeader, lblOrders;

	public ChefOrders() {
		super();
		this.width = 460;
		this.height = 450;
		this.x = 250;
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

		// scroll view
		scroll = new JScrollPane();
		scroll.setBounds(49, 109, 352, 221);
		scroll.setViewportView(listMenu);
		getContentPane().add(scroll);

		// menu list
		listMenu = new JList();
		listMenu.setFont(new Font("MADE Tommy Soft", Font.PLAIN, 20));
		scroll.setViewportView(listMenu);
		menu();

		// back button
		btnOk = new JButton();
		btnOk.setIcon(new ImageIcon("res/okBtn.png"));
		btnOk.setBorderPainted(false);
		btnOk.setContentAreaFilled(false);
		btnOk.setFocusPainted(false);
		btnOk.setOpaque(false);
		okBtn();
		btnOk.setBounds(167, 354, 97, 37);
		getContentPane().add(btnOk);

		// purchase history
		lblOrders = new JLabel("Orders");
		lblOrders.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblOrders.setBounds(49, 76, 168, 26);
		getContentPane().add(lblOrders);
	}
	
	private void okBtn() {
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	private void menu() {
		listMenu.setModel(new AbstractListModel() {
			String[] values = new String[] { "test", "test" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
}
