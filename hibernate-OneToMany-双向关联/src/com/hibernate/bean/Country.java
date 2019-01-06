package com.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author songjn
 * @date 2019-1-3 下午10:50:45
 * @desc 国家（一方），维护关系方
 */

public class Country {
	
	private Long cid;
	private String cname;
	private Set<Minister> ministers;
	
	public Country() {
		ministers=new HashSet<Minister>();
	}

	public Country(String cname) {
		this();
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

	public Set<Minister> getMinisters() {
		return ministers;
	}

	public void setMinisters(Set<Minister> ministers) {
		this.ministers = ministers;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", ministers="
				+ ministers + "]";
	}
	
	
}
