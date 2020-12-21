package controller;

import java.util.Vector;

import core.Controller;
import core.Model;
import model.UserModel;

public class UserController extends Controller {

	private UserModel user;
	private static UserController controller;
	
	public UserController() {
		user = new UserModel();
	}
	
	public static UserController getInstance() {
		return controller = (controller == null) ? new UserController() : controller;
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return user.getAll();
	}

	public void insert(String name, String email, String phone_number, String password) {
		UserModel u = new UserModel();
		u.setName(name);
		u.setEmail(email);
		u.setPhone_number(phone_number);
		u.setPassword(password);
		
		u.insert();
	}

	public void update(String name, String email, String phone_number, String password, Integer id) {
		UserModel u = new UserModel();
		u.setName(name);
		u.setEmail(email);
		u.setPhone_number(phone_number);
		u.setPassword(password);
		u.setId(id);
		
		u.update();
	}
	
	public void delete(Integer id) {
		UserModel u = new UserModel();
		u.setId(id);
		
		u.delete();
	}

}
