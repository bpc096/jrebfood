package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.Model;

public class DriverModel extends Model {

	private Integer id, profit;
	private String name, email, password;

	public DriverModel() {
		this.tableName = "Driver";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, email);
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
			ps.setString(1, email);
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
			ps.setString(2, email);
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
				d.setEmail(driver_email);
				
				data.add(d);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public DriverModel findAcc(String findEmail, String findPassword) {
		DriverModel u;
		String query = String.format("SELECT * FROM %s WHERE Email = '%s' AND Password = '%s'", tableName, findEmail, findPassword);
		ResultSet rs = con.executeQuery(query);
		try {
			while (rs.next()) {
				Integer id = rs.getInt("DriverID");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				Integer profit = rs.getInt("Profit");
					
				u = new DriverModel();
				u.setId(id);
				u.setName(name);
				u.setEmail(email);
				u.setPassword(password);
				u.setProfit(profit);
				return u;
			}
		}
		catch (Exception e) {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProfit() {
		return profit;
	}

	public void setProfit(Integer profit) {
		this.profit = profit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
