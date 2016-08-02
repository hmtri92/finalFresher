package com.csc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.entities.Account;
import com.csc.service.AccountService;

@Controller
public class ModifiAccountController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/support/modifyAccount", method = RequestMethod.GET)
	public String goViewAddFund2() {
		return "support/modifyAccount";
	}

	@RequestMapping(value = "/support/domodifyAccount", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String accountNumber = request.getParameter("id");

		String idCardNumber = request.getParameter("idCardNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String midName = request.getParameter("midName");
		String phoneNum1 = request.getParameter("phoneNum1");
		String phoneNum2 = request.getParameter("phoneNum2");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String stat = request.getParameter("state");
		int state = Integer.parseInt(stat);
		String rol = request.getParameter("role");
		int role = Integer.parseInt(rol);
		String typeAccount1 = request.getParameter("typeAccount");
		int typeAccount = Integer.parseInt(typeAccount1);

		accountService.updateAccount(accountNumber, state, role, firstName,
				lastName, midName, typeAccount, email1, email2, address1,
				address2, phoneNum1, phoneNum2, idCardNumber);

		model.addAttribute("message", "Modify Account Success!");
		return "support/modifyAccount";

		// }
	}

	@RequestMapping(value = "/support/checkAccount1", method = RequestMethod.POST)
	public String checkAccount(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		{
			String accountNumber1 = request.getParameter("accountNumber1");

			Account existedAccount = accountService
					.getAccountById(accountNumber1);

			if (existedAccount == null) {
				model.addAttribute("message1", "This account is not valid");
				return "support/modifyAccount";

			} else {
				model.addAttribute("message1", "This account is  valid");
				model.addAttribute("accountExit", existedAccount);
				return "support/modifyAccount";

			}

		}
	}
}
