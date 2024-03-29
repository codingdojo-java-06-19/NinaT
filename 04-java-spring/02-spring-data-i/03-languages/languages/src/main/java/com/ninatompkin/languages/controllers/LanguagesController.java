package com.ninatompkin.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ninatompkin.languages.models.Language;
import com.ninatompkin.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService langService;
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = langService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
	
	 @RequestMapping("/languages/new")
	    public String newLanguage(@ModelAttribute("language") Language language) {
	        return "/languages/new.jsp";
	    }
	 
	 @RequestMapping(value="/languages", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/new.jsp";
	        } else {
	            langService.addLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	 
	 @RequestMapping("/languages/{id}")
	    public String show(@PathVariable("id") Long id, Model model) {
	    	Language language = langService.findLanguage(id);
	    	model.addAttribute("language", language);
	    	return "languages/show.jsp";
	    }
	 
	 @RequestMapping("/languages/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language language = langService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "/languages/edit.jsp";
	    }
	 
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/edit.jsp";
	        } else {
	            langService.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	 
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        langService.deleteLanguage(id);
	        return "redirect:/languages";
	    }

	    
}
