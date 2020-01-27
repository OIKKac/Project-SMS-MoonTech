package com.moon.sms.dto;

public class PurchasingVO {

	
	private int purSq;
	private String bunum;
	private String repNm;
	private String address;
	private String hp;
	private String email;
	private String purNm;
	
	
	public int getPurSq() {
		return purSq;
	}
	public void setPurSq(int purSq) {
		this.purSq = purSq;
	}
	public String getBunum() {
		return bunum;
	}
	public void setBunum(String bunum) {
		this.bunum = bunum;
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
	public String getPurNm() {
		return purNm;
	}
	public void setPurNm(String purNm) {
		this.purNm = purNm;
	}
	@Override
	public String toString() {
		return "PurchasingVO [purSq=" + purSq + ", bunum=" + bunum + ", repNm=" + repNm + ", address=" + address
				+ ", hp=" + hp + ", email=" + email + ", purNm=" + purNm + "]";
	}

	
	
	
}
