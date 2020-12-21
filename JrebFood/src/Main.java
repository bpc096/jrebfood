import java.awt.EventQueue;

import connect.Connect;
import views_home.LoginUI;

public class Main {
	
	public Main() {
<<<<<<< HEAD
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
=======
//		con.getConnection();
		new LoginUI().config();
>>>>>>> ec975f01b5cc9e9f8f826b5f441ae73128edd6ec
	}

	public static void main(String[] args) {
		new Main();
	}
}
