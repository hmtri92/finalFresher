package com.csc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.TypeAccountDAO;
import com.csc.entities.TypeAccount;
import com.csc.service.TypeService;

@Service
public class TypeServiceimpl implements TypeService{
	@Autowired
	TypeAccountDAO typeDao;
	
	@Override
	public List<TypeAccount> getTypeBy() {
		// TODO Auto-generated method stub
		typeDao.getTypeBy();
		return null;
	}
	
	

}
