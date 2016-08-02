package com.csc.dao;

import java.util.List;

import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;

public interface ITargetAccountDAO {

	List<TargetAccount> getListTargetByAccountOwnerId(String id);
	StateResult addTargetAccount(String idAccountOwner, String idAccountTarget, String name);
	StateResult modifyTarget(String id, String idAccountTarget, String name);
	StateResult deleteTarget(String id);
	TargetAccount getTargetAccountByOwnerAndTarget(String idOwner, String idTarget);
	TargetAccount getTargetAccountById(String id);
}
