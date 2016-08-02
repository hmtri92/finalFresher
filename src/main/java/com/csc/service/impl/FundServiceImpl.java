package com.csc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.bean.AdminReponse;
import com.csc.dao.AccountDAO;
import com.csc.dao.AdminInfoDAO;
import com.csc.dao.FundDAO;
import com.csc.dao.ITargetAccountDAO;
import com.csc.dao.TransactionHistoryDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.entities.TransactionHistory;
import com.csc.service.FundService;

/*
 * Minh Tri
 */
@Service
public class FundServiceImpl implements FundService {

	@Autowired
	FundDAO fundDao;
	
	@Autowired
	TransactionHistoryDAO transactionDao;
	
	@Autowired
	ITargetAccountDAO targetAccountDao;
	
	@Autowired
	AccountDAO accountDao;
	
	@Autowired
	AdminInfoDAO adminInfoDao;
	
	@Override
	@Transactional
	public StateResult addFund(String id, BigDecimal amount) {
		return transactionDao.addFundTransaction(id, amount);
	}

	/*
	 * 
	 * @see com.csc.service.FundService#transfer(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public StateResult transfer(String sendAccount_ID, String targetAccount_ID, BigDecimal amount) {
		StateResult result = new StateResult();
		Account sendAccount = accountDao.getAccountById(sendAccount_ID);
		Account targetAccount = accountDao.getAccountById(targetAccount_ID);
				
		if (targetAccount == null || sendAccount == null) {
			result.setState(false);
			result.setMessage("Account not found!");
			return result;
		}
		
		StateResult state = checkAccountSource(sendAccount, amount);
		if (!state.getState()) {
			return state;
		}
		
		return transactionDao.saveTransfer(sendAccount, targetAccount, amount);
	}

	@Override
	@Transactional
	public StateResult transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		
		Account sendAccount = accountDao.getAccountById(sendAccount_ID);
		
		StateResult state = checkAccountSource(sendAccount, amount);
		if (!state.getState()) {
			return state;
		}
		
		TargetAccount target = targetAccountDao.getTargetAccountById(targetAccount_ID);
		Account targetAccount = target.getAccountTarget();
		
		return transactionDao.saveTransfer(sendAccount, targetAccount, amount);
	}

	@Override
	@Transactional
	public StateResult withdraw(String account_id, BigDecimal amount) {
		
		Account account = accountDao.getAccountById(account_id);
		
		StateResult state = checkAccountSource(account, amount);
		if (!state.getState()) {
			return state;
		}
		
		return transactionDao.withdrawTransaction(account, amount);
	}

	@Override
	@Transactional
	public List<TransactionHistory> getNewTransaction() {
		return transactionDao.getNewTransaction();
	}

	@Override
	@Transactional
	public StateResult verifyTransaction(long idTransaction) {
		StateResult result = new StateResult(true, "Success");
		
		
		try {
			TransactionHistory transaction = transactionDao.getTransaction(idTransaction);
			
			
			if (transaction.getTypeTransaction() == TransactionHistory.ADD_FUND)
			{
				result = fundDao.addFund(transaction.getSendAccount(), transaction.getAmount());
			} else if (transaction.getTypeTransaction() == TransactionHistory.TRANSFER) {
				result = checkAccountSource(transaction.getSendAccount(), transaction.getAmount());
				if (!result.getState()) {
					return result;
				}
				
				result = fundDao.transfer(transaction.getSendAccount(), 
						transaction.getReceiveAccount(), transaction.getAmount());
			} else {
				result = checkAccountSource(transaction.getSendAccount(), transaction.getAmount());
				if (!result.getState()) {
					return result;
				}
				
				result = fundDao.withdraw(transaction.getSendAccount(), transaction.getAmount());
			}
			
			if (result.getState()) {
				result = transactionDao.changeStateTransaction(transaction, State.ACTIVE);
			}
		} catch(NullPointerException e) {
			result.setState(false);
			result.setMessage("Transaction not found!");
		}
		
		
		return result;
	}

	@Override
	public List<TargetAccount> getListTargetByAccountOwnerId(String id) {
		return targetAccountDao.getListTargetByAccountOwnerId(id);
	}

	@Override
	@Transactional
	public StateResult addTargetAccount(String idAccountOwner,
			String idAccountTarget, String name) {
		StateResult result = new StateResult();
		
		Account accountOwner = accountDao.getAccountById(idAccountOwner);
		Account accountTarget = accountDao.getAccountById(idAccountTarget);
		if (accountTarget == null || accountOwner == null) {
			result.setState(false);
			result.setMessage("Account not fund!");
			return result;
		}
		
		return targetAccountDao.addTargetAccount(idAccountOwner, idAccountTarget, name);
	}

	@Override
	@Transactional
	public StateResult modifyTarget(String id, String idAccountTarget,
			String name) {
		StateResult result = new StateResult();
		
		Account account = accountDao.getAccountById(idAccountTarget);
		if (account == null) {
			result.setState(false);
			result.setMessage("Account not found!");
			return result;
		}
		
		return targetAccountDao.modifyTarget(id, idAccountTarget, name);
	}

	@Override
	@Transactional
	public StateResult deleteTarget(String id) {
		return targetAccountDao.deleteTarget(id);
	}

	@Override
	@Transactional
	public StateResult ignoreTransaction(long idTransaction) {
		TransactionHistory tran = transactionDao.getTransaction(idTransaction);
		if (tran == null) {
			StateResult result = new StateResult(false, "Error. Transaction not found!");
			return result;
		} else {
			return transactionDao.changeStateTransaction(tran, State.DISABLE);
		}
	}

	@Override
	@Transactional
	public AdminReponse getHomeAdminInfo() {
		AdminReponse result = new AdminReponse();
		
		result.setCountverifyTransaction(adminInfoDao.getCountVerifyTransaction());
		result.setCountChangeStateNewToActive(adminInfoDao.getCountAccountNew());
		result.setCountChangeStateDisableToRemove(adminInfoDao.getCountAccountDisable());
		
		return result;
	}
	
	private StateResult checkAccountSource(Account account, BigDecimal amount) {
		StateResult result = new StateResult();
		
		// if availableAmount - sendAmount < 50000 return false;
		try {
			BigDecimal money = account.getAvailableAmount().subtract(amount);
			if (money.compareTo(BigDecimal.valueOf(50000)) < 0) {
				result.setState(false);
				result.setMessage("The amount in the account is not enough to transfer");
				return result;
			}
			
			// Check state sendAccount
			if (account.getState().getIdState() != State.ACTIVE) {
				result.setState(false);
				result.setMessage("Account is not ACTIVE");
				return result;
			}
		} catch (NullPointerException e) {
			result.setMessage("Account not found!");
			return result;
		}
		
		result.setState(true);
		return result;
	}

}
