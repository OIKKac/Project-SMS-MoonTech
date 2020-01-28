package com.moon.sms.dto;

public class MatVO {
	
	private int matSq;
	private String matNm;
	private String matSize;
	private String picture;
	private String stanPrice;
	private String weight;
	
	
	public int getMatSq() {
		return matSq;
	}
	public void setMatSq(int matSq) {
		this.matSq = matSq;
	}
	public String getMatNm() {
		return matNm;
	}
	public void setMatNm(String matNm) {
		this.matNm = matNm;
	}
	public String getMatSize() {
		return matSize;
	}
	public void setMatSize(String matSize) {
		this.matSize = matSize;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getStanPrice() {
		return stanPrice;
	}
	public void setStanPrice(String stanPrice) {
		this.stanPrice = stanPrice;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "MatVO [matSq=" + matSq + ", matNm=" + matNm + ", matSize=" + matSize + ", picture=" + picture
				+ ", stanPrice=" + stanPrice + ", weight=" + weight + "]";
	}
	
	
	
		
}