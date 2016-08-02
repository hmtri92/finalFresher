package com.csc.dao;

import com.csc.entities.User;

public interface UserDAO {
	
	public boolean changeInfo(User user);

	public User getUserByID(String id);
	
	User getUserByLoginID(String loginId);
}
