package com.bank.controller;

import java.io.IOException;

import com.bank.dao.UserDAO;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if ("login".equals(action)) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			try {
				User user = userDAO.getUserByUsername(username);
				if (user != null && user.getPassword().equals(password)) {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					if ("ADMIN".equals(user.getRole())) {
						resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
					} else {
						resp.sendRedirect("customer?dashboard");
					}
				} else {
					req.setAttribute("error", "Invalid Credentials");
					req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else if ("logout".equals(action)) {
			HttpSession session = req.getSession(false);
			if (session != null)
				session.invalidate();
			resp.sendRedirect("login");
		}
	}
}
