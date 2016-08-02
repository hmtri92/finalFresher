package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;

@Repository
public class FundDAOImpl implements FundDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Account getAccountById(String accountNumber) {
		Account account = em.find(Account.class, accountNumber);
		return account;
	}
	
	@Override
	public StateResult addFund(Account account, BigDecimal amount) {
		StateResult state = new StateResult();
		try {
			account.setAvailableAmount(account.getAvailableAmount().add(amount));
			
			state.setState(true);
			state.setMessage("Success");
		} catch (NullPointerException e) {
			// field availableAmount null
			account.setAvailableAmount(amount);
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Can't add fund");
		}
		return state;
	}
	
	@Override
	public StateResult transfer(Account sendAccount, Account targetAccount, BigDecimal amount) {
		StateResult state = new StateResult();
		
		BigDecimal money = new BigDecimal(0);
		try {
			money = sendAccount.getAvailableAmount().subtract(amount);
		} catch (NullPointerException e) {}
		
		// transfer money
		sendAccount.setAvailableAmount(money);
		try {
			money = targetAccount.getAvailableAmount().add(amount);
		} catch (NullPointerException e) {
			money = amount;
		}
		targetAccount.setAvailableAmount(money);
			
		state.setState(true);
		return state;
	}

	@Override
	public List<TargetAccount> getTargetAccount(String id) {
		try {
			String sql = "SELECT t FROM TargetAccount t WHERE t.accountOwner.id = :id";
			TypedQuery<TargetAccount> query = em.createQuery(sql, TargetAccount.class);
			query.setParameter("id", id);
			
			List<TargetAccount> targetAccounts = query.getResultList();
			
			return targetAccounts;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public StateResult withdraw(Account account, BigDecimal amount) {
		StateResult state = new StateResult();
		try {
			// if availableAmount - amount < 50000 return false;
			BigDecimal money = new BigDecimal(0);
			try {
				money = account.getAvailableAmount().subtract(amount);
			} catch (NullPointerException e) {}
		
			account.setAvailableAmount(money);
			
			state.setState(true);
			state.setMessage("Success");
			return state;
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Error");
			return state;
		}
	}

}
