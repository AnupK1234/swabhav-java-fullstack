package com.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;
import com.bank.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TransactionService {
	private TransactionDAO transactionDAO = new TransactionDAO();

	public List<Transaction> getUserTransactions(long userAccNum) throws SQLException {
		return transactionDAO.getTransactionsByUserId(userAccNum);
	}

	public void createTransaction(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User userObj = (User) session.getAttribute("user");
		Transaction txn;
		String type = req.getParameter("type");
		long toAccount = 0;
		long amount = Long.parseLong(req.getParameter("amount"));
		long fromAccount = userObj.getAccountNumber();

		if (type.equals("TRANSFER")) {
			toAccount = Long.parseLong(req.getParameter("toAcc"));
			txn = new Transaction(fromAccount, toAccount, type, amount);
		} else {
			txn = new Transaction(fromAccount, type, amount);
		}

		try {
			transactionDAO.saveTransaction(txn);
			res.sendRedirect(req.getContextPath() + "/customer/dashboard");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
