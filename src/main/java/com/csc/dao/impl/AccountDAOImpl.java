package com.csc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.AccountDAO;
import com.csc.entities.Account;
import com.csc.entities.Role;
import com.csc.entities.State;
import com.csc.entities.TypeAccount;
import com.csc.entities.User;


@Repository
public class AccountDAOImpl implements AccountDAO {
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public boolean addAccount(Account account, int idRole, int idType) {

		TypeAccount type = em.find(TypeAccount.class, idType);
		State state = em.find(State.class, State.NEW);

		account.setTypeAccount(type);
		account.setState(state);
		em.persist(account);
	
		return true;
	}
	
	@Override
	public Account getAccountById(String id) {
		return em.find(Account.class, id);
	}
	
	@Override
	@Transactional
	public Account updateStateAccountById(String id,int idstate) {
			Account account = em.find(Account.class, id);
			State state = em.find(State.class, idstate);
			account.setState(state);
			em.persist(account);
			
			return account;
	}
	
	@Override
	@Transactional
	public Account updateAccount(String id, int idstate, int idRole,String firtname,String lastname,String midname,
			int idType,String email1,String email2,String address1,String address2,String phoneNumber1,String phoneNumber2,String idcardNumber) {
		
			Account account = em.find(Account.class, id);
			State state = em.find(State.class, idstate);
			TypeAccount type = em.find(TypeAccount.class, idType);
			account.setState(state);
			account.setTypeAccount(type);
			account.setAddress1(address1);
			account.setAddress2(address2);
			account.setEmail1(email1);
			account.setEmail2(email2);
			account.setFirstName(firtname);
			account.setLastName(lastname);
			account.setMidName(midname);
			account.setPhoneNum1(phoneNumber1);
			account.setPhoneNum2(phoneNumber2);
			account.setIdCardNumber(idcardNumber);
			em.persist(account);
			return account;
	}
	@Override
	@Transactional
	public List<Account> getStateNew() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.NEW);
		
		List<Account> listState = query.getResultList();
		
		return listState;
		
	}
	@Override
	@Transactional
	public List<Account> getStateDis() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.DISABLE);
		
		List<Account> listState = query.getResultList();
		
		return listState;		
	}
	@Override
	@Transactional
	public List<Account> getStateActive() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.ACTIVE);
		
		List<Account> listState = query.getResultList();
		
		return listState;		
	}

	@Override
	@Transactional
	public boolean addUser(User user, int idRole, int idType) {

		Role role = em.find(Role.class, idRole);
		TypeAccount type = em.find(TypeAccount.class, idType);
		State state = em.find(State.class, State.NEW);

		user.setRole(role);
		user.setTypeAccount(type);
		user.setState(state);
		em.persist(user);
	
		return true;
	}

	@Override
	public List<User> getAllUser() {
		String sql = "SELECT t FROM User t ";
		TypedQuery<User> query = em.createQuery(sql, User.class);
	
		List<User> listUser = query.getResultList();
		
		return listUser;		
	}

	@Override
	public boolean checkLoginid(String LoginId) {
		try {
			String sql = "SELECT t FROM User t WHERE t.loginID = :LoginId";
			TypedQuery<User> query = em.createQuery(sql, User.class);
			query.setParameter("LoginId", LoginId);
			
			User user = query.getSingleResult();
			if (user == null) {
				return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	@Override
	public List<String> getRecomendedKeyList(int searchType) {
		String sql1 = null;
		String sql2 = null;
		
		switch (searchType) {
		case 1:
			sql1 = "SELECT a.id FROM Account a";
			break;
		case 2:
			sql1 = "SELECT a.idCardNumber FROM Account a";
			break;
		case 3:
			sql1 = "SELECT CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName)  FROM Account a";
			break;
		case 6:
			sql1 = "SELECT a.phoneNum1 FROM Account a";
			sql2 = "SELECT a.phoneNum2 FROM Account a";			
			break;
		case 7:
			sql1 = "SELECT a.address1 FROM Account a";
			sql2 = "SELECT a.address2 FROM Account a";
			break;
		case 8:
			sql1 = "SELECT a.email1 FROM Account a";
			sql2 = "SELECT a.email2 FROM Account a";
			break;
		default:
			break;
		}

		
		
		
		TypedQuery<String> query = em.createQuery(sql1, String.class);
		
		List<String> listRecomend = query.getResultList();
		
		if (sql2 != null) {
			query = em.createQuery(sql2, String.class);
			listRecomend.addAll(query.getResultList());
		}
		
		return listRecomend;
	}

	@Override
	public List<Account> searchAccountByAccountNumber(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.id LIKE :key1 OR a.id LIKE :key2 OR a.id LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByIdCardNumber(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.idCardNumber LIKE :key1 OR a.idCardNumber LIKE :key2 OR a.idCardNumber LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByOwnerName(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a "
				+ "WHERE CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName) LIKE :key1 "
				+ "OR CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName) LIKE :key2 "
				+ "OR CONCAT( a.firstName, ' ', a.midName, ' ', a.lastName) LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByType(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.id LIKE :key1 OR a.id LIKE :key2 OR a.id LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByState(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.id LIKE :key1 OR a.id LIKE :key2 OR a.id LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByPhone(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.id LIKE :key1 OR a.id LIKE :key2 OR a.id LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByAddress(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.id LIKE :key1 OR a.id LIKE :key2 OR a.id LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	public List<Account> searchAccountByEmail(String key) {
		// TODO Auto-generated method stub
		List<Account> result = null;
		
		String sql = "SELECT a FROM Account a WHERE a.id LIKE :key1 OR a.id LIKE :key2 OR a.id LIKE :key3";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("key1", key  + "%");
		query.setParameter("key2", "%" +  key);
		query.setParameter("key3", "%" + key + "%");
				
		result = query.getResultList();		
		
		return result;
	}

	@Override
	@Transactional
	public List<Account> getStateRemvo() {
		String sql = "SELECT t FROM Account t WHERE t.state.idState = :state";
		TypedQuery<Account> query = em.createQuery(sql, Account.class);
		query.setParameter("state", State.REMOVEABLE);
		
		List<Account> listState = query.getResultList();
		
		return listState;
	}

}

