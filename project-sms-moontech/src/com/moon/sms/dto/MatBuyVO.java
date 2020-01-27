package com.moon.sms.dto;

import java.sql.Date;

public class MatBuyVO {
	private int buySq;
	private Date buyDt;
	private int empNo;
	private int purSq;
	
	private int deSq;	
	private int buyAmt;
	private int matSq;
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
	public int getMatSq() {
		return matSq;
	}
	public void setMatSq(int matSq) {
		this.matSq = matSq;
	}
	
	@Override
	public String toString() {
		return "MatBuyVO [buySq=" + buySq + ", buyDt=" + buyDt + ", empNo=" + empNo + ", purSq=" + purSq + ", deSq="
				+ deSq + ", buyAmt=" + buyAmt + ", matSq=" + matSq + "]";
	}
	
	

	
	
}
