package com.ninatompkin.code;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class CodeController {

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/guess", method=RequestMethod.POST)
	public String flashMessages(@RequestParam(value="codeInput") String codeGuess, RedirectAttributes redirectAttributes) {
		if (codeGuess.equals("bushido")) {
			System.out.println("My god, they got it right!");
			return "redirect:/code";
		}
		System.out.println("Mwhaha. Still haven't cracked our code.");
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}

	
	@RequestMapping("/code")
	public String code(HttpSession session) {
		return "code.jsp";
	}
}
