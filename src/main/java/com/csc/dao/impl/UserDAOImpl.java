package com.csc.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.UserDAO;
import com.csc.entities.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public boolean changeInfo(User user) {
		// TODO Auto-generated method stub
		try {
			em.merge(user);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

	/*
	 * minh tri
	 * 
	 */
	@Override
	public User getUserByID(String id) {
		return em.find(User.class, id);
	}

	@Override
	@Transactional
	public User getUserByLoginID(String loginId) {
		String sql = "SELECT u FROM User u WHERE u.loginID = :loginId";
		TypedQuery<User> query = em.createQuery(sql, User.class);
		query.setParameter("loginId", loginId);
		return query.getSingleResult();
	}
}
