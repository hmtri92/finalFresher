package com.csc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "states")
public class State implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	public static final int NEW = 1;
	
	@Transient
	public static final int ACTIVE = 2;
	
	@Transient
	public static final int DISABLE = 3;
	
	@Transient
	public static final int REMOVEABLE = 4;
	
	@Transient
	public static final int REMOVED = 5;
	
	@Id
	private int idState;
	
	@NotEmpty
	@Column (name = "name")
	private String name;
	
	@OneToMany (mappedBy = "state")
	@JsonIgnore
	private List<Account> accounts;
	
	@OneToMany (mappedBy = "state")
	@JsonIgnore
	private List<TransactionHistory> transactions;


	public State() {
		super();
		// TODO Auto-generated constructor stub
	}


	public State(int idState, String name, List<Account> accounts,
			List<TransactionHistory> transactions) {
		super();
		this.idState = idState;
		this.name = name;
		this.accounts = accounts;
		this.transactions = transactions;
	}

	public List<TransactionHistory> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionHistory> transactions) {
		this.transactions = transactions;
	}

	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
