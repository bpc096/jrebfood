import java.awt.EventQueue;

import connect.Connect;
import view.home_view.LoginUI;

public class Main {
	
	public Main() {
		Connect.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI login = new LoginUI();
					// UserController.getInstance().view().showForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		con.getConnection();  
		new LoginUI().config();
	}

	public static void main(String[] args) {
		new Main();
	}
}
