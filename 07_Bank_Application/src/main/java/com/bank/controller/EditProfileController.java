package com.bank.controller;

import com.bank.misc.PasswordHasher;
import com.bank.model.User;
import com.bank.service.CustomerService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/editProfile")
public class EditProfileController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	private PasswordHasher hasher;

	@Override
	public void init() {
		customerService = new CustomerService();
		hasher = new PasswordHasher();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			if (password != null) {
				user.setPassword(password);
			}

			user.setName(name);
			user.setEmail(email);

			boolean updated = customerService.updateUser(user);

			if (updated) {
				session.setAttribute("user", customerService.getUserById(user.getId())); //
				// refresh session user
				resp.sendRedirect(req.getContextPath() + "/customer/dashboard");
			} else {
				req.setAttribute("error", "Update failed. Try again.");
				req.getRequestDispatcher("/views/editProfile.jsp").forward(req, resp);
			}
		} else {
			resp.sendRedirect("login.jsp");
		}
	}
}
