package com.hibernate.bean;

/**
 * @author songjn
 * @date 2019-1-3 下午10:51:37
 * @desc 部长（多方）
 */

public class Minister {
	
	private Long mid;
	private String mname;
	
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
	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + "]";
	}

	

}
