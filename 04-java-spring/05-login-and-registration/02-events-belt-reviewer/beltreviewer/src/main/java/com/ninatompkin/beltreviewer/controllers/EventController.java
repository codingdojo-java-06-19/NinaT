package com.ninatompkin.beltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ninatompkin.beltreviewer.models.Event;
import com.ninatompkin.beltreviewer.models.Message;
import com.ninatompkin.beltreviewer.models.User;
import com.ninatompkin.beltreviewer.services.ApiService;

@Controller
@RequestMapping("/events")
public class EventController {
	private final ApiService apiService;
	
	public EventController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/events")
	public String goToDashboard() {
		return "redirect:events/";
	}
	
	@RequestMapping("")
	public String showDashboard(@ModelAttribute("event") Event event, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
		//First, check if the user is properly logged in (i.e. if there is an id in session)
		//If there isn't...
		Long userId = (Long)session.getAttribute("userId");
		System.out.println(userId);
		if(session.getAttribute("userId")==null) {
			//Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
			return "redirect:/";
		}
		//But if there is an id in session...
//		Long userId = (Long)session.getAttribute("userId");
		//Find the user...
		User loggedInUser = apiService.findUserById(userId);
		//...and add them to the model.
		model.addAttribute("user", loggedInUser);
		
		//Grab all of the events that match the users' state and add them to the model...
		List<Event> eventsInState = apiService.eventsInYourState(userId);
		model.addAttribute("eventsInState", eventsInState);
		
		//...as well as all of the events not in the users' state
		List<Event> eventsNotInState = apiService.eventsNotInYourState(userId);
		model.addAttribute("eventsNotInState", eventsNotInState);
		
		return "events/showEvents.jsp";
	}
	
	@PostMapping("/new")
	public String addEvent(@ModelAttribute("event") Event event, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("eventError", "Event could not be created. Please try again.");
			return "redirect:/events";
		}
		apiService.createOrUpdateEvent(event);
		redirectAttributes.addFlashAttribute("eventSuccess", "You've successfully added an event!");
		return "redirect:/events";
	}
	
	@RequestMapping("/{id}")
	public String showOneEvent(HttpSession session, RedirectAttributes redirectAttributes, @PathVariable("id") Long eventId, Model model){
		//First, check if the user is properly logged in (i.e. if there is an id in session)
		//If there isn't...
		if(session.getAttribute("userId")==null) {
			//Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
			return "redirect:/";
		}
		//But if there is an id in session...
		//For this page we'll need the event in our model...
		Event thisEvent = apiService.findThisEvent(eventId);
		model.addAttribute("event", thisEvent);
		
		//...along with the info about our logged in user....
		Long userId = (Long)session.getAttribute("userId");
		User loggedInUser = apiService.findUserById(userId);
		model.addAttribute("loggedInUser", loggedInUser);
		
		//We'll also need to view all of the messages that have been added to this event
		List<Message> messages = apiService.findMessagesForThisEvent(eventId);
		model.addAttribute("messages", messages);
		
		return "events/showEvent.jsp";
	}
	
	@PostMapping("/newMessage/{id}")
	public String newMessage(@PathVariable("id") Long eventId, @RequestParam("author") Long authorId, @RequestParam("content") String content, RedirectAttributes redirectAttribute) {
		if(content=="") {
			redirectAttribute.addFlashAttribute("error", "Your post cannot be blank.");
			return "redirect:/events/"+eventId;
		}
		apiService.createMessage(content, authorId, eventId);
		return "redirect:/events/"+eventId;
	}
	
	@RequestMapping("/{id}/edit")
	public String editOneEvent(@ModelAttribute("event") Event event, @PathVariable("id") Long eventId, HttpSession session, RedirectAttributes redirectAttributes, Model model){
		//First, check if the user is properly logged in (i.e. if there is an id in session)
		//If there isn't...
		System.out.println("Our eventId is "+eventId);
		if(session.getAttribute("userId")==null) {
			//Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
			return "redirect:/";
		}
		//Then, check if the event they selected is even available...
		if(eventId==null) {
			//if it isn't...return a "404"
			return "error.jsp";
		}
		//Otherwise, let's find the event and display it's info in our form fields.
		Event thisEvent = apiService.findThisEvent(eventId);
		model.addAttribute("event", thisEvent);
		return "events/editEvent.jsp";
	}
	
	@PostMapping("/updateEvent")
	public String updateEvent(@ModelAttribute("event") Event event, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("eventError", "Event could not be updated. Please try again.");
			return "redirect:/events/";
		}
		apiService.createOrUpdateEvent(event);
		return "redirect:/events/"+event.getId();
	}
	
	@PostMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long eventId) {
		apiService.deleteThisEvent(eventId);
		return "redirect:/events";
	}
	
	@RequestMapping("/{id}/join")
	public String joinEvent(@PathVariable("id") Long eventId, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		apiService.joinThisEvent(eventId, userId);
		return "redirect:/events";
	}
	
	@RequestMapping("/{id}/cancel")
	public String cancelAttendance(@PathVariable("id") Long eventId, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		apiService.stopGoingToThisEvent(eventId, userId);
		return "redirect:/events";
		
	}
		
}
