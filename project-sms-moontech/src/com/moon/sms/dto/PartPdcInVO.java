package com.moon.sms.dto;

public class PartPdcInVO {
	
	private int inSq;
	private int inDt;
	private int empNo;
	
	private int deSq;
	private int inAmt;
	private int partSq;
	
	
	public int getInSq() {
		return inSq;
	}
	public void setInSq(int inSq) {
		this.inSq = inSq;
	}
	public int getInDt() {
		return inDt;
	}
	public void setInDt(int inDt) {
		this.inDt = inDt;
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
	public int getInAmt() {
		return inAmt;
	}
	public void setInAmt(int inAmt) {
		this.inAmt = inAmt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	@Override
	public String toString() {
		return "PartPdcIn [inSq=" + inSq + ", inDt=" + inDt + ", empNo=" + empNo + ", deSq=" + deSq + ", inAmt=" + inAmt
				+ ", partSq=" + partSq + "]";
	}
	
	
}
