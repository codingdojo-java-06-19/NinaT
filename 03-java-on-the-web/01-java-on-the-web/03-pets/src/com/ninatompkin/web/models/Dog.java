package com.ninatompkin.web.models;

public class Dog extends Animal implements Pet {
	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		String str = "";
		if (this.weight < 30) {
			str = this.name + " hopped into your lap and cuddled you!";
		}
		else {
			str = this.name + " came up and cuddled next to you!";
		}
		return str;
	}

}
