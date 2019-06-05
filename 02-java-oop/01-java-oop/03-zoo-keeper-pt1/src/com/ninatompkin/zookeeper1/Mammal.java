package com.ninatompkin.zookeeper1;

public class Mammal {
	protected int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println("This animal's energy level is: "+ energyLevel);
		return energyLevel;
	}
}
