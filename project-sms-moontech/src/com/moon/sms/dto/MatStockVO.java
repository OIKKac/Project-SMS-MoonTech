package com.moon.sms.dto;

import java.util.Date;

public class MatStockVO {
	
	private int stockSq;
	private String stockAmt;
	private Date renewDt;	
	private int matSq;
	
	
	public int getStockSq() {
		return stockSq;
	}
	public void setStockSq(int stockSq) {
		this.stockSq = stockSq;
	}
	public String getStockAmt() {
		return stockAmt;
	}
	public void setStockAmt(String stockAmt) {
		this.stockAmt = stockAmt;
	}
	public Date getRenewDt() {
		return renewDt;
	}
	public void setRenewDt(Date renewDt) {
		this.renewDt = renewDt;
	}
	public int getMatSq() {
		return matSq;
	}
	public void setMatSq(int matSq) {
		this.matSq = matSq;
	}
	
	@Override
	public String toString() {
		return "MatStockVO [stockSq=" + stockSq + ", stockAmt=" + stockAmt + ", renewDt=" + renewDt + ", matSq=" + matSq
				+ "]";
	}
	

	
	
	
}
