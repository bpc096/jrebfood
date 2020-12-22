package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.Model;

public class FoodModel extends Model {
	
	private Integer id, chefId, price;
	private String name, desc, available;
	
	public FoodModel() {
		this.tableName = "Food";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, id);
			ps.setInt(2, chefId);
			ps.setString(3,  name);
			ps.setString(4, desc);
			ps.setInt(5, price);
			ps.setString(6, available);
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
			ps.setInt(1, id);
			ps.setInt(2, chefId);
			ps.setString(3,  name);
			ps.setString(4, desc);
			ps.setInt(5, price);
			ps.setString(6, available);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		String query = String.format("DELETE FROM %s WHERE ChefID = %s", tableName, id);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, id);
			ps.setInt(2, chefId);
			ps.setString(3,  name);
			ps.setString(4, desc);
			ps.setInt(5, price);
			ps.setString(6, available);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Vector<Model> getAll() {
		Vector<Model> data = new Vector<>();
		
		String query = String.format("SELECT * FROM %s WHERE ChefID = ", tableName);
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Integer id = rs.getInt("FoodID");
				Integer chefId = rs.getInt("ChefID");
				String name = rs.getString("Name");
				String desc = rs.getString("Description");
				Integer price = rs.getInt("Price");
				String available = rs.getString("Available");
				
				FoodModel f = new FoodModel();
				f.setId(id);
				f.setChefId(chefId);
				f.setName(name);
				f.setDesc(desc);
				f.setPrice(price);
				f.setAvailable(available);
				
				data.add(f);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Vector<Model> getAllFromChef(int chefID){
		Vector<Model> data = new Vector<>();
		
		String query = String.format("SELECT * FROM %s WHERE ChefID = %s", tableName, chefID);
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Integer id = rs.getInt("FoodID");
				Integer chefId = rs.getInt("ChefID");
				String name = rs.getString("Name");
				String desc = rs.getString("Description");
				Integer price = rs.getInt("Price");
				String available = rs.getString("Available");
				
				FoodModel f = new FoodModel();
				f.setId(id);
				f.setChefId(chefId);
				f.setName(name);
				f.setDesc(desc);
				f.setPrice(price);
				f.setAvailable(available);
				System.out.println("success " + name);
				data.add(f);
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

	public Integer getChefId() {
		return chefId;
	}

	public void setChefId(Integer chefId) {
		this.chefId = chefId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

}
