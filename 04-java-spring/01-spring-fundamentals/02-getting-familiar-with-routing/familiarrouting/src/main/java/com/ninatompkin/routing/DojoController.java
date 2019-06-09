package com.ninatompkin.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("/")
	public String index() {
		return "The dojo is awesome!";
	}
	
	@RequestMapping("/burbank-dojo")
	public String burbank() {
		return "Burbank Dojo is located in Southern California.";
	}
	
	@RequestMapping("/san-jose")
	public String jose() {
		return "SJ Dojo is the headquarters.";
	}
}
