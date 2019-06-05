package com.ninatompkin.objmaster1;

public class Wizard extends Human {
	
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	public void fireball(Human humanObject) {
		humanObject.health -= (this.intelligence*3);
	}
	
	public void heal(Human tobeHealed) {
		tobeHealed.health += this.intelligence;
	}

}
