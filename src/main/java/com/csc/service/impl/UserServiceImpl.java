package com.csc.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csc.dao.BalanceDAO;
import com.csc.dao.TransactionDAO;
import com.csc.dao.UserDAO;
import com.csc.entities.BalanceAmount;
import com.csc.entities.TransactionHistory;
import com.csc.entities.User;
import com.csc.service.UserService;
import com.csc.ultil.PasswordUtils;

@Service
@SessionAttributes({ "customer", "role", "id" })
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	TransactionDAO transactionDAO;
	
	@Autowired
	BalanceDAO balanceDAO;

	@Override
	public User getUserInfo(String userId) {
		User user = null;
		
		user = userDao.getUserByID(userId);
		
		return user;
	}

	@Override	
	public String changePassword(String id, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		User user = userDao.getUserByID(id);
		
		if (!PasswordUtils.matchPassword(oldPassword, user.getPassword())) {		
			return "FAIL: The current password is incorrect!";
		}
		
		if (newPassword.length() < 8 || newPassword.indexOf(' ') != -1){
			return "FAIL: The new password is incorrect!";
		}
		
		user.setPassword(PasswordUtils.encodePassword(newPassword));
		
		boolean result = userDao.changeInfo(user);
		
		if (result) {
			return "SUCCESS: The password is changed successfully!";
		}
		return "FAIL: Error while processing request...";
	}

	@Override
	public String editUserInfo(String id, String firstName, String midName,
			String lastName, String address2, String phone2, String email2) {
		
		
		if (firstName == null || firstName == "") {
			return "FAIL: The first name is incorrect!";
		}
		if (lastName == null || lastName == "") {
			return "FAIL: The last name is incorrect!";
		}
		
		User user = userDao.getUserByID(id);
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMidName(midName);
		user.setAddress2(address2);
		user.setPhoneNum2(phone2);
		user.setEmail2(email2);
		
		boolean result = userDao.changeInfo(user);
		
		if (result) {
			return "SUCCESS: The information is updated successfully!";
		}
		return "FAIL: Error while processing request...";
	}

	/*
	 * Minh Tri
	 * @see com.csc.service.UserService#getUserByLoginId(java.lang.String)
	 */
	@Override
	public User getUserByLoginId(String loginId) {
		return userDao.getUserByLoginID(loginId);
	}

	@Override
	public User getUserByID(String id) {
		return userDao.getUserByID(id);
	}

	@Override
	public List<TransactionHistory> getTransactionByUserId(String id, int state) {
		// TODO Auto-generated method stub
		List<TransactionHistory> result = null;
		
		result = transactionDAO.getTransactionByUserId(id, state);
		
		return result;
	}

	@Override
	public List<BalanceAmount> getBalanceLogByUserId(String accountNumber) {
		// TODO Auto-generated method stub
		List<BalanceAmount> result = null;
		
		result = balanceDAO.getBalanceLogByUserId(accountNumber);
		
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<TransactionHistory> getTransactionByDateRange(String userID,
			String stringDateFrom, String stringDateTo, int state) {
		// TODO Auto-generated method stub
		
		Date dateFrom = toDate(stringDateFrom);
		Date dateTo = toDate(stringDateTo);		
		
		dateTo.setDate(dateTo.getDate() + 1);		
		
		return transactionDAO.getTransactionByDateRange(userID, dateFrom, dateTo, state);
		
	}

	@Override
	public List<BalanceAmount> getBalanceByDateRange(String userID,
			String stringDateFrom, String stringDateTo) {
		// TODO Auto-generated method stub
		
		
		Date dateFrom = toDate(stringDateFrom);
		Date dateTo = toDate(stringDateTo);		
		
		dateTo.setDate(dateTo.getDate() + 1);	
		
		return balanceDAO.getBalanceByDateRange(userID, dateFrom, dateTo);
	}
	
	private Date toDate(String stringDate){
		DateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
		Date result = null;
		
		try {
			result = format.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean editUserprofile(User user) {
		return userDao.changeInfo(user);
	}

}
