package com.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author songjn
 * @date 2019-1-4 下午09:23:29
 * @desc 自关联实体类
 */

public class NewsLabel {
	private Long id;
	private String name;
	private String desc;
	private NewsLabel parent;
	private Set<NewsLabel> childrens;

	public NewsLabel() {
		childrens=new HashSet<NewsLabel>();
	}

	public NewsLabel(String name, String desc) {
		this();
		this.name = name;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public NewsLabel getParent() {
		return parent;
	}

	public void setParent(NewsLabel parent) {
		this.parent = parent;
	}

	public Set<NewsLabel> getChildrens() {
		return childrens;
	}

	public void setChildrens(Set<NewsLabel> childrens) {
		this.childrens = childrens;
	}

	@Override
	public String toString() {
		return "NewsLabel [childrens=" + childrens + ", desc=" + desc + ", id="
				+ id + ", name=" + name + "]";
	}

}
