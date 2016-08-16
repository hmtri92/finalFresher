package com.csc.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.csc.entities.Account;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/test-context.xml"})
//@Transactional
//@TransactionConfiguration (defaultRollback = true)
public class AccountServiceImplTest {

	@Autowired
	AccountServiceImpl accountService;
	
	private static final Logger logger = Logger.getLogger(AccountServiceImplTest.class);
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Ignore
	@Test
	public void testAddAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAccountById() {
		Account minhtri = accountService.getAccountById("");
		assertNull(minhtri);
		logger.info("Account is null");
		
		minhtri = accountService.getAccountById("123456789001");
		assertEquals("123456789001", minhtri.getId());
		logger.info("Account: " + minhtri.getId() + " " + minhtri.getLastName());
	}

	@Ignore
	@Test
	public void testUpdateStateAccountById() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetStateNew() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetStateDis() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testRandom() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetRecomendedKey() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetAllUser() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testCheckLoginid() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetStateActive() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSearchAccount() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetStateRemvo() {
		fail("Not yet implemented");
	}

}
