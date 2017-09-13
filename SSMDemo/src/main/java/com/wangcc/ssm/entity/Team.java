package com.wangcc.ssm.entity;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable{
	private String teamName;
	private String location;
	private Integer id;
	private Coach coach;
	private List<Player> players;
	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public Team () {}

	public Team(String teamName, String location, Coach coach, List<Player> players, float allSalary) {
		super();
		this.teamName = teamName;
		this.location = location;
		this.coach = coach;
		this.players = players;
		this.allSalary = allSalary;
	}


	public Team(String teamName, String location, float allSalary,Coach coach) {
		super();
		this.teamName = teamName;
		this.location = location;
		this.allSalary = allSalary;
		this.coach=coach;
	}


	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	private float allSalary;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public float getAllSalary() {
		return allSalary;
	}
	public void setAllSalary(float allSalary) {
		this.allSalary = allSalary;
	}
	
}
