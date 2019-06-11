package com.ninatompkin.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CountController {
	
	@RequestMapping("/")
		public String index(HttpSession session, Model model) {
		
			//If there's nothing in session called "count" yet, then let's start counting!
			if (session.getAttribute("count") == null) {
				//Put a variable called "count" into session...
				session.setAttribute("count", 0);
				//...and for the sake of our print, we'll pull it back out so we can see what count is registered when we visit the page.
				Integer currCount = (Integer)session.getAttribute("count");
				System.out.println("We are starting the count! Our count is at "+currCount+".");
			}
			//Now that we've initialized our count...if there is something in session called count... 
			Integer currCount = (Integer)session.getAttribute("count");
			//Then we increment. This happens each time we render this page, even on our first visit. This means that our first visit has a page view of "1."
			currCount++;
			session.setAttribute("count", currCount);
			//then let's print out what our count is.
			System.out.println("Our count is at "+currCount+".");
			
			return "index.jsp";
	}
	
	@RequestMapping("/counter")
		public String counter(HttpSession session, Model model) {
			
			//Look in session for our attribute called count.
			Integer currCount = (Integer)session.getAttribute("count");
			
			//If there's nothing called count, then we don't want our display to show "you have visited times"...
			//We wanna show "you've visited 0 times!"
			if (currCount == null) {
				model.addAttribute("count", 0);
			}
			
			//Otherwise, if there is a value for count, then we want to display it in our view.
			//To do so, we'll add it to our model.
			else {
				model.addAttribute("count", currCount);
			}
			return "counter.jsp";
	}
	
	
}
