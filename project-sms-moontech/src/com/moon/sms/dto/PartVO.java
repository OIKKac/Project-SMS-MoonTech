package com.moon.sms.dto;



public class PartVO {
	private int partSq;
	private String partNm;
	private String partSize;
	private int weight;
	private String picture;
	private int stanPrice;
	private int matSq;
	private String matNm;
	
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	public String getPartNm() {
		return partNm;
	}
	public void setPartNm(String partNm) {
		this.partNm = partNm;
	}
	public String getPartSize() {
		return partSize;
	}
	public void setPartSize(String partSize) {
		this.partSize = partSize;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getStanPrice() {
		return stanPrice;
	}
	public void setStanPrice(int stanPrice) {
		this.stanPrice = stanPrice;
	}
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
	@Override
	public String toString() {
		return "PartVO [partSq=" + partSq + ", partNm=" + partNm + ", partSize=" + partSize + ", weight=" + weight
				+ ", picture=" + picture + ", stanPrice=" + stanPrice + ", matSq=" + matSq + ", matNm=" + matNm + "]";
	}
	
}
