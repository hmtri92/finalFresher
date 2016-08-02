package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.service.AccountService;
//chuyen tu dis sang remove
@Controller
@SessionAttributes({ "username", "role" })
public class verifyActive_DisableController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/support/change_State_Active-Dis", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView changeState(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("support/verifiActive-Dis");

		List<Account> account = null;
		account = accountService.getStateActive();
		model.addObject("listAccount", account);

		return model;

	}

	@RequestMapping(value = "/support/doVerifyStateActive", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String addAccount(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String id = request.getParameter("id");
		int state = 3;
		Account existedAccount = accountService.getAccountById(id);

		if (existedAccount == null) {
			model.addAttribute("message", "This account is not valid");

		} else {
			accountService.updateStateAccountById(id, state);
			model.addAttribute("message", "This account have been  modified");

		}
		return "forward:change_State_Active-Dis";
	}
}
