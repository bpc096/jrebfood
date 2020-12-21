import java.awt.EventQueue;

import connect.Connect;
import views_home.LoginUI;

public class Main {
	
	Connect con;
	
	public Main() {
//		con.getConnection();
		new LoginUI().config();
	}

	public static void main(String[] args) {
		new Main();
	}
}
