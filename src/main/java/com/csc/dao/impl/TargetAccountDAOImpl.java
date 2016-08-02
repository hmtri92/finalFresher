package com.csc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.ITargetAccountDAO;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;

@Repository
public class TargetAccountDAOImpl implements ITargetAccountDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<TargetAccount> getListTargetByAccountOwnerId(String id) {
		String sql = "SELECT t FROM TargetAccount t WHERE t.accountOwner.id = :id";
		TypedQuery<TargetAccount> query = em.createQuery(sql, TargetAccount.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

	@Override
	public StateResult addTargetAccount(String idAccountOwner,
			String idAccountTarget, String name) {
		StateResult result = new StateResult();
		try {
			String sql = "INSERT INTO TargetAccounts(accountOwner, accountTarget, name) " +
				"VALUE(?,?,?) ";
			Query query = em.createNativeQuery(sql);
			query.setParameter(1, idAccountOwner);
			query.setParameter(2, idAccountTarget);
			query.setParameter(3, name);
			int success = query.executeUpdate();
			
			if (success == 0) {
				result.setState(false);
				result.setMessage("Error");
			} else {
				result.setState(true);
				result.setMessage("Success");
			}
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Can't not create TargetAccount");
		}
		
		return result;
	}

	@Override
	public StateResult modifyTarget(String id, String idAccountTarget,
			String name) {
		StateResult result = new StateResult();
		try {
			long idTarget = Long.parseLong(id);
			String sql = "UPDATE TargetAccounts t SET t.accountTarget = :accountTarget, t.name = :name"
					+ " WHERE t.idTarget = :idTarget";
			Query query = em.createNativeQuery(sql);
			query.setParameter("accountTarget", idAccountTarget);
			query.setParameter("name", name);
			query.setParameter("idTarget", idTarget);
			int success = query.executeUpdate();
			
			if (success == 0) {
				result.setState(false);
				result.setMessage("Error");
			} else {
				result.setState(true);
				result.setMessage("Success");
			}
			
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Error");
		}
		return result;
	}

	@Override
	public StateResult deleteTarget(String id) {
		StateResult result = new StateResult();
		try {
			long idTarget = Long.parseLong(id);
			String sql = "DELETE FROM TargetAccount t WHERE t.idTarget = :idTarget";
			Query query = em.createQuery(sql);
			query.setParameter("idTarget", idTarget);
			int success = query.executeUpdate();
			
			if (success == 0) {
				result.setState(false);
				result.setMessage("Fail");
			} else {
				result.setState(true);
				result.setMessage("Success");
			}
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Error");
			System.out.println(e);
		}
		return result;
	}

	@Override
	public TargetAccount getTargetAccountByOwnerAndTarget(String idOwner,
			String idTarget) {
		String sql = "SELECT t FROM TargetAccount t "
				+ "WHERE t.accountOwner.id = :accountOwner AND t.accountTarget.id = :accountTarget";
		TypedQuery<TargetAccount> query = em.createQuery(sql, TargetAccount.class);
		query.setParameter("accountOwner", idOwner);
		query.setParameter("accountTarget", idTarget);
		
		TargetAccount targetAccount = query.getSingleResult();
		return targetAccount;
	}

	@Override
	public TargetAccount getTargetAccountById(String id) {
		long idTarget = Long.parseLong(id);
		return em.find(TargetAccount.class, idTarget);
	}
	
	

}
