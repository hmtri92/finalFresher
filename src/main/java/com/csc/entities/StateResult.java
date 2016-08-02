package com.csc.entities;

import java.io.Serializable;

public class StateResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean state;
	private String message;
	
	public StateResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StateResult(boolean state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	
	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
