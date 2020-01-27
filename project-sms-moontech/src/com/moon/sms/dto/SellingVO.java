package com.moon.sms.dto;



public class SellingVO {
	
	private int selSq;
	private String bunum;
	private String selNm;
	private String repNm;
	private String address;
	private String hp;
	private String email;
	
	
	public int getSelSq() {
		return selSq;
	}
	public void setSelSq(int selSq) {
		this.selSq = selSq;
	}
	public String getBunum() {
		return bunum;
	}
	public void setBunum(String bunum) {
		this.bunum = bunum;
	}
	public String getSelNm() {
		return selNm;
	}
	public void setSelNm(String selNm) {
		this.selNm = selNm;
	}
	public String getRepNm() {
		return repNm;
	}
	public void setRepNm(String repNm) {
		this.repNm = repNm;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SellingVO [selSq=" + selSq + ", bunum=" + bunum + ", selNm=" + selNm + ", repNm=" + repNm + ", address="
				+ address + ", hp=" + hp + ", email=" + email + "]";
	}
	
	
	
	
}
