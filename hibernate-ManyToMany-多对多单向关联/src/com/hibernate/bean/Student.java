package com.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author songjn
 * @date 2019-1-5 上午09:01:34
 * @desc 多对多关联学生实体
 */

public class Student {
	private Long sid;
	private String sname;
	private Set<Course> courses;
	public Student() {
		courses=new HashSet<Course>();
	}
	public Student(String name) {
		this();
		this.sname = name;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [courses=" + courses + ", sid=" + sid + ", sname="
				+ sname + "]";
	}

	
}
