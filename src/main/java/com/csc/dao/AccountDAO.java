package com.csc.dao;

import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.User;

public interface AccountDAO {
	boolean addAccount(Account account, int idRole, int idType);

	public Account getAccountById(String id);

	public Account updateStateAccountById(String id, int state);

	public Account updateAccount(String id, int idstate, int idRole,
			String firtname, String lastname, String midname, int idType,
			String email1, String email2, String address1, String address2,
			String phoneNumber1, String phoneNumber2, String idcardNumber);

	public List<Account> getStateRemvo();

	public List<Account> getStateNew();

	public List<Account> getStateDis();

	public List<String> getRecomendedKeyList(int searchType);

	public List<User> getAllUser();

	public boolean checkLoginid(String LoginId);

	public boolean addUser(User user, int idRole, int idType);

	public List<Account> getStateActive();

	List<Account> searchAccountByAccountNumber(String key);

	List<Account> searchAccountByIdCardNumber(String key);

	List<Account> searchAccountByOwnerName(String key);

	List<Account> searchAccountByType(String key);

	List<Account> searchAccountByState(String key);

	List<Account> searchAccountByPhone(String key);

	List<Account> searchAccountByAddress(String key);

	List<Account> searchAccountByEmail(String key);

}
