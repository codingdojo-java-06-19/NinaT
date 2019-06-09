package com.ninatompkin.web.models;
import java.util.ArrayList;

public class Team {
	private String teamName;
	//We need to ultimately loop through a list of Players for each team...which means each Team needs to keep track of an array of Players
	private ArrayList<Player> players = new ArrayList<Player>();
	
	

	private static int newid = 0;
	
	public Team() {
	}
	
	public Team(String name) {
		this.teamName = name;
	}
	
	public String getName() {
		return this.teamName;
	}
	
	public void setName(String name) {
		this.teamName = name;
	}
	
	public void addPlayer(String firstName, String lastName, Integer age) {
		Player player = new Player(firstName, lastName, age);
		this.players.add(player);
	}
	
}
