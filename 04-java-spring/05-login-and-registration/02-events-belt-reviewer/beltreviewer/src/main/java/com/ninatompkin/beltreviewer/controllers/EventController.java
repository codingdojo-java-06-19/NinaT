package com.ninatompkin.beltreviewer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {
	
	@RequestMapping("/events")
	public String showDashboard() {
		return "events/showEvents.jsp";
	}
	
	@RequestMapping("/events/2")
	public String showOneEvent() {
		return "events/showEvent.jsp";
	}
	
	@RequestMapping("/events/3/edit")
	public String editOneEvent() {
		return "events/editEvent.jsp";
	}
		
}
