package com.ninatompkin.driverslicense.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ninatompkin.driverslicense.dojosninjas.models.Dojo;
import com.ninatompkin.driverslicense.dojosninjas.models.Ninja;
import com.ninatompkin.driverslicense.dojosninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	@RequestMapping("/new")
	public String addDojo() {
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors: "+result);
			return "newDojo.jsp";
		}
		else {
			dojoService.create(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findOne(id);
		if(dojo==null) {
			return "redirect:/ninjas/new";
		}
			else {
				List<Ninja> ninjas = dojo.getNinjas();
				model.addAttribute("dojo", dojo);
				model.addAttribute("ninjas", ninjas);
				return "showDojo.jsp";
			}
	}
}
