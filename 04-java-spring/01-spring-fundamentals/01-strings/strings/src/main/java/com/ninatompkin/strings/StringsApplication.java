package com.ninatompkin.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello Nina! How are you doing!";
	}
	
	@RequestMapping("/random")
	public String random() {
		String[] randomPhrases = {"Wow, look how smart you are!", "I'm so silly and random omg", "Whatcha gonna do with all them brains, all them brains up in your head", "Don't forget to work out today!", "Love (and coffee) is all you need.", "Hello cruel world!"};
		Random rand = new Random();
		int randNum = rand.nextInt(randomPhrases.length);
		return randomPhrases[randNum];
	}
	

}
