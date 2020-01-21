package com.ers.model;

public class ReimbursementType {
	
	/**
	 * Instance fields
	 */
	private int type_id;
	private String type;
	
	/**
	 * Getters and Setters
	 */
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * No args constructor
	 */
	public ReimbursementType() {
		super();
	}
	
	/**
	 * Object constructor
	 * @param type_id
	 * @param type
	 */
	public ReimbursementType(int type_id, String type) {
		super();
		this.type_id = type_id;
		this.type = type;
	}
	
	/**
	 * ReimbursementType toString
	 */
	@Override
	public String toString() {
		return "ReimbursementType [type_id=" + type_id + ", type=" + type + "]";
	}
	
	
	
	
	
	
	
	
	
}
