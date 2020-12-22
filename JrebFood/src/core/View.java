package core;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class View extends JFrame{
	protected int width, height; // frame dimension
	protected int x, y; // frame location
	
	public View() {
		initialize();
	}
	
	public void config() {
		setLocation(x, y);
		setResizable(false);
		setSize(width, height);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(new ImageIcon("res/jrebfood_logo.png").getImage());
		setTitle("JrebFood");
	}
	
	public abstract void initialize();
}
