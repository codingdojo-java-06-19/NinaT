package com.ninatompkin.objmaster1;

public class Ninja extends Human {
	
	public Ninja() {
		this.stealth = 10;
	}
	
	
	public void steal(Human targetHuman) {
		targetHuman.health -= this.stealth;
		this.health += this.stealth;
		
	}
	
	public void runAway() {
		this.health -= 10;
	}

}
