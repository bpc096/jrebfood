package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.model.Model;

public class FoodModel extends Model{
	
	private Integer food_id, food_price, food_stock;
	private String food_name, food_description;
	
	public FoodModel() {
		this.tableName = "foods";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, food_name);
			ps.setString(2, food_description);
			ps.setInt(3, food_price);
			ps.setInt(4, food_stock);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		String query = String.format("UPDATE %s SET food_name=?, food_description=?, food_price=?, food_stock=? WHERE id=?", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setString(1, food_name);
			ps.setString(2, food_description);
			ps.setInt(3, food_price);
			ps.setInt(4, food_stock);
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
			ps.setString(1, food_name);
			ps.setString(2, food_description);
			ps.setInt(3, food_price);
			ps.setInt(4, food_stock);
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
				Integer food_id = rs.getInt("food_id");
				String food_name = rs.getString("food_name");
				String food_description = rs.getString("food_decription");
				Integer food_price = rs.getInt("food_price");
				Integer food_stock = rs.getInt("food_stock");
				
				FoodModel f = new FoodModel();
				f.setFood_id(food_id);
				f.setFood_name(food_name);
				f.setFood_description(food_description);
				f.setFood_price(food_price);
				f.setFood_stock(food_stock);
				
				data.add(f);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Integer getFood_id() {
		return food_id;
	}

	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}

	public Integer getFood_price() {
		return food_price;
	}

	public void setFood_price(Integer food_price) {
		this.food_price = food_price;
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

	public Integer getFood_stock() {
		return food_stock;
	}

	public void setFood_stock(Integer food_stock) {
		this.food_stock = food_stock;
	}
	
}
