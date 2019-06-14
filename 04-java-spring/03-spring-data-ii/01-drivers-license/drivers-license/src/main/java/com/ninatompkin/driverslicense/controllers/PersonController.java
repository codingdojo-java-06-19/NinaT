package com.ninatompkin.driverslicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ninatompkin.driverslicense.models.Person;
import com.ninatompkin.driverslicense.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/new")
	public String newPerson() {
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
			System.out.println("Hello from the new person page!");
	        if (result.hasErrors()) {
	        	System.out.println("Oops, there were errors with your post. "+result);
	            return "newPerson.jsp";
	        } else {
	        	System.out.println("Adding "+person+" to our database!");
	            personService.addPerson(person);
	            return "redirect:/persons/"+person.getId();
	        }
	    }
	
	 @RequestMapping("/{id}")
	    public String show(@PathVariable("id") Long id, Model model) {
	    	Person person = personService.findPerson(id);
	    	if(person==null) {
	    		return "redirect:/persons/new";
	    	}
	    	else {
		    	model.addAttribute("person", person);
		    	return "show.jsp";
	    	}
	    }
}
