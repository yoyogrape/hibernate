package com.hibernate.bean;

/**
 * @author songjn
 * @date 2018-12-29 ����12:07:59
 * @desc hibernate demo ʵ����
 */

public class Student {
	private Integer id;
	private String name;
	private int age;
	private Double score;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student(String name, int age, Double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}

	public String toString() {
		return "Student [age=" + age + ", id=" + id + ", name=" + name
				+ ", score=" + score + "]";
	}
	
	
}
