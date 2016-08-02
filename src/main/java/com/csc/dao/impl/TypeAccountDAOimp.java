package com.csc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.TypeAccountDAO;
import com.csc.entities.TypeAccount;
@Repository

public class TypeAccountDAOimp implements TypeAccountDAO {
	@PersistenceContext
	EntityManager em;

	
	@Override
	@Transactional
	public List<TypeAccount> getTypeBy() {
		String sql = "SELECT t FROM TypeAccount t";
		TypedQuery<TypeAccount> query = em.createQuery(sql, TypeAccount.class);
		
		List<TypeAccount> typeAccounts = query.getResultList();		  
		return typeAccounts;
	}

}
