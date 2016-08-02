package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TransactionHistory;

public interface TransactionHistoryDAO {
	StateResult addFundTransaction(String id, BigDecimal amount);
	
	StateResult withdrawTransaction(Account account, BigDecimal amount);
	
	List<TransactionHistory> getNewTransaction();
	
	TransactionHistory getTransaction(long idTransaction);
	
	StateResult changeStateTransaction(TransactionHistory transaction, int idState);
	
	StateResult saveTransfer(Account sendAccount, Account targetAccount, BigDecimal amount);
}
