package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import model.ChefModel;
import model.UserModel;

public class ChefController extends Controller {
	
	private static ChefModel acc;

	public static ChefController controller;

	public ChefController() {
		// TODO Auto-generated constructor stub
	}
	

	public static ChefController getInstance() {
		return controller = (controller == null) ? new ChefController() : controller;
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean findAcc(String email, String password) {
		ChefModel u = new ChefModel();
		acc = u.findAcc(email, password);
		
		if (acc != null)
			return true;
		return false;
	}

}
