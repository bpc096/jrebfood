package view.manager_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.Connect;
import core.View;
import view.home_view.ManagerMenuUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class ManagerMngEmployee extends View {
	private JLabel lblHeader, lblListName;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnBack, btnFire, btnHire;
	private JList listEmployee;

	Connect con = new Connect();

	public ManagerMngEmployee() {
		super();
		this.width = 460;
		this.height = 450;
		this.x = 770;
		this.y = 360;
	}

	@Override
	public void initialize() {
		// hader label
		lblHeader = new JLabel("MANAGE EMPLOYEE");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(24, 13, 404, 49);
		getContentPane().add(lblHeader);

		// scrollview
		scroll = new JScrollPane();
		scroll.setBounds(49, 109, 352, 221);
		scroll.setViewportView(listEmployee);
		getContentPane().add(scroll);

		// employee list
		listEmployee = new JList();
		scroll.setViewportView(listEmployee);
		listEmployee.setFont(new Font("MADE Tommy Soft", Font.PLAIN, 20));
		employees();

		// back btn
		btnBack = new JButton();
		btnBack.setIcon(new ImageIcon("res/backBtn.png"));
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusPainted(false);
		btnBack.setOpaque(false);
		backBtn();
		btnBack.setBounds(49, 343, 97, 42);
		getContentPane().add(btnBack);

		// fire btn
		btnFire = new JButton();
		btnFire.setIcon(new ImageIcon("res/fireBtn.png"));
		btnFire.setBorderPainted(false);
		btnFire.setContentAreaFilled(false);
		btnFire.setFocusPainted(false);
		btnFire.setOpaque(false);
		fireBtn();
		btnFire.setBounds(175, 343, 97, 42);
		getContentPane().add(btnFire);

		// hire btn
		btnHire = new JButton();
		btnHire.setIcon(new ImageIcon("res/hireBtn.png"));
		btnHire.setBorderPainted(false);
		btnHire.setContentAreaFilled(false);
		btnHire.setFocusPainted(false);
		btnHire.setOpaque(false);
		hireBtn();
		btnHire.setBounds(304, 343, 97, 42);
		getContentPane().add(btnHire);

		// list name label
		lblListName = new JLabel("User Names");
		lblListName.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblListName.setBounds(49, 76, 168, 26);
		getContentPane().add(lblListName);
	}

	private void backBtn() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerMenuUI().config();
				setVisible(false);
			}
		});
	}

	private void fireBtn() {
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void hireBtn() {
		btnHire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void employees() {
		listEmployee.setModel(new AbstractListModel() {
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
