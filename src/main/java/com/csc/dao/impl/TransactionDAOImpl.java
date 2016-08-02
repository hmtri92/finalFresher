package com.csc.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.TransactionDAO;
import com.csc.entities.TransactionHistory;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<TransactionHistory> getTransactionByUserId(String id, int state) {
		// TODO Auto-generated method stub
		List<TransactionHistory> result = null;
		
		TypedQuery<TransactionHistory> query = em.createQuery("SELECT t FROM TransactionHistory t WHERE (t.sendAccount.id = :id "
				+ " OR t.receiveAccount.id = :id) AND t.state.idState = :state", TransactionHistory.class);
		query.setParameter("id", id);
		query.setParameter("state", state);
		result = query.getResultList();
		
		return result;
	}

	@Override
	public List<TransactionHistory> getTransactionByDateRange(String userID,
			Date dateFrom, Date dateTo, int state) {
		// TODO Auto-generated method stub
		List<TransactionHistory> result = null;
		
		TypedQuery<TransactionHistory> query = em.createQuery("SELECT t FROM TransactionHistory t WHERE"
				+ " (t.sendAccount.id = :id OR t.receiveAccount.id = :id) "
				+ "AND t.state.idState = :state "
				+ "AND (t.date >= :dateFrom AND t.date <= :dateTo)", TransactionHistory.class);			
		
		query.setParameter("id", userID);
		query.setParameter("state", state);
		query.setParameter("dateFrom", dateFrom);
		query.setParameter("dateTo", dateTo);
		result = query.getResultList();
		
		return result;
	}

}
