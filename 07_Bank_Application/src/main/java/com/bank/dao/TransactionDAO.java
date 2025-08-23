package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Transaction;

public class TransactionDAO {

	public List<Transaction> getTransactionsByUserId(long userAccNum) throws SQLException {
		List<Transaction> list = new ArrayList<>();
		String sql = "SELECT * FROM transactions WHERE from_account = ? OR to_account= ? ORDER BY date DESC";
		try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setLong(1, userAccNum);
			ps.setLong(2, userAccNum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction txn = new Transaction();
				txn.setId(rs.getInt("id"));
				txn.setTo_account(rs.getLong("to_account"));
				txn.setFrom_account(rs.getLong("from_account"));
				txn.setType(rs.getString("type"));
				txn.setAmount(rs.getDouble("amount"));
				txn.setDate(rs.getTimestamp("date"));
				list.add(txn);
			}
		}
		return list;
	}

	public void saveTransaction(Transaction txn) {
		String txnSql;
		String creditSql = "UPDATE users SET balance = balance + ? WHERE account_number = ?";
		String debitSql = "UPDATE users SET balance = balance - ? WHERE account_number = ?";
		String checkBalanceSql = "SELECT balance FROM users WHERE account_number = ?";

		if (txn.getTo_account() != 0) { // TRANSFER
			txnSql = "INSERT INTO transactions (to_account, from_account, type, amount) VALUES (?, ?, ?, ?)";
		} else { // CREDIT
			txnSql = "INSERT INTO transactions (from_account, type, amount) VALUES (?, ?, ?)";
		}

		Connection conn = null; // Declare outside so it can be used in catch block
		try {
			conn = DbUtil.getConnection();
			conn.setAutoCommit(false); // start transaction

			// 1. Check balance before transfer
			if (txn.getType().equals("TRANSFER")) {
				try (PreparedStatement ps = conn.prepareStatement(checkBalanceSql)) {
					ps.setLong(1, txn.getFrom_account());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						double balance = rs.getDouble("balance");
						if (balance < txn.getAmount()) {
							throw new RuntimeException("Insufficient balance for transfer!");
						}
					} else {
						throw new RuntimeException("Sender account not found!");
					}
				}
			}

			// 2. Save transaction
			try (PreparedStatement ps = conn.prepareStatement(txnSql)) {
				if (txn.getTo_account() != 0) {
					ps.setLong(1, txn.getTo_account());
					ps.setLong(2, txn.getFrom_account());
					ps.setString(3, txn.getType());
					ps.setDouble(4, txn.getAmount());
				} else {
					ps.setLong(1, txn.getFrom_account());
					ps.setString(2, txn.getType());
					ps.setDouble(3, txn.getAmount());
				}
				ps.executeUpdate();
			}

			// 3. Update balances
			if (txn.getType().equals("CREDIT")) {
				try (PreparedStatement ps = conn.prepareStatement(creditSql)) {
					ps.setDouble(1, txn.getAmount());
					ps.setLong(2, txn.getFrom_account());
					ps.executeUpdate();
				}
			} else if (txn.getType().equals("TRANSFER")) {
				try (PreparedStatement ps = conn.prepareStatement(debitSql)) {
					ps.setDouble(1, txn.getAmount());
					ps.setLong(2, txn.getFrom_account());
					ps.executeUpdate();
				}

				try (PreparedStatement ps = conn.prepareStatement(creditSql)) {
					ps.setDouble(1, txn.getAmount());
					ps.setLong(2, txn.getTo_account());
					ps.executeUpdate();
				}
			}

			conn.commit(); // success
		} catch (Exception e) {
			e.printStackTrace();
			if (conn != null) { // rollback only if connection is valid
				try {
					conn.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			if (conn != null) { // close connection manually now
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
