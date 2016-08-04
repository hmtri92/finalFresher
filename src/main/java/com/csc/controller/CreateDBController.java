package com.csc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.ultil.CreateDatabase;

@Controller
public class CreateDBController {

	@Autowired
	CreateDatabase db;

	private static final Logger logger = Logger.getLogger("CreateDBController");

	@RequestMapping(value = "/createDB", method = RequestMethod.GET)
	public String createDB() {
		logger.info("create database");

		db.createRole();
		db.createState();
		db.createTypeAccount();
		db.createAccount();
		db.createUser();
		db.createTranSaction();
		db.createTargetAccount();
		
		return "forward:login";
	}
}
