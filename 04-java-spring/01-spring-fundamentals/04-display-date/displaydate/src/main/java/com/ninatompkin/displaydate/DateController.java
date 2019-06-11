package com.ninatompkin.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class DateController {

	@RequestMapping("/")
	public String home(Model model) {
		System.out.println("I'm the index controller!");
		
		String path = "http://localhost:8080/";
		model.addAttribute("path", path);
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy");
		String formattedDate = format.format(date);
		
		model.addAttribute("date",formattedDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		String formattedTime = format.format(date);
		
		model.addAttribute("time", formattedTime);
		return "time.jsp";
	}
}
