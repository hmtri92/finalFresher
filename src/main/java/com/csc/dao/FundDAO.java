package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;

public interface FundDAO {
	StateResult addFund(Account account, BigDecimal amount);
	
	Account getAccountById(String accountNumber);
	
	StateResult transfer(Account sendAccount, Account targetAccount, BigDecimal amount);
	
	List<TargetAccount> getTargetAccount(String id);
	
	StateResult withdraw(Account account, BigDecimal amount);
	
}
