package com.csc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorPageController {

	@RequestMapping(value = {"/404"}, method = { RequestMethod.GET, RequestMethod.POST })
	public String error404(Exception e) {
		return "404";
	}
	
	@RequestMapping(value = "/500", method = { RequestMethod.GET, RequestMethod.POST })
	public String error500(Exception e) {
		return "500";
	}
}
