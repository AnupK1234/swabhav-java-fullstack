package com.bank.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String role;
	private String name;
	private String email;
	private long accountNumber;
	private double balance;

	public User(int id, String username, String password, String role, String name, String email, long accountNumber,
			double balance) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.email = email;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}