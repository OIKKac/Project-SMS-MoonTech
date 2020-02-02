package com.moon.sms.dto;

import java.util.Date;

public class PartBuyReqVO {
	
	private int reqSq;
	private Date reqDt;
	private int empNo;
	private int reqFl;
	private String empNm;
	private int cnt;
	
	//tb_part_buy_req_de
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
	public int getReqFl() {
		return reqFl;
	}
	public void setReqFl(int reqFl) {
		this.reqFl = reqFl;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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
		return "PartBuyReqVO [reqSq=" + reqSq + ", reqDt=" + reqDt + ", empNo=" + empNo + ", reqFl=" + reqFl
				+ ", empNm=" + empNm + ", cnt=" + cnt + ", deSq=" + deSq + ", reqAmt=" + reqAmt + ", partSq=" + partSq
				+ "]";
	}
	
	
}
