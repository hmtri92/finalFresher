package com.csc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.csc.dao.AdminInfoDAO;
import com.csc.entities.State;

@Repository
public class AdminInfoDAOImpl implements AdminInfoDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int getCountVerifyTransaction() {
		try {
			String sql = "SELECT COUNT(t) FROM TransactionHistory t WHERE t.state.idState = ?";
			
			Query query =  em.createQuery(sql);
			query.setParameter(1, State.NEW);
			int count = ((Long) query.getSingleResult()).intValue();
			
			return count; 
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int getCountAccountNew() {
		try {
			String sql = "SELECT COUNT(t) FROM Account t WHERE t.state.idState = ?";
			
			Query query = em.createQuery(sql);
			query.setParameter(1, State.NEW);
			int count = ((Long) query.getSingleResult()).intValue();
			return count;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int getCountAccountDisable() {
		try {
			String sql = "SELECT COUNT(t) FROM Account t WHERE t.state.idState = ?";
			
			Query query = em.createQuery(sql);
			query.setParameter(1, State.DISABLE);
			int count = ((Long) query.getSingleResult()).intValue();
			return count;
		} catch (Exception e) {
			return 0;
		}
	}

}
