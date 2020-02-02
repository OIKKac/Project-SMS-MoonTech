package com.moon.sms.dto;

import java.sql.Date;

public class MatInVO {
	private int inSq;	
	private Date inDt;
	private int empNo;
	private String empNm;
	private int purSq;	
	private String purNm;	
	
	private int deSq;
	private int matSq;
	private int inAmt;
	private int cntDe;
	public int getInSq() {
		return inSq;
	}
	public void setInSq(int inSq) {
		this.inSq = inSq;
	}
	public Date getInDt() {
		return inDt;
	}
	public void setInDt(Date inDt) {
		this.inDt = inDt;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public int getPurSq() {
		return purSq;
	}
	public void setPurSq(int purSq) {
		this.purSq = purSq;
	}
	public String getPurNm() {
		return purNm;
	}
	public void setPurNm(String purNm) {
		this.purNm = purNm;
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
	public int getCntDe() {
		return cntDe;
	}
	public void setCntDe(int cntDe) {
		this.cntDe = cntDe;
	}
	@Override
	public String toString() {
		return "MatInVO [inSq=" + inSq + ", inDt=" + inDt + ", empNo=" + empNo + ", empNm=" + empNm + ", purSq=" + purSq
				+ ", purNm=" + purNm + ", deSq=" + deSq + ", matSq=" + matSq + ", inAmt=" + inAmt + ", cntDe=" + cntDe
				+ "]";
	}
	
	
	
}
