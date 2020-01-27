package com.moon.sms.dto;

import java.sql.Date;


public class MatInVO {
	private int inSq;	
	private Date inDT;
	private int empNo;
	private int purSq;	
	
	private int deSq;
	private int matSq;
	private int inAmt;
	public int getInSq() {
		return inSq;
	}
	public void setInSq(int inSq) {
		this.inSq = inSq;
	}
	public Date getInDT() {
		return inDT;
	}
	public void setInDT(Date inDT) {
		this.inDT = inDT;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getPurSq() {
		return purSq;
	}
	public void setPurSq(int purSq) {
		this.purSq = purSq;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getMatSq() {
		return matSq;
	}
	public void setMatSq(int matSq) {
		this.matSq = matSq;
	}
	public int getInAmt() {
		return inAmt;
	}
	public void setInAmt(int inAmt) {
		this.inAmt = inAmt;
	}
	
	@Override
	public String toString() {
		return "MatInVO [inSq=" + inSq + ", inDT=" + inDT + ", empNo=" + empNo + ", purSq=" + purSq + ", deSq=" + deSq
				+ ", matSq=" + matSq + ", inAmt=" + inAmt + "]";
	}
	
	
	
	
}
