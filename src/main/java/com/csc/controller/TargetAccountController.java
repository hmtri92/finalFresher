package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.service.FundService;

@Controller
@SessionAttributes({"username", "role", "id" })
public class TargetAccountController {
	
	@Autowired
	FundService fundService;
	
	@RequestMapping (value = "/user/viewTargetAccount", method = RequestMethod.GET)
	public ModelAndView viewTargetAccount(@ModelAttribute( value = "id") String id, 
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("users/targetAccount");
		
		List<TargetAccount> targetAccounts = fundService.getListTargetByAccountOwnerId(id);
		
		if (targetAccounts != null) {
			model.addObject("targetAccounts", targetAccounts);
		}
		
		return model;
	}
	
	@RequestMapping (value = "/user/addTargetAccount", method = RequestMethod.POST)
	@ResponseBody
	public StateResult addTargetAccount(@ModelAttribute( value = "id") String id,
			@RequestParam( value = "accountId") String idaccountTarget, @RequestParam( value = "name") String name,
			HttpServletRequest request, HttpServletResponse response) {
		
		return fundService.addTargetAccount(id, idaccountTarget, name);
		
	}
	
	@RequestMapping (value = "/user/modifyTargetAccount", method = RequestMethod.POST)
	@ResponseBody
	public StateResult modifyTargetAccount(@RequestParam( value = "idTarget") String id,
			@RequestParam( value = "idAccountTarget") String idAccountTarget, @RequestParam( value = "name") String name,
			HttpServletRequest request, HttpServletResponse response) {
		return fundService.modifyTarget(id, idAccountTarget, name);
	}
	
	@RequestMapping (value = "/user/deleteTargetAccount", method = RequestMethod.POST)
	@ResponseBody
	public StateResult deleteTargetAccount(@RequestParam( value = "idTarget") String id,
			HttpServletRequest request, HttpServletResponse response) {
		return fundService.deleteTarget(id);
	}

}
