package com.ninatompkin.zookeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("The gorilla has thrown something.");
		this.energyLevel -= 5;	
	}
	
	public void eatBananas() {
		System.out.println("The gorilla's hunger has been satisfied.");
		this.energyLevel += 5;
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree. Phew!");
		this.energyLevel -= 10;
	}

}
