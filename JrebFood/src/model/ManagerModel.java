package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.Model;

public class ManagerModel extends Model {

	private Integer id;
	private String name, email, password;
	
	public ManagerModel() {
		this.tableName = "manager";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
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
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
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
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
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
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				ManagerModel d = new ManagerModel();
				d.setId(id);
				d.setName(name);
				d.setEmail(email);
				
				data.add(d);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public ManagerModel findAcc(String findEmail, String findPassword) {
		ManagerModel m;
		String query = String.format("SELECT * FROM %s WHERE Email = '%s' AND Password = '%s'", tableName, findEmail, findPassword);
		ResultSet rs = con.executeQuery(query);
		try {
			while (rs.next()) {
				Integer id = rs.getInt("ManagerID");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
					
				m = new ManagerModel();
				m.setId(id);
				m.setName(name);
				m.setEmail(email);
				m.setPassword(password);
				return m;
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
