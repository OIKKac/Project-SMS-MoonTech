package com.moon.sms.dto;


public class DeptVO {
	
	private int deptSq;
	private String deptNm;

	public int getDeptSq() {
		return deptSq;
	}
	public void setDeptSq(int deptSq) {
		this.deptSq = deptSq;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	@Override
	public String toString() {
		return "DeptVO [deptSq=" + deptSq +  ", deptNm=" + deptNm + "]";
	}
	
	
	
}
