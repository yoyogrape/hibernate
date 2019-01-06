package com.hibernate.bean;

import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author songjn
 * @date 2019-1-5 上午09:03:22
 * @desc 多对多关系 课程实体类
 */

public class Course {

	private Long cid;
	private String cname;
	public Course() {
		super();
	}
	public Course(String cname) {
		super();
		this.cname = cname;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
