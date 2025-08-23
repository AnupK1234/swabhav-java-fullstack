package com.bank.controller;

import java.io.IOException;
import java.util.List;

import com.bank.model.Transaction;
import com.bank.model.User;
import com.bank.service.TransactionService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transaction")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionService transactionService = new TransactionService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			if ("create".equals(action)) {
				transactionService.createTransaction(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/views/new-transaction.jsp").forward(request, response);
	}

}
