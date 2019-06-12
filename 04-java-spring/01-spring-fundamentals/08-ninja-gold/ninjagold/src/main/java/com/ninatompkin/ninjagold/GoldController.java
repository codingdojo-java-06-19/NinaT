package com.ninatompkin.ninjagold;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/gold")
public class GoldController {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold")==null) {
			System.out.println("No gold detected...intializing gold");
			Integer gold = 0;
			session.setAttribute("gold", gold);
			model.addAttribute("gold", gold);
		}
		Integer gold = (Integer)session.getAttribute("gold");
		System.out.println("Our current gold count is "+ gold);
		return "index.jsp";
	}
	
	@RequestMapping(value="/addGold", method=RequestMethod.POST)
	public String addGold(@RequestParam(value="location") String location) {
		if (location.equals("farm")) {
			System.out.println("They selected farm!");
		}
		else if (location.equals("cave")) {
			System.out.println("They selected cave!");
		}
		else if (location.equals("house")){
			System.out.println("They selected house!");
		}
		else {
			System.out.println("They selected casino!");
		}
		return "redirect:/gold";
	}
}
