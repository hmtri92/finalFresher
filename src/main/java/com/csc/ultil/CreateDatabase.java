package com.csc.ultil;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.entities.Account;
import com.csc.entities.Role;
import com.csc.entities.State;
import com.csc.entities.TargetAccount;
import com.csc.entities.TransactionHistory;
import com.csc.entities.TypeAccount;
import com.csc.entities.User;

@Repository
public class CreateDatabase {
	@PersistenceContext//(unitName="final-project")
	EntityManager em;
	
	@Transactional
	public void createRole() {
		Role roleUser = new Role();
		roleUser.setIdRole(1);
		roleUser.setNameRole("CUSTOMER");
		
		Role roleAdmin = new Role();
		roleAdmin.setIdRole(2);
		roleAdmin.setNameRole("ADMIN");
		
		Role roleAccountSupport = new Role();
		roleAccountSupport.setIdRole(3);
		roleAccountSupport.setNameRole("ACCOUNT_SUPPORT");
		
		Role roleUserSupport = new Role();
		roleUserSupport.setIdRole(4);
		roleUserSupport.setNameRole("CUSTOMER_SUPPORT");
		
		Role roleReportSupport = new Role();
		roleReportSupport.setIdRole(5);
		roleReportSupport.setNameRole("REPORT_SUPPORT");
		
		try {
			em.persist(roleUser);
			em.persist(roleAdmin);
			em.persist(roleAccountSupport);
			em.persist(roleUserSupport);
			em.persist(roleReportSupport);
		} catch ( Exception e) {
			
		}
	}
	
	@Transactional
	public void createTypeAccount() {
		TypeAccount deposit = new TypeAccount();
		deposit.setIdType(1);
		deposit.setType("DEPOSIT");
		
		TypeAccount saving = new TypeAccount();
		saving.setIdType(2);
		saving.setType("SAVING");
		
		TypeAccount other = new TypeAccount();
		other.setIdType(3);
		other.setType("OTHER");
		
		try {
			em.persist(deposit);
			em.persist(saving);
			em.persist(other);
		} catch (Exception e) {
			
		}
	}
	
	@Transactional
	public void createState() {
		State snew = new State();
		snew.setIdState(1);
		snew.setName("NEW");
		
		State active = new State();
		active.setIdState(2);
		active.setName("ACTIVE");
		
		State disable = new State();
		disable.setIdState(3);
		disable.setName("DISABLE");
		
		State removeable = new State();
		removeable.setIdState(4);
		removeable.setName("REMOVEABLE");
		
		State removed = new State();
		removed.setIdState(5);
		removed.setName("REMOVED");
		
		try {
			em.persist(snew);
			em.persist(active);
			em.persist(disable);
			em.persist(removeable);
			em.persist(removed);
		} catch (Exception e) {}
		
	}	
	
	@Transactional
	public void createUser() {
		Role roleAdmin = em.find(Role.class, Role.ADMIN);
		State state = em.find(State.class, State.ACTIVE);
		
		User minhtri = new User();
		minhtri.setId("012345678903");
		minhtri.setLoginID("admin");
		minhtri.setPassword("$2a$10$4HKVeFVczIQOoRMQ7tCb0OIob6GE7RgmcIqh1VKmuRFJApnmnampi");
		minhtri.setIdCardNumber("272015010"); 
		minhtri.setFirstName("Tri");
		minhtri.setMidName("Minh");
		minhtri.setLastName("Huynh");
		minhtri.setAddress1("Tan Binh");
		minhtri.setAddress2("Thu Duc");
		minhtri.setEmail1("hmtri92@gmail.com");
		minhtri.setEmail2("minhtri@gmail.com");
		minhtri.setPhoneNum1("0913131313");
		minhtri.setPhoneNum2("09090909");
		minhtri.setRole(roleAdmin);
		minhtri.setState(state);
		minhtri.setRole(roleAdmin);
		minhtri.setAvailableAmount( BigDecimal.valueOf(1000000));
		minhtri.setAttempts(0);
		minhtri.setLastModified(new Date());
		
		Role roleSupport = em.find(Role.class, Role.ACCOUNT_SUPPORT);
		State state2 = em.find(State.class, State.ACTIVE);
		
		User phuc = new User();
		phuc.setId("012345678902");
		phuc.setIdCardNumber("272015010"); 
		phuc.setFirstName("Tri");
		phuc.setMidName("Minh");
		phuc.setLastName("Huynh");
		phuc.setAddress1("Tan Binh");
		phuc.setAddress2("Thu Duc");
		phuc.setEmail1("hmtri92@gmail.com");
		phuc.setEmail2("minhtri@gmail.com");
		phuc.setPhoneNum1("0913131313");
		phuc.setPhoneNum2("09090909");
		phuc.setRole(roleSupport);
		phuc.setState(state2);
		phuc.setLoginID("support");
		phuc.setPassword("$2a$10$4HKVeFVczIQOoRMQ7tCb0OIob6GE7RgmcIqh1VKmuRFJApnmnampi");
		phuc.setAvailableAmount( BigDecimal.valueOf(1000000));
		
		Role roleCustomer = em.find(Role.class, Role.CUSTOMER);
		State state3 = em.find(State.class, State.ACTIVE);
		
		User quocanh = new User();
		quocanh.setId("012345678901");
		quocanh.setLoginID("customer");
		quocanh.setPassword("$2a$10$4HKVeFVczIQOoRMQ7tCb0OIob6GE7RgmcIqh1VKmuRFJApnmnampi");
		quocanh.setIdCardNumber("272015010"); 
		quocanh.setFirstName("Tri");
		quocanh.setMidName("Minh");
		quocanh.setLastName("Huynh");
		quocanh.setAddress1("Tan Binh");
		quocanh.setAddress2("Thu Duc");
		quocanh.setEmail1("hmtri92@gmail.com");
		quocanh.setEmail2("minhtri@gmail.com");
		quocanh.setPhoneNum1("0913131313");
		quocanh.setPhoneNum2("09090909");
		quocanh.setRole(roleCustomer);
		quocanh.setState(state3);
		quocanh.setAvailableAmount( BigDecimal.valueOf(1000000));
		
		try {
			em.persist(minhtri);
			em.persist(quocanh);
			em.persist(phuc);
			System.err.println("add customer successfully!");
		} catch (Exception e) {}
	}
	
