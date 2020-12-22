package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.Model;

public class OrderDetailsModel extends Model {
	
	private Integer id, user_id, food_id, order_id, food_quantity;
	
	public OrderDetailsModel() {
		this.tableName = "order_details";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, user_id);
			ps.setInt(2, food_id);
			ps.setInt(3, order_id);
			ps.setInt(4, food_quantity);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		String query = String.format("UPDATE %s SET user_id=?, food_id=?, order_id=?, food_quantity=? WHERE id=?", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, user_id);
			ps.setInt(2, food_id);
			ps.setInt(3, order_id);
			ps.setInt(4, food_quantity);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, user_id);
			ps.setInt(2, food_id);
			ps.setInt(3, order_id);
			ps.setInt(4, food_quantity);
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
				Integer user_id = rs.getInt("user_id");
				Integer food_id = rs.getInt("food_id");
				Integer order_id = rs.getInt("order_id");
				Integer food_quantity = rs.getInt("food_quantity");
				
				OrderDetailsModel os = new OrderDetailsModel();
				os.setId(id);
				os.setUser_id(user_id);
				os.setFood_id(food_id);
				os.setOrder_id(order_id);
				os.setFood_quantity(food_quantity);
				
				data.add(os);
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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getFood_id() {
		return food_id;
	}

	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getFood_quantity() {
		return food_quantity;
	}

	public void setFood_quantity(Integer food_quantity) {
		this.food_quantity = food_quantity;
	}

}
