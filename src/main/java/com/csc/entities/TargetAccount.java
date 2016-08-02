package com.csc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "targetaccounts")
public class TargetAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "idTarget")
	private long idTarget;
	
	@Column (name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn (name = "accountOwner")
	private Account accountOwner;
	
	@ManyToOne
	@JoinColumn (name = "accountTarget")
	private Account accountTarget;

	public TargetAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TargetAccount(long idTarget, String name, Account accountOwner,
			Account accountTarget) {
		super();
		this.idTarget = idTarget;
		this.name = name;
		this.accountOwner = accountOwner;
		this.accountTarget = accountTarget;
	}

	public long getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(long idTarget) {
		this.idTarget = idTarget;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Account accountOwner) {
		this.accountOwner = accountOwner;
	}

	public Account getAccountTarget() {
		return accountTarget;
	}

	public void setAccountTarget(Account accountTarget) {
		this.accountTarget = accountTarget;
	}
}
