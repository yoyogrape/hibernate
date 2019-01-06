package com.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author songjn
 * @date 2019-1-3 下午10:50:45
 * @desc 国家（一方）
 */

public class Country {

	private Long cid;
	private String cname;

	public Country(String cname) {
		this.cname = cname;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
}
