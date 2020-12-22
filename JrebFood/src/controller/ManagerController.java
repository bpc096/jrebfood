package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import model.ManagerModel;
import model.UserModel;

public class ManagerController extends Controller {
	
	private static ManagerModel acc;

	public static ManagerController controller;

	public ManagerController() {
		// TODO Auto-generated constructor stub
	}
	
	public static ManagerController getInstance() {
		return controller = (controller == null) ? new ManagerController() : controller;
	}
	
	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean findAcc(String email, String password) {
		ManagerModel u = new ManagerModel();
		acc = u.findAcc(email, password);
		
		if (acc != null)
			return true;
		return false;
	}

}
