package com.csc.controller;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.entities.BalanceAmount;
import com.csc.entities.User;
import com.csc.service.AccountService;
import com.csc.ultil.PasswordUtils;

@Controller
@SessionAttributes({ "username", "role", "id" })
public class AccountController {
	@Autowired
	AccountService accountService;

	public ModelAndView AccountPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("support/addAccount");

		return model;

	}

	@RequestMapping(value = "/support/createAccount", method = RequestMethod.GET)
	public String goViewAddFund2() {
		return "support/addAccount";
	}

	@RequestMapping(value = "/support/docreateAccount", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String accountNumber = request.getParameter("id");
		// BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request
		// .getParameter("availableAmount")));
		BigDecimal amount = BigDecimal.valueOf(0);
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
		String loginId = request.getParameter("loginId");
		String rol = request.getParameter("role");

		int role = Integer.parseInt(rol);
		String typeAccount1 = request.getParameter("typeAccount");
		int typeAccount = Integer.parseInt(typeAccount1);
		
		String password = "123456";
		try {
			password = PasswordUtils.generateRandomString(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String passwordEncode = PasswordUtils.encodePassword(password);
		User user = new User();
		user.setId(accountNumber);
		user.setAvailableAmount(amount);
		user.setIdCardNumber(idCardNumber);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMidName(midName);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setEmail1(email1);
		user.setEmail2(email2);
		user.setPhoneNum1(phoneNum1);
		user.setPhoneNum2(phoneNum2);
		user.setPassword(passwordEncode);
		user.setLoginID(loginId);

		Account existedAccount = accountService.getAccountById(accountNumber);

		if (existedAccount == null) {
			boolean result = accountService.checkLoginid(loginId);
			if (!result) {
				accountService.addUser(user, role, typeAccount);
				// accountService.addUser(accountNumber, state, role,
				// idCardNumber, pass2, loginId);
				model.addAttribute("message", "Create Account Success!");
				
				user.setPassword(password);
				model.addAttribute("User", user);
				model.addAttribute("pass1", password);
				return "support/addAccount";

			} else {
				model.addAttribute("message", "LoginId has Exit!");
				return "support/addAccount";

			}
		} else {
			model.addAttribute("message", "Create Account Fail!");
			return "support/addAccount";

		}

	}

	@RequestMapping(value = "/support/searchaccount", method = RequestMethod.GET)
	public String searchAccount(HttpServletRequest request, Model model) {

		List<String> listKey = accountService.getRecomendedKey(1);

		for (int i = 0; i < listKey.size(); i++) {
			listKey.set(i, "\'" + listKey.get(i) + "\'");
		}
		List<Account> listAccount = new ArrayList<Account>();

		model.addAttribute("listAccount", listAccount);
		model.addAttribute("listKey", listKey);

		return "support/searchaccount";
	}

	@RequestMapping(value = "/support/getRecomendKey", method = RequestMethod.POST)
	@ResponseBody
	public List<String> getRecommendKey(HttpServletRequest request,
			HttpServletResponse response) {
		String type = request.getParameter("type");
		return accountService.getRecomendedKey(Integer.parseInt(type));
	}
	
	@RequestMapping(value = "/support/searchaccount", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getAccountResult(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Account> listAccount = null;
		
		int typeSearch = Integer.parseInt(request.getParameter("type"));
		String key = request.getParameter("keyword");
		
		listAccount = accountService.searchAccount(key, typeSearch);
		
		ModelAndView modelnview = new ModelAndView("/models/accounttable");
		
		if (listAccount == null) {
			modelnview.addObject("listAccount", new ArrayList<BalanceAmount>());
			modelnview.addObject("RESULT", "No result found");
		}else{
			modelnview.addObject("listAccount", listAccount);
			modelnview.addObject("RESULT", listAccount.size() + " result(s) found");
		}
		
		return modelnview;		
		
	}
	
}
