package com.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;

public class TransactionService {
	private TransactionDAO transactionDAO = new TransactionDAO();

	public List<Transaction> getUserTransactions(long userAccNum) throws SQLException {
		return transactionDAO.getTransactionsByUserId(userAccNum);
	}
}
