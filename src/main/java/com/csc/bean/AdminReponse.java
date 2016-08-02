package com.csc.bean;

import java.io.Serializable;

public class AdminReponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int countverifyTransaction;
	private int countChangeStateNewToActive;
	private int countChangeStateDisableToRemove;
	
	public int getCountverifyTransaction() {
		return countverifyTransaction;
	}
	
	public void setCountverifyTransaction(int countverifyTransaction) {
		this.countverifyTransaction = countverifyTransaction;
	}
	
	public int getCountChangeStateNewToActive() {
		return countChangeStateNewToActive;
	}
	
	public void setCountChangeStateNewToActive(int countChangeStateNewToActive) {
		this.countChangeStateNewToActive = countChangeStateNewToActive;
	}
	
	public int getCountChangeStateDisableToRemove() {
		return countChangeStateDisableToRemove;
	}
	
	public void setCountChangeStateDisableToRemove(int countChangeTateDisableToRemove) {
		this.countChangeStateDisableToRemove = countChangeTateDisableToRemove;
	}
}
