package com.csc.dao;

import java.util.Date;
import java.util.List;

import com.csc.entities.TransactionHistory;

public interface TransactionDAO {
	public List<TransactionHistory> getTransactionByUserId(String id, int state);

	public List<TransactionHistory> getTransactionByDateRange(String userID,
			Date dateFrom, Date dateTo, int state);
}

