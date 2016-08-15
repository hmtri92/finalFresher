package com.csc.service.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.csc.bean.AdminReponse;
import com.csc.dao.AccountDAO;
import com.csc.dao.TransactionHistoryDAO;
import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.entities.TransactionHistory;
import com.csc.service.FundService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/test-context.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class FundServiceImplTest {
	
	@Autowired
	FundService fundService;
	
	@Autowired
	TransactionHistoryDAO transactionDao;
	
	@Autowired
	AccountDAO accountDao;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddFund() {
		StateResult result = fundService.addFund("123456789001", BigDecimal.valueOf(10000));
		assertEquals(result.getState(), true);
	}

	@Test
	public void testTransfer() {
		BigDecimal amount = BigDecimal.valueOf(10000);
		StateResult result = new StateResult();
		
		// Test account null
		result = fundService.transfer("", "123456789001", amount);
		assertEquals(result.getState(), false);
		
		// State Account not Active
		result = fundService.transfer("123456789002", "123456789001", amount);
		assertEquals(result.getMessage(), "Account is not ACTIVE");
		
		// Enough money
		result = fundService.transfer("123456789001", "123456789002", BigDecimal.valueOf(1000000000));
		assertEquals(result.getMessage(), "The amount in the account is not enough to transfer");
		
		// Success
		result = fundService.transfer("123456789001", "123456789002", amount);
		assertEquals(result.getMessage(), "Success");
		
	}

	@Test
	public void testTransferTargetID() {
		BigDecimal amount = BigDecimal.valueOf(10000);
		
		// Test account null
		StateResult result = fundService.transferTargetID("", "1", amount);
		assertEquals(result.getState(), false);
		
		// State Account not Active
		result = fundService.transferTargetID("123456789002", "1", amount);
		assertEquals(result.getMessage(), "Account is not ACTIVE");
		
		// Enough money
		result = fundService.transferTargetID("123456789001", "1", BigDecimal.valueOf(1000000000));
		assertEquals(result.getMessage(), "The amount in the account is not enough to transfer");
		
		// Success
		result = fundService.transferTargetID("123456789001", "1", amount);
		assertEquals(result.getMessage(), "Success");
	}

	@Test
	public void testWithdraw() {
		BigDecimal amount = BigDecimal.valueOf(10000);
		
		// Test account null
		StateResult result = fundService.withdraw("", amount);
		assertEquals(result.getState(), false);
		
		// State Account not Active
		result = fundService.withdraw("123456789002", amount);
		assertEquals(result.getMessage(), "Account is not ACTIVE");
		
		// Enough money
		result = fundService.withdraw("123456789001", BigDecimal.valueOf(1000000000));
		assertEquals(result.getMessage(), "The amount in the account is not enough to transfer");
		
		// Success
		result = fundService.withdraw("123456789001", amount);
		assertEquals(result.getMessage(), "Success");
	}

	@Test
	public void testGetNewTransaction() {
		List<TransactionHistory> lstTransaction = fundService.getNewTransaction();
		
		// Data in createDB
		int dem = 1;
		for (TransactionHistory tran : lstTransaction) {
			assertEquals(dem++, tran.getIdTransaction());
		}
	}

	@Test
	public void testVerifyTransaction() {
		TransactionHistory transactionHistory = null;
		StateResult result = null;
		//Add
		transactionHistory = transactionDao.getTransaction(1);
		BigDecimal money = transactionHistory.getSendAccount().getAvailableAmount().add(transactionHistory.getAmount());
		
		result = fundService.verifyTransaction(1);
		assertEquals(transactionHistory.getState().getIdState(), 2);
		Account acc = accountDao.getAccountById(transactionHistory.getSendAccount().getId());
		assertEquals(money, acc.getAvailableAmount());
		assertEquals(result.getState(), true);
		
		//withdraw
		transactionHistory = transactionDao.getTransaction(3);
		money = transactionHistory.getSendAccount().getAvailableAmount().subtract(transactionHistory.getAmount());
		
		result = fundService.verifyTransaction(3);
		assertEquals(transactionHistory.getState().getIdState(), 2);
		acc = accountDao.getAccountById(transactionHistory.getSendAccount().getId());
		assertEquals(money, acc.getAvailableAmount());
		assertEquals(result.getState(), true);
		
		//transfer
		transactionHistory = transactionDao.getTransaction(2);
		money = transactionHistory.getSendAccount().getAvailableAmount().subtract(transactionHistory.getAmount());
		BigDecimal moneyTarget = transactionHistory.getReceiveAccount()
				.getAvailableAmount().add(transactionHistory.getAmount());
		
		result = fundService.verifyTransaction(2);
		assertEquals(transactionHistory.getState().getIdState(), 2);
		acc = accountDao.getAccountById(transactionHistory.getSendAccount().getId());
		Account accTarget = accountDao.getAccountById(transactionHistory.getReceiveAccount().getId());
		assertEquals(moneyTarget, accTarget.getAvailableAmount());
		assertEquals(result.getState(), true);
	}
	
	@Test
	public void testGetListTargetByAccountOwnerId() {
		//Null list target
		List<TargetAccount> target = fundService.getListTargetByAccountOwnerId("");
		assertEquals(target.size(), 0);
		
		// Null list target
		target = fundService.getListTargetByAccountOwnerId("123456789001");
		assertEquals(target.size(), 2);
		
	}
	
	@Test
	public void testAddTargetAccount() {
		StateResult result = null;
		result = fundService.addTargetAccount("123456789002", "00000000000", "pug");
		assertEquals(result.getMessage(), "Account not fund!");
		
		result = fundService.addTargetAccount("123456789002", "012345678901", "pug");
		assertEquals(result.getMessage(), "Success");
	}
	
	@Test
	public void testModifyTarget() {
		// null id target
		StateResult result = null;
		result = fundService.modifyTarget("00000000000", "012345678902", "Minh Tri");
		assertEquals(result.getMessage(), "Error");
		
		// Account not found
		result = fundService.modifyTarget("1", "00000000000", "Minh Tri");
		assertEquals(result.getMessage(), "Account not found!");
		
		// Success
		result = fundService.modifyTarget("1", "012345678903", "Minh Tri");
		assertEquals(result.getMessage(), "Success");
	}

	@Test
	public void testDeleteTarget() {
		// Null target
		StateResult result = fundService.deleteTarget("0");
		assertEquals(result.getMessage(), "Fail");
		
		// Success
		result = fundService.deleteTarget("1");
		assertEquals(result.getMessage(), "Success");
		
	}

	@Test
	public void testIgnoreTransaction() {
		StateResult result = null;
		
		// null id transaction
		result = fundService.ignoreTransaction(0);
		assertEquals(result.getMessage(), "Error. Transaction not found!");
		
		// Success
		result = fundService.ignoreTransaction(1);
		assertEquals(result.getMessage(), "Success");
	}
	
	@Test
	public void testGetHomeAdminInfo() {
		AdminReponse result = fundService.getHomeAdminInfo();
		assertEquals(result.getCountverifyTransaction(), 3);
		assertEquals(result.getCountChangeStateNewToActive(), 0);
		assertEquals(result.getCountChangeStateDisableToRemove(), 1);
	}
}