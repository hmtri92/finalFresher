package com.csc.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.AccountDAO;
import com.csc.entities.Account;
import com.csc.entities.User;
import com.csc.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO accountDao;

	@Override
	public Boolean addAccount(Account account,int idRole, int idType) {
		Boolean result = accountDao.addAccount(account, idRole, idType);

		if (result) {
			return true;
		}
		return false;
	}

	@Override
	public Account getAccountById(String id) {
		return	accountDao.getAccountById(id);
	}

	@Override
	public Account updateStateAccountById(String id, int state) {
		return accountDao.updateStateAccountById(id, state);
	}
	

	@Override
	public Account updateAccount(String id, int idstate, int idRole,
			String firtname, String lastname, String midname, int idType,
			String email1, String email2, String address1, String address2,
			String phoneNumber1, String phoneNumber2, String idcardNumber) {
		// TODO Auto-generated method stub
		return accountDao.updateAccount(id, idstate, idRole, firtname, lastname, midname, idType, email1, email2, address1, address2, phoneNumber1, phoneNumber2, idcardNumber);
	}

	@Override
	public List<Account> getStateNew() {
		// TODO Auto-generated method stub
		return accountDao.getStateNew();
	}

	@Override
	public List<Account> getStateDis() {
		// TODO Auto-generated method stub
		return accountDao.getStateDis();
	}

	@Override
	public int random(int min, int max) {
		   try {
	            Random rn = new Random();
	            int range = max - min + 1;
	            int randomNum = min + rn.nextInt(range);
	            return randomNum;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	@Override
	public List<String> getRecomendedKey(int searchType) {
		// TODO Auto-generated method stub
		return accountDao.getRecomendedKeyList(searchType);
	}


	@Override
	public boolean addUser(User user, int idRole, int idType) {
		Boolean result = accountDao.addUser(user, idRole, idType);

		return result;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return accountDao.getAllUser();
	}

	@Override
	public boolean checkLoginid(String LoginId) {
		// TODO Auto-generated method stub
		return accountDao.checkLoginid(LoginId);
	}

	@Override
	public List<Account> getStateActive() {
		// TODO Auto-generated method stub
		return accountDao.getStateActive();
	}

	@Override
	public List<Account> searchAccount(String key, int typeSearch) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		switch (typeSearch) {
		case 1:
			result = accountDao.searchAccountByAccountNumber(key);
			break;
		case 2:
			result = accountDao.searchAccountByIdCardNumber(key);
			break;
		case 3:
			result = accountDao.searchAccountByOwnerName(key);
			break;
		case 4:
			result = accountDao.searchAccountByType(key);
			break;
		case 5:
			result = accountDao.searchAccountByState(key);
			break;
		case 6:
			result = accountDao.searchAccountByPhone(key);
			break;
		case 7:
			result = accountDao.searchAccountByAddress(key);
			break;
		case 8:
			result = accountDao.searchAccountByEmail(key);
			break;

		default:
			break;
		}
		
		return result;
	}


	@Override
	public List<Account> getStateRemvo() {
		// TODO Auto-generated method stub
		return accountDao.getStateRemvo();
	}

}
