package com.ninatompkin.objmaster1;

public class HumanTest {

	public static void main(String[] args) {
		Human nina = new Human();
		Human dimitar = new Human();
		dimitar.displayHealth();
		nina.attack(dimitar);
		dimitar.displayHealth();

		Ninja naruto = new Ninja();
		Samurai champloo = new Samurai();
		Wizard usador = new Wizard();
		Samurai jack = new Samurai();
		
		//Start by confirming that everyone has the amount of health they should.
		nina.displayHealth();
		naruto.displayHealth();
		usador.displayHealth();
		jack.displayHealth();
		
		//Kill her.
		champloo.deathBlow(nina);
		nina.displayHealth();
		
		//Heal her.
		usador.heal(nina);
		nina.displayHealth();
		
		//Grill 'im
		usador.fireball(naruto);
		
		//Steal from her.
		naruto.steal(nina);
		nina.displayHealth();
		
		//Check how you're doing then run away and check again
		naruto.displayHealth();
		naruto.runAway();
		naruto.displayHealth();
		
		//Check how you're doing then meditate and check again
		champloo.displayHealth();
		champloo.meditate();
		champloo.displayHealth();
		
		System.out.println(champloo.howMany());
		
	}

}
