import java.awt.EventQueue;

import connect.Connect;
import views.core.LoginUI;

public class Main {
	
	Connect con;
	
	public Main() {
	con.getConnection();
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
	}

	public static void main(String[] args) {
		new Main();
	}
}
