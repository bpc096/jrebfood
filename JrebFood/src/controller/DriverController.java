package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import model.DriverModel;

public class DriverController extends Controller {

	private static DriverModel acc;

	public static DriverController controller;
	
	public DriverController() {
		// TODO Auto-generated constructor stub
	}
	
	public static DriverController getInstance() {
		return controller = (controller == null) ? new DriverController() : controller;
	}


	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean findAcc(String email, String password) {
		DriverModel u = new DriverModel();
		acc = u.findAcc(email, password);
		
		if (acc != null)
			return true;
		return false;
	}

}
