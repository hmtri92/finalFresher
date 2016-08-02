package com.csc.service;

import java.util.List;

import com.csc.entities.BalanceAmount;
import com.csc.entities.TransactionHistory;
import com.csc.entities.User;

public interface UserService {
	
	public User getUserInfo(String customerId);

	public String changePassword(String id, String oldPassword,
			String newPassword);

	public String editUserInfo(String id, String firstName, String midName,
			String lastName, String address2, String phone2, String email2);
	/*
	 * MinhTri
	 */
	User getUserByLoginId (String loginId);
	
	User getUserByID(String id);

	public List<TransactionHistory> getTransactionByUserId(String Id, int state);

	public List<BalanceAmount> getBalanceLogByUserId(String accounNumber);

	public List<TransactionHistory> getTransactionByDateRange(String userID,
			String stringDateFrom, String stringDateTo, int state);

	public List<BalanceAmount> getBalanceByDateRange(String userID,
			String stringDateFrom, String stringDateTo);
	
	public boolean editUserprofile(User user);

}
