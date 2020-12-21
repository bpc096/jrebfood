package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.Model;

public class ManagerModel extends Model {

	private Integer id, manager_id;
	private String emp_email;
	
	public ManagerModel() {
		this.tableName = "manager";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, manager_id);
			ps.setString(2, emp_email);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		String query = String.format("UPDATE %s SET name=?, email=?, phone_number=?, password=? WHERE id=?", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, manager_id);
			ps.setString(2, emp_email);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		String query = String.format("DELETE FROM %s WHERE id=?", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, manager_id);
			ps.setString(2, emp_email);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Vector<Model> getAll() {
		Vector<Model> data = new Vector<>();
		
		String query = String.format("SELECT * FROM %s", tableName);
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Integer id = rs.getInt("id");
				Integer manager_id = rs.getInt("manager_id");
				String emp_email = rs.getString("emp_email");
				
				ManagerModel d = new ManagerModel();
				d.setId(id);
				d.setManager_id(manager_id);
				d.setEmp_email(emp_email);
				
				data.add(d);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	
}
