package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import struqt.util.UniqueIdGenerator;

import com.bank.misc.PasswordHasher;
import com.bank.model.User;

public class UserDAO {
	UniqueIdGenerator generator = new UniqueIdGenerator(1L);
	PasswordHasher hasher = new PasswordHasher();

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

		String sql = "INSERT INTO users(username,password,name,email, account_number) VALUES(?,?,?,?,?)";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, hasher.hashPassword(user.getPassword()));
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getEmail());
			stmt.setLong(5, generator.next());
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
		u.setName(rs.getString("name"));
		u.setEmail(rs.getString("email"));
		u.setAccountNumber(rs.getLong("account_number"));
		// u.setAccountNumber(1234567890);
		u.setPassword(rs.getString("password"));
		u.setBalance(rs.getDouble("balance"));
		u.setRole(rs.getString("role"));
		return u;
	}
}