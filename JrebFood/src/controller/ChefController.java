package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import core.View;
import model.ChefModel;
import model.FoodModel;
import model.UserModel;
import view.chef_view.ChefFoodStatus;
import view.chef_view.ChefManageMenu;
import view.chef_view.ChefOrders;
import view.chef_view.ChefViewMenu;

public class ChefController extends Controller {
	
	private static ChefModel acc;

	public static ChefController controller;

	public ChefController() {
		// TODO Auto-generated constructor stub
	}
	

	public static ChefController getInstance() {
		return controller = (controller == null) ? new ChefController() : controller;
	}
	
	public void viewMenu() {
		new ChefViewMenu().mconfig();
	}
	
	public void viewManageMenu() {
		new ChefManageMenu().mconfig();
	}
	
	public void viewFoodStatus() {
		new ChefFoodStatus().mconfig();
	}
	
	public void viewChefOrder() {
		new ChefOrders().mconfig();
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Vector<Model> getAllFromChef() {
		Vector<Model> data;
		FoodModel u = new FoodModel();
		
		data = FoodController.getInstance().getAllFromChef(acc.getId());
		
		return data;
	}
	
	public boolean findAcc(String email, String password) {
		ChefModel u = new ChefModel();
		acc = u.findAcc(email, password);
		
		if (acc != null)
			return true;
		return false;
	}

}
