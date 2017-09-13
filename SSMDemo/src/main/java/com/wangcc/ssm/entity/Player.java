package com.wangcc.ssm.entity;

import java.io.Serializable;

public class Player implements Serializable{
	private String name;
	private Integer id;
	private int age;
	private int teamId;
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public Player() {}
	
	public Player(Integer id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	public Player(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Player(String name, Integer id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
