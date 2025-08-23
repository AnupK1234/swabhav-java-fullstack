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
		String sql = "SELECT * FROM transactions WHERE from_account = ? ORDER BY date DESC";
		try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setLong(1, userAccNum);
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
}
