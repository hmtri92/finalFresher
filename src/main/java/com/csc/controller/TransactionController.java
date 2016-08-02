package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.StateResult;
import com.csc.entities.TransactionHistory;
import com.csc.service.FundService;

@Controller
@SessionAttributes({"username", "role" })
public class TransactionController {

	@Autowired
	FundService fundService;
	
	@RequestMapping (value = "/admin/viewVerifyTransaction", method = RequestMethod.GET)
	public ModelAndView verifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("admin/verifyTransaction");
		
		List<TransactionHistory> transactions = null;
		transactions = fundService.getNewTransaction();
		model.addObject("transactions", transactions);
		
		return model;
	}
	
	@RequestMapping (value = "/admin/verifyTransaction", method = RequestMethod.POST)
	@ResponseBody
	public StateResult doVerifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("idTransaction");
		long idTransaction = Long.parseLong(id);
		
		return fundService.verifyTransaction(idTransaction);
	}
	
	@RequestMapping (value = "/admin/ignoreTransaction", method = RequestMethod.POST)
	@ResponseBody
	public StateResult doIgnoreTransaction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("idTransaction");
		long idTransaction = Long.parseLong(id);
		
		return fundService.ignoreTransaction(idTransaction);
	}
}
