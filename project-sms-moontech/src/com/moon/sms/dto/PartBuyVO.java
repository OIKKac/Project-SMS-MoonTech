package com.moon.sms.dto;

import java.util.Date;

public class PartBuyVO {
	
	
	private int buySq;
	private Date buyDt;
	private int empNo;
	private int purSq;
	
	private int reqSq;
	
	private int deSq;
	private int buyAmt;
	private int partSq;
	
	public int getBuySq() {
		return buySq;
	}
	public void setBuySq(int buySq) {
		this.buySq = buySq;
	}
	public Date getBuyDt() {
		return buyDt;
	}
	public void setBuyDt(Date buyDt) {
		this.buyDt = buyDt;
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
	public int getReqSq() {
		return reqSq;
	}
	public void setReqSq(int reqSq) {
		this.reqSq = reqSq;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getBuyAmt() {
		return buyAmt;
	}
	public void setBuyAmt(int buyAmt) {
		this.buyAmt = buyAmt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	@Override
	public String toString() {
		return "PartBuyVO [buySq=" + buySq + ", buyDt=" + buyDt + ", empNo=" + empNo + ", purSq=" + purSq + ", reqSq="
				+ reqSq + ", deSq=" + deSq + ", buyAmt=" + buyAmt + ", partSq=" + partSq + "]";
	}
	
	
	
	
	
}
