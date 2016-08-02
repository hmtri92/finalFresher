package com.csc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;

@Entity
@Table ( name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id", length = 12)
	@Size(min = 12, max = 12)
	private String id;
	
	@Size(min = 1, message="First name must be at least 1 character!")
	@Column (name = "firstname")
	private String firstName;
	
	@Size(min = 1, message="Last name must be at least 1 character!")
	@Column (name = "lastname")
	private String lastName;
	
	@Size(min = 1, message="Mid name must be at least 1 character!")
	@Column (name = "midname")
	private String midName;
	
	@Size(min = 8, message="Phone must be at least 8 number!")
	@Column (name = "phoneNum1")
	private String phoneNum1;
	
	@Size(min = 8, message="Phone must be at least 8 number!")
	@Column (name = "phoneNum2")
	private String phoneNum2;
	
	@Size(min = 1, message="Address must be at least 1 character!")
	@Column (name = "address1")
	private String address1;
	
	@Size(min = 1, message="Address must be at least 1 character!")
	@Column (name = "address2")
	private String address2;
	
	@Size(min = 3, message="Email must be at least 3 character!")
	@Column (name = "email1")
	@Email
	private String email1;
	
	@Size(min = 3, message="Email must be at least 3 character!")
	@Column (name = "email2")
	@Email
	private String email2;
	
	@Size(min = 9, message="Id card must be at least 9 number!")
	@Column (name = "id_cardNumber")
	private String idCardNumber;
		
	@Column (name = "availableAmount")
	private BigDecimal availableAmount;
	
	@ManyToOne
	@JoinColumn (name = "id_type")
	private TypeAccount typeAccount;
	
	@ManyToOne
	@JoinColumn (name = "id_state")
	private State state;
	
	@OneToMany (mappedBy = "account")
	@JsonIgnore
	private List<BalanceAmount> balanceAmounts;
	
	@OneToMany (mappedBy = "sendAccount")
	@JsonIgnore
	private List<TransactionHistory> sendTracsactions;
	
	@OneToMany (mappedBy = "receiveAccount")
	@JsonIgnore
	private List<TransactionHistory> receiveTracsactions;
	
	@OneToMany (mappedBy = "accountOwner")
	@JsonIgnore
	private List<TargetAccount> targetAccounts;
	
	@OneToMany (mappedBy = "accountTarget")
	@JsonIgnore
	private List<TargetAccount> targetOfAccounts;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String idCardNumber, BigDecimal availableAmount,
			TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts,
			List<TransactionHistory> sendTracsactions,
			List<TransactionHistory> receiveTracsactions) {
		super();
		this.idCardNumber = idCardNumber;
		this.availableAmount = availableAmount;
		this.typeAccount = typeAccount;
		this.state = state;
		this.balanceAmounts = balanceAmounts;
		this.sendTracsactions = sendTracsactions;
		this.receiveTracsactions = receiveTracsactions;
	}
	
	public Account(String id, String firstName, String lastName,
			String midName, String phoneNum1, String phoneNum2,
			String address1, String address2, String email1, String email2,
			String idCardNumber, BigDecimal availableAmount,
			TypeAccount typeAccount, State state,
			List<BalanceAmount> balanceAmounts,
			List<TransactionHistory> sendTracsactions,
			List<TransactionHistory> receiveTracsactions,
			List<TargetAccount> targetAccounts,
			List<TargetAccount> targetOfAccounts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.phoneNum1 = phoneNum1;
		this.phoneNum2 = phoneNum2;
		this.address1 = address1;
		this.address2 = address2;
		this.email1 = email1;
		this.email2 = email2;
		this.idCardNumber = idCardNumber;
		this.availableAmount = availableAmount;
		this.typeAccount = typeAccount;
		this.state = state;
		this.balanceAmounts = balanceAmounts;
		this.sendTracsactions = sendTracsactions;
		this.receiveTracsactions = receiveTracsactions;
		this.targetAccounts = targetAccounts;
		this.targetOfAccounts = targetOfAccounts;
	}


	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}

	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<BalanceAmount> getBalanceAmounts() {
		return balanceAmounts;
	}

	public void setBalanceAmounts(List<BalanceAmount> balanceAmounts) {
		this.balanceAmounts = balanceAmounts;
	}

	public List<TransactionHistory> getSendTracsactions() {
		return sendTracsactions;
	}

	public void setSendTracsactions(List<TransactionHistory> sendTracsactions) {
		this.sendTracsactions = sendTracsactions;
	}

	public List<TransactionHistory> getReceiveTracsactions() {
		return receiveTracsactions;
	}

	public void setReceiveTracsactions(List<TransactionHistory> receiveTracsactions) {
		this.receiveTracsactions = receiveTracsactions;
	}

	public List<TargetAccount> getTargetAccounts() {
		return targetAccounts;
	}

	public void setTargetAccounts(List<TargetAccount> targetAccounts) {
		this.targetAccounts = targetAccounts;
	}

	public List<TargetAccount> getTargetOfAccounts() {
		return targetOfAccounts;
	}

	public void setTargetOfAccounts(List<TargetAccount> targetOfAccounts) {
		this.targetOfAccounts = targetOfAccounts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getPhoneNum1() {
		return phoneNum1;
	}

	public void setPhoneNum1(String phoneNum1) {
		this.phoneNum1 = phoneNum1;
	}

	public String getPhoneNum2() {
		return phoneNum2;
	}

	public void setPhoneNum2(String phoneNum2) {
		this.phoneNum2 = phoneNum2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}
}
