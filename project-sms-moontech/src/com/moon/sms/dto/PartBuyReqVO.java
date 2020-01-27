package com.moon.sms.dto;

import java.util.Date;

public class PartBuyReqVO {
	
	private int reqSq;
	private Date reqDt;
	private int empNo;
	private boolean reqFl;
	
	private int deSq;
	private int reqAmt;
	private int partSq;
	
	
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
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public boolean isReqFl() {
		return reqFl;
	}
	public void setReqFl(boolean reqFl) {
		this.reqFl = reqFl;
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
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	@Override
	public String toString() {
		return "PartBuyReqVO [reqSq=" + reqSq + ", reqDt=" + reqDt + ", empNo=" + empNo + ", reqFl=" + reqFl + ", deSq="
				+ deSq + ", reqAmt=" + reqAmt + ", partSq=" + partSq + "]";
	}
	
	
}
