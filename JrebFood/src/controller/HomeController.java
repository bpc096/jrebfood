package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import core.View;
import view.home_view.LoginUI;
import view.home_view.RegisterUI;

public class HomeController extends Controller {
	
	public static HomeController controller;
	
	public static HomeController getInstance() {
		return controller = (controller == null) ? new HomeController() : controller;
	}
	
	public void viewLoginUI() {
		new LoginUI().config();
	}
	
	public void viewRegisterUI() {
		new RegisterUI().config();
	}
	
	public boolean validEmailPassword(String email, String password) {
		if (email.length() >= 30 || password.length() >= 30)
			return false;
		if (email.length() <= 3 || password.length() <= 3)
			return false;
		if (!(email.endsWith(".com") && email.contains("@")))
			return false;
		return true;
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
