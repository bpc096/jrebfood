package controller;

import java.util.Vector;

import javax.swing.JOptionPane;

import core.Controller;
import core.Model;
import model.UserModel;

public class UserController extends Controller {

	private static UserModel acc;

	public static UserController controller;
	
	
	public UserController() {
		
	}
	
	public static UserController getInstance() {
		return controller = (controller == null) ? new UserController() : controller;
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return acc.getAll();
	}

	
	public boolean validateInsert(String name, String email, String password, String phoneNum) {
		if (name.length() >= 30 || email.length() >= 30 || phoneNum.length() >= 30 || password.length() >= 30)
			return false;	
		if (name.length() <= 3 || email.length() <= 3 || phoneNum.length() <= 3 || password.length() <= 3)
			return false;	
		if (!(email.contains(".com") && email.contains("@")))
			return false;
		for (char i : phoneNum.toCharArray()) {
			if (!Character.isDigit(i))
				return false;
		}
		return true;
	}
	
	public boolean insert(String name, String email, String password, String phoneNum) {
		if (!validateInsert(name, email, password, phoneNum))
			return false;
		UserModel u = new UserModel();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhoneNum(phoneNum);
		
		u.insert();
		return true;
	}

	public void update(String name, String email, String phone_number, String password, Integer id) {
		UserModel u = new UserModel();
		u.setName(name);
		u.setEmail(email);
		u.setPhoneNum(phone_number);
		u.setPassword(password);
		u.setId(id);
		
		u.update();
	}
	
	public void delete(Integer id) {
		UserModel u = new UserModel();
		u.setId(id);
		
		u.delete();
	}
	
	public boolean findAcc(String email, String password) {
		UserModel u = new UserModel();
		acc = u.findAcc(email, password);
		
		if (acc != null)
			return true;
		return false;
	}

}
