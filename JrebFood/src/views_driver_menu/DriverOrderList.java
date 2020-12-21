package views_driver_menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import view.core.View;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DriverOrderList extends View {
	private JButton btnOk, btnAccept;
	private JScrollPane scroll;
	private JList listMenu;
	private JLabel lblHeader, lblActive;

	public DriverOrderList() {
		super();
		this.width = 460;
		this.height = 450;
		this.x = 250;
		this.y = 360;
	}

	@Override
	public void initialize() {
		// view menu label
		lblHeader = new JLabel("ORDER LIST");
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
		btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon("res/okBtn.png"));
		btnOk.setBorderPainted(false);
		btnOk.setContentAreaFilled(false);
		btnOk.setFocusPainted(false);
		btnOk.setOpaque(false);
		okBtn();
		btnOk.setBounds(102, 353, 97, 37);
		getContentPane().add(btnOk);

		// accept btn
		btnAccept = new JButton();
		btnAccept.setIcon(new ImageIcon("res/acceptBtn.png"));
		btnAccept.setBorderPainted(false);
		btnAccept.setContentAreaFilled(false);
		btnAccept.setFocusPainted(false);
		btnAccept.setOpaque(false);
		btnAccept.setBounds(241, 353, 97, 37);
		getContentPane().add(btnAccept);

		// active order
		lblActive = new JLabel("Orders");
		lblActive.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblActive.setBounds(49, 76, 168, 26);
		getContentPane().add(lblActive);
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
