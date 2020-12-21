package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.Model;

public class DriverModel extends Model {

	private Integer id, driver_id;
	private String driver_email;
	
	public DriverModel() {
		this.tableName = "driver";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, driver_id);
			ps.setString(2, driver_email);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		String query = String.format("UPDATE %s SET driver_id=?, driver_email=? WHERE id=?", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, driver_id);
			ps.setString(2, driver_email);
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
			ps.setInt(1, driver_id);
			ps.setString(2, driver_email);
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
				Integer driver_id = rs.getInt("driver_id");
				String driver_email = rs.getString("driver_email");
				
				DriverModel d = new DriverModel();
				d.setId(id);
				d.setDriver_id(driver_id);
				d.setDriver_email(driver_email);
				
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

	public Integer getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(Integer driver_id) {
		this.driver_id = driver_id;
	}

	public String getDriver_email() {
		return driver_email;
	}

	public void setDriver_email(String driver_email) {
		this.driver_email = driver_email;
	}
}
