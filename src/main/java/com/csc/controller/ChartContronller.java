package com.csc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"username", "role", "id" })
public class ChartContronller {
	@RequestMapping(value = "admin/demoChart", method = RequestMethod.GET)
	public String goChart() {
		return "admin/demoChart";
	}
	
	@RequestMapping(value = "admin/demoChart2", method = RequestMethod.GET)
	public String goChart2() {
		return "admin/chart_tri";
	}
}
