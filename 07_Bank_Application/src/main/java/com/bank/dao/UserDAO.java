package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.User;

public class UserDAO {

	public User getUserByUsername(String username) throws SQLException {
		String sql = "SELECT * FROM users WHERE username=?";
		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return mapUser(rs);
			}
		}
		return null;
	}

	public void addCustomer(User user) throws SQLException {
		String sql = "INSERT INTO users(username,password,role,name,email,account_number,balance) VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, "CUSTOMER");
			stmt.setString(4, user.getName());
			stmt.setString(5, user.getEmail());
			stmt.setLong(6, user.getAccountNumber());
			stmt.setDouble(7, user.getBalance());
			stmt.executeUpdate();
		}
	}

	public List<User> getAllCustomers() throws SQLException {
		List<User> customers = new ArrayList<>();
		String sql = "SELECT * FROM users WHERE role='CUSTOMER'";
		try (Connection conn = DbUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				customers.add(mapUser(rs));
			}
		}
		return customers;
	}

	private User mapUser(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setRole(rs.getString("role"));
		u.setName(rs.getString("name"));
		u.setEmail(rs.getString("email"));
		u.setAccountNumber(rs.getLong("account_number"));
		u.setBalance(rs.getDouble("balance"));
		return u;
	}
}