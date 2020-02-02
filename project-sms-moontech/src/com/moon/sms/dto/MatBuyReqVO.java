package com.moon.sms.dto;

import java.sql.Date;

public class MatBuyReqVO {
	
	private int reqSq;
	private Date reqDt;
	private int reqFl;
	private int empNo;
	private String empNm;
	private int cnt;
	
	// tb_mat_buy_req_de
	private int deSq;
	private int reqAmt;
	private int matNo;
	private String matNm;
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
	public int getReqFl() {
		return reqFl;
	}
	public void setReqFl(int reqFl) {
		this.reqFl = reqFl;
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
	public int getMatNo() {
		return matNo;
	}
	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}
	public String getMatNm() {
		return matNm;
	}
	public void setMatNm(String matNm) {
		this.matNm = matNm;
	}
	@Override
	public String toString() {
		return "MatBuyReqVO [reqSq=" + reqSq + ", reqDt=" + reqDt + ", reqFl=" + reqFl + ", empNo=" + empNo + ", empNm="
				+ empNm + ", cnt=" + cnt + ", deSq=" + deSq + ", reqAmt=" + reqAmt + ", matNo=" + matNo + ", matNm="
				+ matNm + "]";
	}

}
