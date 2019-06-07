package com.ninatompkin.web.models;

public class Cat extends Animal implements Pet {
	public Cat(String name, String breed, int weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		String str = "Your "+this.breed+" cat "+ this.name + " flopped on its belly playfully!";
		return str;
	}
}
