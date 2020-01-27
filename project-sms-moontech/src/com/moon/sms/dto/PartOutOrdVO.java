package com.moon.sms.dto;

import java.util.Date;

public class PartOutOrdVO {
	
	private int ordSq;
	private Date ordDt;
	private int empNo;
	private int selSq;
	private boolean ordFl;
	
	
	private int deSq;
	private int ordAmt;
	private int partSq;
	public int getOrdSq() {
		return ordSq;
	}
	public void setOrdSq(int ordSq) {
		this.ordSq = ordSq;
	}
	public Date getOrdDt() {
		return ordDt;
	}
	public void setOrdDt(Date ordDt) {
		this.ordDt = ordDt;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getSelSq() {
		return selSq;
	}
	public void setSelSq(int selSq) {
		this.selSq = selSq;
	}
	public boolean isOrdFl() {
		return ordFl;
	}
	public void setOrdFl(boolean ordFl) {
		this.ordFl = ordFl;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getOrdAmt() {
		return ordAmt;
	}
	public void setOrdAmt(int ordAmt) {
		this.ordAmt = ordAmt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	@Override
	public String toString() {
		return "PartOutOrdVO [ordSq=" + ordSq + ", ordDt=" + ordDt + ", empNo=" + empNo + ", selSq=" + selSq
				+ ", ordFl=" + ordFl + ", deSq=" + deSq + ", ordAmt=" + ordAmt + ", partSq=" + partSq + "]";
	}
	
	
	
	
	
	
}
