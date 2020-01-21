package com.ers.model;

public class UserRole {
	
	/**
	 * Instance fields
	 */
	private int role_id;
	private String user_role;
	
	/**
	 * Getters and Setters
	 */
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
	/**
	 * No args constructor
	 */
	public UserRole() {
		super();
	}
	
	/**
	 * Object constructor
	 * @param role_id
	 * @param user_role
	 */
	public UserRole(int role_id, String user_role) {
		super();
		this.role_id = role_id;
		this.user_role = user_role;
	}
	
	/**
	 * UserRole toString
	 */
	@Override
	public String toString() {
		return "UserRole [role_id=" + role_id + ", user_role=" + user_role + "]";
	}
	
	
	
}
