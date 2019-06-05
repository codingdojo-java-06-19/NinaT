package com.ninatompkin.objmaster1;

public class Human {
	protected int strength;
	protected int stealth;
	protected int intelligence;
	protected int health;
	
	public Human() {
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health = 100;
	}
	
	public void attack(Human humanTarget) {
		System.out.println("That's gotta hurt! They delivered a devastating blow causing "+this.strength+" points in damage!");
		humanTarget.health -= this.strength;
	}
	
	public void displayHealth() {
		System.out.println("This lil guy or gal currently has "+health+" health.");
	}

}
