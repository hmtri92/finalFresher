package com.csc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "balanceAmounts")
public class BalanceAmount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id_balance")
	private String idBalanceAmount;
	
	@NotEmpty
	@Column (name = "balance")
	private BigDecimal balance;
	
	@Size(min = 1, message="Period must be at least 1 number!")
	@NotEmpty
	@Column (name = "period")
	private Date period;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn (name = "id_Account")
	private Account account;

	public BalanceAmount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalanceAmount(String idBalanceAmount, BigDecimal balance, Date period,
			Account account) {
		super();
		this.idBalanceAmount = idBalanceAmount;
		this.balance = balance;
		this.period = period;
		this.account = account;
	}

	public String getIdBalanceAmount() {
		return idBalanceAmount;
	}

	public void setIdBalanceAmount(String idBalanceAmount) {
		this.idBalanceAmount = idBalanceAmount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
