package com.csc.service;

import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.User;

public interface AccountService {
	public abstract Boolean addAccount(Account account, int idRole, int idType);

	Account getAccountById(String id);

	public Account updateStateAccountById(String id, int state);
	public Account updateAccount(String id, int idstate, int idRole,String firtname,String lastname,String midname,
			int idType,String email1,String email2,String address1,String address2,String phoneNumber1,String phoneNumber2,String idcardNumber);
	public List<Account> getStateNew();
	public List<Account> getStateDis();
	public int random(int min, int max);
	public boolean addUser(User user, int idRole, int idType);
	public List<User> getAllUser();
	public boolean checkLoginid(String LoginId);


	public List<String> getRecomendedKey(int searchType);
	public List<Account> getStateActive();
	public List<Account> getStateRemvo();

	public List<Account> searchAccount(String key, int typeSearch);

}
