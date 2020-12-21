package views_chef_menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.core.View;

import javax.swing.JComboBox;

public class ChefFoodStatus extends View {
	private JComboBox comboFoodName;
	private JLabel lblHeader, lblFoodName;
	private JButton btnAvailable, btnUnavailable, btnOk;

	public ChefFoodStatus() {
		super();
		this.width = 520;
		this.height = 240;
		this.x = 1250;
		this.y = 360;
	}

	@Override
	public void initialize() {
		// lblHeader label
		lblHeader = new JLabel("FOOD STATUS");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(64, 13, 404, 49);
		getContentPane().add(lblHeader);

		// dish availability label
		lblFoodName = new JLabel("Food Availability");
		lblFoodName.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblFoodName.setBounds(12, 98, 165, 16);
		getContentPane().add(lblFoodName);

		// food name combo
		comboFoodName = new JComboBox();
		comboFoodName.setBounds(178, 97, 201, 22);
		getContentPane().add(comboFoodName);

		// back btn
		btnOk = new JButton();
		btnOk.setIcon(new ImageIcon("res/okBtn.png"));
		btnOk.setBorderPainted(false);
		btnOk.setContentAreaFilled(false);
		btnOk.setFocusPainted(false);
		btnOk.setOpaque(false);
		okBtn();
		btnOk.setBounds(224, 132, 97, 49);
		getContentPane().add(btnOk);

		// food available btn
		btnAvailable = new JButton();
		btnAvailable.setIcon(new ImageIcon("res/tickBtn.png"));
		btnAvailable.setBorderPainted(false);
		btnAvailable.setContentAreaFilled(false);
		btnAvailable.setFocusPainted(false);
		btnAvailable.setOpaque(false);
		btnAvailable.setBounds(391, 86, 49, 44);
		getContentPane().add(btnAvailable);

		// food unavailable btn
		btnUnavailable = new JButton();
		btnUnavailable.setIcon(new ImageIcon("res/crossBtn.png"));
		btnUnavailable.setBorderPainted(false);
		btnUnavailable.setContentAreaFilled(false);
		btnUnavailable.setFocusPainted(false);
		btnUnavailable.setOpaque(false);
		btnUnavailable.setBounds(447, 86, 49, 44);
		getContentPane().add(btnUnavailable);
	}

	private void okBtn() {
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
