package com.moon.sms.dto;

import java.util.Date;

public class PartStockVO {
	private int stockSq;
	private int stockAmt;
	private Date renewDt;
	private int partSq;
	public int getStockSq() {
		return stockSq;
	}
	public void setStockSq(int stockSq) {
		this.stockSq = stockSq;
	}
	public int getStockAmt() {
		return stockAmt;
	}
	public void setStockAmt(int stockAmt) {
		this.stockAmt = stockAmt;
	}
	public Date getRenewDt() {
		return renewDt;
	}
	public void setRenewDt(Date renewDt) {
		this.renewDt = renewDt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	@Override
	public String toString() {
		return "PartStockVO [stockSq=" + stockSq + ", stockAmt=" + stockAmt + ", renewDt=" + renewDt + ", partSq="
				+ partSq + "]";
	}
	
	
	
}