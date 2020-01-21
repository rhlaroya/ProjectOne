package com.ers.model;

public class ReimbursementStatus {
	
	/**
	 * Instance fields
	 */
	private int status_id;
	private String status;
	
	/**
	 * Getters and Setters
	 */
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * No-args constructor
	 */
	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Object constructor
	 * @param status_id
	 * @param status
	 */
	public ReimbursementStatus(int status_id, String status) {
		super();
		this.status_id = status_id;
		this.status = status;
	}
	
	/**
	 * ReimbursementStatus toString
	 */
	@Override
	public String toString() {
		return "ReimbursementStatus [status_id=" + status_id + ", status=" + status + "]";
	}
	
	
}
