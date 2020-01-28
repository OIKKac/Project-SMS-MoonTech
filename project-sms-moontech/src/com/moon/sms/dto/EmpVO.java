package com.moon.sms.dto;



public class EmpVO {

	private int empNo;
	private String empNm;
	private String pwd;
	private String hp;
	
	private String posi;
	private String address;
	private String picture;
	private String email;
	
	private int deptSq;

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getPosi() {
		return posi;
	}

	public void setPosi(String posi) {
		this.posi = posi;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDeptSq() {
		return deptSq;
	}

	public void setDeptSq(int deptSq) {
		this.deptSq = deptSq;
	}

	@Override
	public String toString() {
		return "DeptVO [empNo=" + empNo + ", empNm=" + empNm + ", pwd=" + pwd + ", hp=" + hp + ", posi=" + posi
				+ ", address=" + address + ", picture=" + picture + ", email=" + email + ", deptSq=" + deptSq + "]";
	}
	
	
}