package com.ninatompkin.web.models;

public class Player {
	private String firstName;
	private String lastName;
	private int age;
	
	//This method is for setting any default values if we want something to be created without any passed in content;
	public Player() {
	}
	
	//This method is for taking in variables and creating a new Player with those variables
	public Player(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	

	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

