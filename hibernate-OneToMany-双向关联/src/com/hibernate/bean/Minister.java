package com.hibernate.bean;

/**
 * @author songjn
 * @date 2019-1-3 下午10:51:37
 * @desc 部长（多方）
 */

public class Minister {
	
	private Long mid;
	private String mname;
	private Country country;
	
	public Minister() {
		super();
	}
	public Minister(String mname) {
		super();
		this.mname = mname;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	//双向关联的时候toString()时，只要求一方可以输出对方即可。
	//若双方都输出对方，会形成递归，会出错。
	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + "]";
	}

	

}
