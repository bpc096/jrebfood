package views_chef_menu;

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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChefViewMenu extends JFrame {
	private JButton btnOk;
	private JScrollPane scroll;
	private JList listMenu;
	private JLabel lblHeader, lblMenu;

	public ChefViewMenu() {
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
		btnOk.setIcon(new ImageIcon("res/okBtn.png"));
		btnOk.setBorderPainted(false); 
		btnOk.setContentAreaFilled(false); 
		btnOk.setFocusPainted(false); 
		btnOk.setOpaque(false);
		okBtn();
		btnOk.setBounds(167, 354, 97, 37);
		getContentPane().add(btnOk);
		
		// menu list lbl
		lblMenu = new JLabel("Food");
		lblMenu.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblMenu.setBounds(49, 76, 168, 26);
		getContentPane().add(lblMenu);
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
		setLocation(250, 360);
		setResizable(false);
		setSize(new Dimension(460, 450));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(new ImageIcon("res/jrebfood_logo.png").getImage());
		setTitle("JrebFood");
	}
}
