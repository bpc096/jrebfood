package view.chef_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.ChefController;
import core.Model;
import core.View;
import model.FoodModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ChefViewMenu extends View {
	private JButton btnOk;
	private JScrollPane scroll;
	private JTable table;
	private JLabel lblHeader, lblMenu;
	
	private Vector<String> header;
	private Vector<Vector<String>> data;

	public ChefViewMenu() {
		super();
		this.width = 660;
		this.height = 450;
		this.x = 250;
		this.y = 360;
	}
	
	@Override
	public void initialize() {
		// view menu label
		lblHeader = new JLabel("VIEW MENU");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(124, 13, 404, 49);
		getContentPane().add(lblHeader);

		// scroll view
		scroll = new JScrollPane();
		scroll.setBounds(49, 109, 532, 221);
		scroll.setViewportView(table);
		getContentPane().add(scroll);

		// menu list
		table = new JTable();
		table.setFont(new Font("MADE Tommy Soft", Font.PLAIN, 12));
		scroll.setViewportView(table);
		menu();

		// back button
		btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon("res/okBtn.png"));
		btnOk.setBorderPainted(false);
		btnOk.setContentAreaFilled(false);
		btnOk.setFocusPainted(false);
		btnOk.setOpaque(false);
		okBtn();
		btnOk.setBounds(277, 354, 97, 37);
		getContentPane().add(btnOk);

		// menu list lbl
		lblMenu = new JLabel("Food");
		lblMenu.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblMenu.setBounds(49, 76, 168, 26);
		getContentPane().add(lblMenu);
		
		loadData();
	}
	
	private void okBtn() {
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	private void menu() {
		
	}
	
	public void loadData() {
		data = new Vector<>();
		header = new Vector<>();
		
		header.add("Food ID");
		header.add("Name");
		header.add("Description");
		header.add("Price");
		header.add("Available");
		
		Vector<Model> ProductList = ChefController.getInstance().getAllFromChef();
		
		if (ProductList != null) {
			for (Model model : ProductList) {
				FoodModel p = (FoodModel) model;
				Vector detail = new Vector<>();
				
				detail.add(String.valueOf(p.getId()));
				detail.add(p.getName());
				detail.add(p.getDesc());
				detail.add(String.valueOf(p.getPrice()));
				detail.add(p.getAvailable());
				
				data.add(detail);
			}
		}
		
		DefaultTableModel dtm = new DefaultTableModel(data, header) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		table.setModel(dtm);
	}
	
}