	@Transactional
	public void createAccount() {
		State state = em.find(State.class, State.ACTIVE);
		State stateNotActive = em.find(State.class, State.DISABLE);
		
		TypeAccount type = em.find(TypeAccount.class, TypeAccount.OTHER);
		
		Account minhtri = new Account();
		minhtri.setId("123456789001");
		minhtri.setIdCardNumber("272015010"); 
		minhtri.setFirstName("Huynh");
		minhtri.setMidName("Minh");
		minhtri.setLastName("Tri");
		minhtri.setAddress1("Tan Binh");
		minhtri.setAddress2("Thu Duc");
		minhtri.setEmail1("hmtri92@gmail.com");
		minhtri.setEmail2("minhtri@gmail.com");
		minhtri.setPhoneNum1("0913131313");
		minhtri.setPhoneNum2("09090909");
		minhtri.setState(state);
		minhtri.setTypeAccount(type);
		minhtri.setAvailableAmount( BigDecimal.valueOf(1000000));
		
		Account pug = new Account();
		pug.setId("123456789002");
		pug.setIdCardNumber("272015010"); 
		pug.setFirstName("Tran");
		pug.setMidName("Quoc");
		pug.setLastName("Thao");
		pug.setAddress1("Tan Binh");
		pug.setAddress2("Thu Duc");
		pug.setEmail1("pugTran@gmail.com");
		pug.setPhoneNum1("0913131313");
		pug.setState(stateNotActive);
		pug.setTypeAccount(type);
		pug.setAvailableAmount( BigDecimal.valueOf(1000000));
		
		Account hung = new Account();
		hung.setId("123456789003");
		hung.setIdCardNumber("272015010"); 
		hung.setFirstName("Nguye");
		hung.setMidName("Vu");
		hung.setLastName("Hung");
		hung.setAddress1("Tan Binh");
		hung.setAddress2("Thu Duc");
		hung.setEmail1("hungNguyen@gmail.com");
		hung.setPhoneNum1("0913131313");
		hung.setState(state);
		hung.setTypeAccount(type);
		hung.setAvailableAmount( BigDecimal.valueOf(1000000));
		
		try {
			em.persist(minhtri);
			em.persist(pug);
			em.persist(hung);
			System.err.println("add customer successfully!");
		} catch (Exception e) {}
	}
	
	@Transactional
	public void createTranSaction() {
		State state = em.find(State.class, State.NEW);
		
		Account minhtri = em.find(Account.class, "123456789001");
		Account pug = em.find(Account.class, "123456789002");
		
		TransactionHistory addTran = new TransactionHistory();
		addTran.setSendAccount(minhtri);
		addTran.setReceiveAccount(minhtri);
		addTran.setAmount(BigDecimal.valueOf(1000000));
		addTran.setDate(new Date());
		addTran.setState(state);
		addTran.setTypeTransaction(TransactionHistory.ADD_FUND);
		
		TransactionHistory transferTran = new TransactionHistory();
		transferTran.setSendAccount(minhtri);
		transferTran.setReceiveAccount(pug);
		transferTran.setAmount(BigDecimal.valueOf(100000));
		transferTran.setDate(new Date());
		transferTran.setState(state);
		transferTran.setTypeTransaction(TransactionHistory.TRANSFER);
		
		TransactionHistory withdrawTran = new TransactionHistory();
		withdrawTran.setSendAccount(minhtri);
		withdrawTran.setReceiveAccount(minhtri);
		withdrawTran.setAmount(BigDecimal.valueOf(100000));
		withdrawTran.setDate(new Date());
		withdrawTran.setState(state);
		withdrawTran.setTypeTransaction(TransactionHistory.WITHDRAW);
		
		try {
			em.persist(addTran);
			em.persist(transferTran);
			em.persist(withdrawTran);
		} catch (Exception e) {}
	}
	
	@Transactional
	public void createTargetAccount() {
		Account minhtri = em.find(Account.class, "123456789001");
		Account pug = em.find(Account.class, "123456789002");
		Account hung = em.find(Account.class, "123456789003");
		
		TargetAccount targetAccount1 = new TargetAccount();
		targetAccount1.setAccountOwner(minhtri);
		targetAccount1.setAccountTarget(pug);
		targetAccount1.setName("Pug Tran");
		
		TargetAccount targetAccount2 = new TargetAccount();
		targetAccount2.setAccountOwner(minhtri);
		targetAccount2.setAccountTarget(hung);
		targetAccount2.setName("Hung Nguyen");
		
		try {
			em.persist(targetAccount1);
			em.persist(targetAccount2);
		} catch (Exception e) {}
	}
}
