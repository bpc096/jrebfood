package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import core.View;
import view.home_view.LoginUI;

public class HomeController extends Controller {
	
	public static HomeController controller;
	
	public static HomeController getInstance() {
		return controller = (controller == null) ? new HomeController() : controller;
	}
	
	public View viewLoginUI() {
		return new LoginUI();
	}
	
	public boolean validEmailPassword(String email, String password) {
		if (email.length() >= 30 || password.length() >= 30)
			return false;
		return true;
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
