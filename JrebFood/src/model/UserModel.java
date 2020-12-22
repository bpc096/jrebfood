package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import core.Model;

public class UserModel extends Model {
	
	private Integer id;
	private String name, email, phoneNum, password;
	
	public UserModel() {
		this.tableName = "User";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phoneNum);
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
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phoneNum);
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
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phoneNum);
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
				String phone_number = rs.getString("phone_number");
				String password = rs.getString("password");
				
				UserModel u = new UserModel();
				u.setId(id);
				u.setName(name);
				u.setEmail(email);
				u.setPhoneNum(phone_number);
				u.setPassword(password);
				
				data.add(u);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public UserModel findAcc(String findEmail, String findPassword) {
		UserModel u;
		String query = String.format("SELECT * FROM %s WHERE Email = '%s' AND Password = '%s'", tableName, findEmail, findPassword);
		ResultSet rs = con.executeQuery(query);
		try {
			while (rs.next()) {
				Integer id = rs.getInt("UserID");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String phoneNum = rs.getString("PhoneNum");
					
				u = new UserModel();
				u.setId(id);
				u.setName(name);
				u.setEmail(email);
				u.setPhoneNum(phoneNum);
				u.setPassword(password);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phone_number) {
		this.phoneNum = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
