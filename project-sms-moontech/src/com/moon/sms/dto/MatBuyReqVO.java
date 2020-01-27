package com.moon.sms.dto;

import java.sql.Date;

public class MatBuyReqVO {
	
	private int reqSq;
	private Date reqDt;
	private boolean reqFl;
	private int empNo;
	
	private int deSq;
	private int reqAmt;
	private int matNo;
	
	
	public int getReqSq() {
		return reqSq;
	}
	public void setReqSq(int reqSq) {
		this.reqSq = reqSq;
	}
	public Date getReqDt() {
		return reqDt;
	}
	public void setReqDt(Date reqDt) {
		this.reqDt = reqDt;
	}
	public boolean isReqFl() {
		return reqFl;
	}
	public void setReqFl(boolean reqFl) {
		this.reqFl = reqFl;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getReqAmt() {
		return reqAmt;
	}
	public void setReqAmt(int reqAmt) {
		this.reqAmt = reqAmt;
	}
	public int getMatNo() {
		return matNo;
	}
	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}
	@Override
	public String toString() {
		return "MatBuyReqVO [reqSq=" + reqSq + ", reqDt=" + reqDt + ", reqFl=" + reqFl + ", empNo=" + empNo + ", deSq="
				+ deSq + ", reqAmt=" + reqAmt + ", matNo=" + matNo + "]";
	}
	
	
	
}
