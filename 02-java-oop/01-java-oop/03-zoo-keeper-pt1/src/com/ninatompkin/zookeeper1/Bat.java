package com.ninatompkin.zookeeper1;

public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void healthCheck() {
		if (this.energyLevel < 0){
			System.out.println("This bat - he dead.");
		}
		else {
			System.out.println("This bat's still got fight in him left!");
		}
	}
	
	public void fly() {
		System.out.println("*Fwap Fwap Fwap* SCREEEEEECH");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("He's got Jimmy! Why God, Whyyyyyyy!!?!!?!");
		this.energyLevel +=25;
	}
	
	public void attackTown() {
		System.out.println("Burnintating the countryside...TROGDOR!");
		this.energyLevel -= 100;
	}
	
}
