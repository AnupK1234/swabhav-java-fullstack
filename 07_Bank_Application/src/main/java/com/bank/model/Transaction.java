package com.bank.model;

import java.util.Date;

public class Transaction {
	private int id;
	private int userId;
	private int to_acc;
	private String type;
	private double amount;
	private Date date;

	public Transaction(int id, int userId, int to_acc, String type, double amount, Date date) {
		this.id = id;
		this.userId = userId;
		this.to_acc = to_acc;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTo_acc() {
		return to_acc;
	}

	public void setTo_acc(int to_acc) {
		this.to_acc = to_acc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}