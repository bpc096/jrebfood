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

import views.core.ChefMenuUI;
import views.core.CustomerMenuUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CustomerCheckout extends JFrame {
	private JButton btnOk;
	private JScrollPane scroll;
	private JList listMenu;
	private JLabel lblHeader, lblItems;
	private JButton btnRemove;

	public CustomerCheckout() {
		initialize();
	}

	private void initialize() {
		config();
		
		// view menu label
		lblHeader = new JLabel("CHECKOUT");
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
		
		// pay button
		btnRemove = new JButton();
		btnRemove.setIcon(new ImageIcon("res/payBtn.png"));
		btnRemove.setBorderPainted(false); 
		btnRemove.setContentAreaFilled(false); 
		btnRemove.setFocusPainted(false); 
		btnRemove.setOpaque(false);
		btnRemove.setBounds(231, 354, 97, 37);
		getContentPane().add(btnRemove);
		
		// items label
		lblItems = new JLabel("Items");
		lblItems.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblItems.setBounds(49, 76, 168, 26);
		getContentPane().add(lblItems);
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
