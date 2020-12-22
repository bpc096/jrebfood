package controller;

import java.util.Vector;

import core.Controller;
import core.Model;

public class ManagerController extends Controller {
	
	private static String ID;
	

	public static String getID() {
		return ID;
	}

	public static void setID(String iD) {
		ID = iD;
	}

	public ManagerController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vector<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
