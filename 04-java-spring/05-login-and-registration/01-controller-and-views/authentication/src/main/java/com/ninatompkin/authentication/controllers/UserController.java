package com.ninatompkin.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ninatompkin.authentication.models.User;
import com.ninatompkin.authentication.services.UserService;

@Controller
public class UserController {
		private final UserService userService;
 
 public UserController(UserService userService) {
     this.userService = userService;
 }
 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 // if result has errors, return the registration page (don't worry about validations just now)
	 if(result.hasErrors()) {
		 //errors go here!!
		 return "registrationPage.jsp";
	 }
	 // else, save the user in the database...
	 User newUser = userService.registerUser(user);
	 //save the user id in session...
	 session.setAttribute("userId", newUser.getId());
	 //and redirect them to the /home routes
	 return "redirect:/home";
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	// if the user is authenticated...
	 if(userService.authenticateUser(email, password)) {
		 //save their user id in session
		 User user = userService.findByEmail(email);
		 session.setAttribute("userId", user.getId());
		 return "redirect:/home";
     }
    // else, add error messages...
	 model.addAttribute("error", "Invalid Credentials. Pleae try again.");
	//...and return the login page
	return "redirect:/login";
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
	 //First, check whether or not our user is logged in!
	 if(session.getAttribute("userId")==null) {
		 model.addAttribute("error","You are not logged in. Please login or register to access home.");
		 System.out.println("Uh uh girlfriend.");
		 return "redirect:/login";
	 }
	 // get user from session...
	 Long userId = (Long)session.getAttribute("userId");
	 User thisUser = userService.findUserById(userId);
	 //save them in the model...
     model.addAttribute("user", thisUser);
	 //...and return the home page
	 return "homePage.jsp";
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     // invalidate session
	 session.invalidate();
     // redirect to login page
	 return "redirect:/login";
 }
}