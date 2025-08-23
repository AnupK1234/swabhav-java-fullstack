package com.bank.redirectController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bank.model.Transaction;
import com.bank.model.User;
import com.bank.service.TransactionService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customer/*")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionService transactionService;

	public void init() {
		transactionService = new TransactionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo(); // e.g., "/"
		HttpSession session = req.getSession();

		if (path == null || path.equals("/")) {
			// default admin dashboard
			req.getRequestDispatcher("/views/customer/dashboard.jsp").forward(req, resp);
		} else if (path.equals("/viewPassbook")) {

			User userObj = (User) session.getAttribute("user");
			List<Transaction> userTransactions = null;
			try {
				userTransactions = transactionService.getUserTransactions(userObj.getAccountNumber());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			session.setAttribute("userTransactions", userTransactions);
			req.getRequestDispatcher("/views/customer/passbook.jsp").forward(req, resp);
		} else if (path.equals("/newTransaction")) {
			req.getRequestDispatcher("/views/customer/new-transaction.jsp").forward(req, resp);
		} else if (path.equals("/editProfile")) {
			req.getRequestDispatcher("/views/customer/edit-profile.jsp").forward(req, resp);
		} else if (path.equals("/viewPassbook")) {
			req.getRequestDispatcher("/views/customer/passbook.jsp").forward(req, resp);
		} else if (path.equals("/dashboard")) {
			req.getRequestDispatcher("/views/customer/dashboard.jsp").forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Page Not Found");
		}
	}
}
