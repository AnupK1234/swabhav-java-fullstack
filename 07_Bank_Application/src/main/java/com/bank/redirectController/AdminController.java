package com.bank.redirectController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bank.model.Transaction;
import com.bank.model.User;
import com.bank.service.AdminService;
import com.bank.service.TransactionService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private TransactionService transactionService;

	public void init() {
		adminService = new AdminService();
		transactionService = new TransactionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo(); // e.g., "/addcustomer"

		if (path == null || path.equals("/")) {
			// default admin dashboard
			req.getRequestDispatcher("/views/admin-dashboard.jsp").forward(req, resp);
		}

		else if (path.equals("/addCustomer")) {
			// forward to add-customer page
			req.getRequestDispatcher("/views/admin/add-customer.jsp").forward(req, resp);
		}

		else if (path.equals("/viewCustomers")) {
			List<User> customers = adminService.getAllCustomers();

			// Set customers in request scope
			req.setAttribute("customers", customers);

			// Forward to JSP page with table
			req.getRequestDispatcher("/views/admin/view-customers.jsp").forward(req, resp);

		} else if (path.equals("/viewTransactions")) {
			try {
				List<Transaction> allTransactions = transactionService.getAllTransactions();

				req.setAttribute("allTransaction", allTransactions);
				req.getRequestDispatcher("/views/admin/view-transactions.jsp").forward(req, resp);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (path.equals("/dashboard")) {
			req.getRequestDispatcher("/views/admin/dashboard.jsp").forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Page Not Found");
		}
	}
}
