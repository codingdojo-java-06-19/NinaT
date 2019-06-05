package com.ninatompkin.objmaster1;

public class Samurai extends Human{
	private static int counter = 0;

	public Samurai(){
		this.health = 200;
		counter++;
	}
	
	public void deathBlow(Human humanObject) {
		humanObject.health = 0;
		this.health = this.health/2;
	}
	
	public void meditate() {
		this.health += this.health/2;
	}
	
	public int howMany() {
		return counter;
	}
}
