package com.wangcc.ssm.entity;

import java.io.Serializable;

public class Coach implements
Serializable{
	private String name;
	private Integer id;
	private int age;
	public Coach() {}
	public Coach(String name, int age, float salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	private float salary;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}

}
