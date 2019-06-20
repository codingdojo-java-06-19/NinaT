package com.ninatompkin.beltreviewer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginRegController {

	@RequestMapping("/")
	public String goHome() {
		return "loginReg.jsp";
	}
}
