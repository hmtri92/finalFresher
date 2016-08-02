package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.TransactionHistoryDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.StateResult;
import com.csc.entities.TransactionHistory;

@Repository
public class TransactionHistoryDAOImpl implements TransactionHistoryDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public StateResult addFundTransaction(String id, BigDecimal amount) {

		StateResult state = new StateResult();
		try {
			Account account = em.find(Account.class, id);
			State newState = em.find(State.class, State.NEW);
			
			TransactionHistory add = new TransactionHistory();
			add.setDate(new Date());
			add.setReceiveAccount(account);
			add.setSendAccount(account);
			add.setAmount(amount);
			add.setState(newState);
			add.setTypeTransaction(TransactionHistory.ADD_FUND);
			
			String content = "Add " + amount;
			add.setContent(content);
			em.persist(add);
			
			state.setState(true);
			state.setMessage("success");
			return state;
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Error");
			return state;
		}
	}

	
	@Override
	public StateResult saveTransfer(Account sendAccount, Account targetAccount, BigDecimal amount) {
		StateResult state = new StateResult();
		try {
			State newState = em.find(State.class, State.NEW);
			
			TransactionHistory transfer = new TransactionHistory();
			transfer.setDate(new Date());
			transfer.setReceiveAccount(targetAccount);
			transfer.setSendAccount(sendAccount);
			transfer.setAmount(amount);
			transfer.setState(newState);
			transfer.setTypeTransaction(TransactionHistory.TRANSFER);
			
			String content = "Tranfer from " + sendAccount.getId() + " to " + targetAccount.getId() + ": " + amount;
			transfer.setContent(content);
			em.persist(transfer);
			
			state.setState(true);
			state.setMessage("Success");
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Error");
		}
		return state;
	}

	@Override
	public StateResult withdrawTransaction(Account account, BigDecimal amount) {
		StateResult result = new StateResult();
		try {
			State newState = em.find(State.class, State.NEW);
			
			TransactionHistory withdraw = new TransactionHistory();
			withdraw.setDate(new Date());
			withdraw.setReceiveAccount(account);
			withdraw.setSendAccount(account);
			withdraw.setAmount(amount);
			withdraw.setState(newState);
			withdraw.setTypeTransaction(TransactionHistory.WITHDRAW);
			
			String content = "Withdraw " + amount;
			withdraw.setContent(content);
			em.persist(withdraw);
			
			
			result.setState(true);
			result.setMessage("Success");
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Error");
		}
		return result;
	}

	@Override
	public List<TransactionHistory> getNewTransaction() {
		String sql = "SELECT t FROM TransactionHistory t WHERE t.state.idState = :state";
		TypedQuery<TransactionHistory> query = em.createQuery(sql, TransactionHistory.class);
		query.setParameter("state", State.NEW);
		
		List<TransactionHistory> transactions = query.getResultList();
		return transactions;
	}

	@Override
	public TransactionHistory getTransaction(long idTransaction) {
		return em.find(TransactionHistory.class, idTransaction);
	}
	
	@Override
	public StateResult changeStateTransaction(TransactionHistory transaction, int idState) {
		StateResult result = new StateResult();
		State state = em.find(State.class, idState);
		try {
			transaction.setState(state);
			
			result.setState(true);
			result.setMessage("Success");
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Fail");
		}
		return result;
	}

}
