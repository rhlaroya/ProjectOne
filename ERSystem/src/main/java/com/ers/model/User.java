package com.ers.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.DAO.DaoContract;
import com.ers.util.ConnectionUtil;

public class User implements DaoContract<User> {
	
	/**
	 * instance fields
	 */
	private int user_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private int role_id;
	
	/**
	 * Getters and Setters
	 */
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	/**
	 * No args constructor
	 */
	public User() {
		super();
	}
	
	/**
	 * Object constructor
	 * @param user_id
	 * @param username
	 * @param password
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param role_id
	 */
	public User(int user_id, String username, String password, String first_name, String last_name, String email,
			int role_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role_id = role_id;
	}
	
	/**
	 * User toString
	 */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", email=" + email + ", role_id=" + role_id + "]";
	}
	
	User usr = new User();
	
	public List<User> getList(){
		return usr.getAll();
	}
	
	@Override
	public List<User> getAll() {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select * from \"ers-users\" order by \"ers-users-id\" asc";
			List<User> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insert(User t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}
}
