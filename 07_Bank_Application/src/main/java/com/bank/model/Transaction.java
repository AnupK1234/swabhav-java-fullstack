package com.bank.model;

import java.util.Date;

public class Transaction {
	private int id;
	private long from_account;
	private long to_account;
	private String type;
	private double amount;
	private Date date;

	public Transaction(int id, long from_account, long to_account, String type, double amount, Date date) {
		super();
		this.id = id;
		this.from_account = from_account;
		this.to_account = to_account;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	// for transfer
	public Transaction(long from_account, long to_account, String type, double amount) {
		super();
		this.from_account = from_account;
		this.type = type;
		this.amount = amount;
		this.to_account = to_account;
	}

	// for credit
	public Transaction(long from_account, String type, double amount) {
		super();
		this.from_account = from_account;
		this.type = type;
		this.amount = amount;
	}

	public Transaction() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getFrom_account() {
		return from_account;
	}

	public void setFrom_account(long from_account) {
		this.from_account = from_account;
	}

	public long getTo_account() {
		return to_account;
	}

	public void setTo_account(long to_account) {
		this.to_account = to_account;
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

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", from_account=" + from_account + ", to_account=" + to_account + ", type="
				+ type + ", amount=" + amount + ", date=" + date + "]";
	}

}