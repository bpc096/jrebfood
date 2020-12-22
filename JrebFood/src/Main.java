import java.awt.EventQueue;

import connect.Connect;
import controller.HomeController;
import view.home_view.LoginUI;

public class Main {
	
	public Main() {
		Connect.getConnection();
		HomeController.getInstance().viewLoginUI().config();
	}

	public static void main(String[] args) {
		new Main();
	}
}
