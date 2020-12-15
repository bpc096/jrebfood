package views_manager_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import views.core.ManagerMenuUI;

public class ManagerFinancialSummary extends JFrame {
	private JLabel lblHeader, lblIncome;
	private JScrollPane scroll;
	private JList listIncome;
	private JButton okBtn;

	public ManagerFinancialSummary() {
		initialize();
	}

	private void initialize() {
		config();
		
		// lblHeader label
		lblHeader = new JLabel("FINANCIAL SUMMARY");
		lblHeader.setForeground(new Color(50, 205, 50).darker());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Longhaul", Font.PLAIN, 38));
		lblHeader.setBounds(24, 13, 404, 49);
		getContentPane().add(lblHeader);
		
		// scroll view
		scroll = new JScrollPane();
		scroll.setBounds(49, 109, 352, 221);
		scroll.setViewportView(listIncome);
		getContentPane().add(scroll);
		
		// income list
		listIncome = new JList();
		scroll.setViewportView(listIncome);
		listIncome.setFont(new Font("MADE Tommy Soft", Font.PLAIN, 20));
		incomes();
		
		// back btn
		okBtn = new JButton();
		okBtn.setIcon(new ImageIcon("res/okBtn.png"));
		okBtn.setBorderPainted(false); 
		okBtn.setContentAreaFilled(false); 
		okBtn.setFocusPainted(false); 
		okBtn.setOpaque(false);
		okBtn();
		okBtn.setBounds(167, 354, 97, 37);
		getContentPane().add(okBtn);
		
		// income list lbl
		lblIncome = new JLabel("Income");
		lblIncome.setFont(new Font("MADE Tommy Soft", Font.BOLD, 20));
		lblIncome.setBounds(49, 76, 168, 26);
		getContentPane().add(lblIncome);
	}
	
	private void okBtn() {
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	private void incomes() {
		listIncome.setModel(new AbstractListModel() {
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
