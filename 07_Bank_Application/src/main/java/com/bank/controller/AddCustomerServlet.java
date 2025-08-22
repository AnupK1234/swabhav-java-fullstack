package com.bank.controller;

import java.io.IOException;

import com.bank.model.User;
import com.bank.service.AdminService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create-customer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;

	public void init() {
		adminService = new AdminService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User newUser = new User();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setName(name);

		try {
			adminService.registerNewCustomer(newUser);
			request.getRequestDispatcher("/views/admin/dashboard.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}