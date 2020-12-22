package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import model.FoodModel;
import model.UserModel;

public class FoodController extends Controller {
	
	private static FoodModel acc;

	public static FoodController controller;
	
	public FoodController() {
		// TODO Auto-generated constructor stub
	}
	
	public static FoodController getInstance() {
		return controller = (controller == null) ? new FoodController() : controller;
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Vector<Model> getAllFromChef(int chefID) {
		Vector<Model> data;
		FoodModel u = new FoodModel();
		
		data = u.getAllFromChef(chefID);
		
		return data;
	}

}
