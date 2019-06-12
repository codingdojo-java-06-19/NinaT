package com.ninatompkin.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	
	@RequestMapping("/")
		public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="dojo") String dojo, @RequestParam(value="favLang") String favLang, @RequestParam(value="comment") String comment) {
		System.out.println("From post..."+name+" "+dojo+" "+favLang+" "+comment);
		session.setAttribute("name", name);
		session.setAttribute("dojo", dojo);
		session.setAttribute("favLang", favLang);
		session.setAttribute("comment", comment);
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String showResult(HttpSession session, Model model) {
		String name = (String)session.getAttribute("name");
		String dojo = (String)session.getAttribute("dojo");
		String favLang = (String)session.getAttribute("favLang");
		String comment = (String)session.getAttribute("comment");
		
		model.addAttribute("name", name);
		model.addAttribute("dojo", dojo);
		model.addAttribute("favLang", favLang);
		model.addAttribute("comment",comment);
		
		return "result.jsp";
	}

}
