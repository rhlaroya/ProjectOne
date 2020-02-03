package com.ers.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reimbursement {
	
	/**
	 * Instance fields
	 */
	private int id;
	private int amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private byte receipt;
	private int author;
	private String authorText;
	private int resolver;
	private String resolverText;
	private int status_id;
	private String status;
	private int type_id;
	private String type;
	
	public String getAuthorText() {
		return authorText;
	}
	public void setAuthorText(String authorText) {
		this.authorText = authorText;
	}
	public String getResolverText() {
		return resolverText;
	}
	public void setResolverText(String resolverText) {
		this.resolverText = resolverText;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm")
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm")
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte getReceipt() {
		return receipt;
	}
	public void setReceipt(byte receipt) {
		this.receipt = receipt;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	
	/**
	 * No-args constructor
	 */
	public Reimbursement() {
		super();
	}
	
	/**
	 * Object constructor
	 * @param id
	 * @param amount
	 * @param submitted
	 * @param resolved
	 * @param description
	 * @param receipt
	 * @param author
	 * @param resolver
	 * @param status_id
	 * @param type_id
	 */
	public Reimbursement(int id, int amount, Timestamp submitted, Timestamp resolved, String description, byte receipt,
			int author, int resolver, int status_id, int type_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status_id = status_id;
		this.type_id = type_id;
	}
	
	public Reimbursement(int id, int amount, Timestamp submitted, Timestamp resolved, String description, 
			String authorText, String resolverText, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.authorText = authorText;
		this.resolverText = resolverText;
		this.status = status;
		this.type = type;
	}
	
	public Reimbursement(int amount, Timestamp submitted, String description, 
			int author, int status_id, int type_id) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.status_id = status_id;
		this.type_id = type_id;
	}
	
	public Reimbursement(Timestamp resolved, int resolver, int status, int id) {
		this.id = id;
		this.resolved = resolved;
		this.resolver = resolver;
		this.status_id = status;
	}
	
	/**
	 * Reimbursement toString
	 */
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", status_id=" + status_id + ", type_id=" + type_id + "]";
	}
}
