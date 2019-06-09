package com.ninatompkin.web.models;
import java.util.ArrayList;



public class Roster {
	//A roster needs to be able to loop through all of the teams and pull out their attributes
	private static ArrayList<Team> teams = new ArrayList<Team>();

	public Roster() {
		
	}
	
	public void addTeam(String teamName) {
		Team team = new Team(teamName);
		this.teams.add(teams);
	}
	
}
