package com.bank.service;

import com.bank.dao.UserDAO;
import com.bank.misc.PasswordHasher;
import com.bank.model.User;

public class CustomerService {
	private UserDAO userDAO = new UserDAO();
	private PasswordHasher passwordHasher = new PasswordHasher();

	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	public boolean updateUser(User user) {
		// Hash password before saving
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			user.setPassword(passwordHasher.hashPassword(user.getPassword()));
		}
		return userDAO.updateUser(user);
	}
}
