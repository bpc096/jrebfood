package views_customer_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import views.core.CustomerMenuUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerViewMenu extends JFrame {
	private JButton btnOk, btnAdd;
	private JScrollPane scroll;
	private JList listMenu;
	private JLabel lblHeader, lblFood;

	public CustomerViewMenu() {
		initialize();
	}

	private void initialize() {
		config();
		
		// view menu label
		lblHeader = new JLabel("VIEW MENU");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(24, 13, 404, 49);
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
		btnOk.setIcon(new ImageIcon("res/backBtn.png"));
		btnOk.setBorderPainted(false); 
		btnOk.setContentAreaFilled(false); 
		btnOk.setFocusPainted(false); 
		btnOk.setOpaque(false);
		okBtn();
		btnOk.setBounds(99, 354, 97, 37);
		getContentPane().add(btnOk);
		
		// add button
		btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon("res/addBtn.png"));
		btnAdd.setBorderPainted(false); 
		btnAdd.setContentAreaFilled(false); 
		btnAdd.setFocusPainted(false); 
		btnAdd.setOpaque(false);
		btnAdd.setBounds(231, 354, 97, 37);
		getContentPane().add(btnAdd);
		
		// food list label
		lblFood = new JLabel("Food");
		lblFood.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblFood.setBounds(49, 76, 168, 26);
		getContentPane().add(lblFood);
	}
	
	private void okBtn() {
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerMenuUI().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private void menu() {
		listMenu.setModel(new AbstractListModel() {
			String[] values = new String[] {"test", "test"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
	
	private void config() {
		setLocation(750, 360);
		setResizable(false);
		setSize(new Dimension(460, 450));
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(new ImageIcon("res/jrebfood_logo.png").getImage());
		setTitle("JrebFood");
	}
}
