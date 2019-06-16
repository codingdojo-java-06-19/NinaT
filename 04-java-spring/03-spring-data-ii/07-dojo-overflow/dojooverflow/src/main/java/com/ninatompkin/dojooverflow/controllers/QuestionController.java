package com.ninatompkin.dojooverflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {

	@RequestMapping("/dashboard")
	public String showDashboard() {
		return "questions/dashboard.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion() {
		return "questions/new.jsp";
	}
	
	@RequestMapping("/1")
	public String showQuestion() {
		return "questions/show.jsp";
	}
}
