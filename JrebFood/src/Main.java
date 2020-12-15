import java.awt.EventQueue;

import views.core.LoginUI;

public class Main {
	
	public Main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI login = new LoginUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new Main();
	}
}
