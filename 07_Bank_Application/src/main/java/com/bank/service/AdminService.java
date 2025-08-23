package com.bank.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.UserDAO;
import com.bank.model.User;

public class AdminService {
	private UserDAO userDAO = new UserDAO();

	public void registerNewCustomer(User user) throws SQLException {
		// Business logic goes here (e.g., validation, password hashing, etc.)
		// user.setPassword(hash(user.getPassword()));
		try {
			// Now, call the DAO to save the data
			userDAO.addCustomer(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllCustomers() {
		try {
			List<User> customerList = userDAO.getAllCustomers();
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
