package com.csc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csc.bean.AdminReponse;
import com.csc.service.FundService;

@Controller
public class InfoHomeAdminController {
	
	@Autowired
	FundService fundService;

	@RequestMapping (value = "/infoHomeAdmin", method = RequestMethod.POST)
	@ResponseBody
	public AdminReponse get() {
		AdminReponse result = fundService.getHomeAdminInfo();
		return result;
	}
}
