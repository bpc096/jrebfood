package view.chef_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.View;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ChefManageMenu extends View {
	private JLabel lblHeader, lblAddDish, lblRemoveDish;
	private JButton btnAddDish, btnRemoveDish, btnOk;
	private JTextField textFieldAddDish, textFieldRemoveDish;

	public ChefManageMenu() {
		super();
		this.width = 460;
		this.height = 280;
		this.x = 1250;
		this.y = 360;
	}
	
	@Override
	public void initialize() {
		// lblHeader label
		lblHeader = new JLabel("MANAGE MENU");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(24, 13, 404, 49);
		getContentPane().add(lblHeader);

		// add dish label
		lblAddDish = new JLabel("Add Dish");
		lblAddDish.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblAddDish.setBounds(12, 96, 97, 16);
		getContentPane().add(lblAddDish);

		// remove dish label
		lblRemoveDish = new JLabel("Remove Dish");
		lblRemoveDish.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblRemoveDish.setBounds(12, 142, 132, 16);
		getContentPane().add(lblRemoveDish);

		// add dish txtfield
		textFieldAddDish = new JTextField();
		textFieldAddDish.setBounds(156, 90, 151, 22);
		getContentPane().add(textFieldAddDish);
		textFieldAddDish.setColumns(10);

		// remove dish txtfield
		textFieldRemoveDish = new JTextField();
		textFieldRemoveDish.setBounds(156, 136, 151, 22);
		getContentPane().add(textFieldRemoveDish);
		textFieldRemoveDish.setColumns(10);

		// add dish btn
		btnAddDish = new JButton();
		btnAddDish.setBounds(331, 75, 97, 49);
		btnAddDish.setIcon(new ImageIcon("res/addBtn.png"));
		btnAddDish.setBorderPainted(false);
		btnAddDish.setContentAreaFilled(false);
		btnAddDish.setFocusPainted(false);
		btnAddDish.setOpaque(false);
		getContentPane().add(btnAddDish);

		// remove dish btn
		btnRemoveDish = new JButton();
		btnRemoveDish.setIcon(new ImageIcon("res/removeBtn.png"));
		btnRemoveDish.setBorderPainted(false);
		btnRemoveDish.setContentAreaFilled(false);
		btnRemoveDish.setFocusPainted(false);
		btnRemoveDish.setOpaque(false);
		btnRemoveDish.setBounds(331, 125, 97, 49);
		getContentPane().add(btnRemoveDish);

		// back btn
		btnOk = new JButton();
		btnOk.setIcon(new ImageIcon("res/okBtn.png"));
		btnOk.setBorderPainted(false);
		btnOk.setContentAreaFilled(false);
		btnOk.setFocusPainted(false);
		btnOk.setOpaque(false);
		okBtn();
		btnOk.setBounds(186, 178, 97, 37);
		getContentPane().add(btnOk);
	}

	private void okBtn() {
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
