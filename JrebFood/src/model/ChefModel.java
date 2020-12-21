package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.model.Model;

public class ChefModel extends Model{

	private Integer id, chef_id;
	private String chef_email, food_name, food_description;
	
	public ChefModel() {
		this.tableName = "chef";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, chef_id);
			ps.setString(2, chef_email);
			ps.setString(3, food_name);
			ps.setString(4, food_description);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		String query = String.format("UPDATE %s SET chef_id=?, chef_email=?, food_name=?, food_description=? WHERE id=?", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, chef_id);
			ps.setString(2, chef_email);
			ps.setString(3, food_name);
			ps.setString(4, food_description);
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
			ps.setInt(1, chef_id);
			ps.setString(2, chef_email);
			ps.setString(3, food_name);
			ps.setString(4, food_description);
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
				Integer chef_id = rs.getInt("chef_id");
				String chef_email = rs.getString("chef_email");
				String food_name = rs.getString("food_name");
				String food_description = rs.getString("food_description");
				
				ChefModel c = new ChefModel();
				c.setId(id);
				c.setChef_id(chef_id);
				c.setChef_email(chef_email);
				c.setFood_name(food_name);
				c.setFood_description(food_description);
				
				data.add(c);
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

	public Integer getChef_id() {
		return chef_id;
	}

	public void setChef_id(Integer chef_id) {
		this.chef_id = chef_id;
	}
	
	public String getChef_email() {
		return chef_email;
	}

	public void setChef_email(String chef_email) {
		this.chef_email = chef_email;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getFood_description() {
		return food_description;
	}

	public void setFood_description(String food_description) {
		this.food_description = food_description;
	}

}
