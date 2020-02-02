package com.moon.sms.dto;

import java.util.Date;

public class PartOutOrdVO {
	
	private int ordSq;
	private Date ordDt;
	private int empNo;
	private String empNm;
	private int selSq;
	private String selNm;
	private int ordFl;
	private int cnt;
	
	//tb_part_out_ord_de
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
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public int getSelSq() {
		return selSq;
	}
	public void setSelSq(int selSq) {
		this.selSq = selSq;
	}
	public String getSelNm() {
		return selNm;
	}
	public void setSelNm(String selNm) {
		this.selNm = selNm;
	}
	public int getOrdFl() {
		return ordFl;
	}
	public void setOrdFl(int ordFl) {
		this.ordFl = ordFl;
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
		return "PartOutOrdVO [ordSq=" + ordSq + ", ordDt=" + ordDt + ", empNo=" + empNo + ", empNm=" + empNm
				+ ", selSq=" + selSq + ", selNm=" + selNm + ", ordFl=" + ordFl + ", cnt=" + cnt + ", deSq=" + deSq
				+ ", ordAmt=" + ordAmt + ", partSq=" + partSq + "]";
	}
	
}
