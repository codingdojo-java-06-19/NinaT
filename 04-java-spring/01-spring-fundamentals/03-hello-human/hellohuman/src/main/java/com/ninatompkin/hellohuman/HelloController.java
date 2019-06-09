package com.ninatompkin.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String greet(@RequestParam(value="first", required=false) String firstInput, @RequestParam(value="last", required=false) String lastInput ) {
		if (firstInput == null && lastInput == null) {
			//If the user didn't provide either name...
			return "Hello Human! Welcome to SpringBoot!";
			//url to access this: localhost:8080
		}
		else if (firstInput != null && lastInput == null) {
			//If the user provided just the first name...
			return "Hello "+firstInput+"! Welcome to SpringBoot!";
			//url to access this: localhost:8080/?first=Nina
		}
		else if (firstInput == null && lastInput != null) {
			//If the user provided just the last name...
			return "Hello my dear "+lastInput+". How wonderful to see you.";
			//url to access this: localhost:8080/?last=Tompkin
		}
		//If the user provided both names...
		else {
			return "Hello "+firstInput+" "+lastInput+"! Welcome to SpringBoot!";
			//url to access this: localhost:8080/?first=Nina&last=Tompkin
		}
		
	}
	

}
