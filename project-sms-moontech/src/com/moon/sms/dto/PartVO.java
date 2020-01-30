package com.moon.sms.dto;



public class PartVO {
	private int partSq;
	private String partNm;
	private String partSize;
	private String weight;
	private String picture;
	private String stanPrice;
	private int matSq;
	
	
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
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
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
	public int getMatSq() {
		return matSq;
	}
	public void setMatSq(int matSq) {
		this.matSq = matSq;
	}
	@Override
	public String toString() {
		return "PartVO [partSq=" + partSq + ", partNm=" + partNm + ", partSize=" + partSize + ", weight=" + weight
				+ ", picture=" + picture + ", stanPrice=" + stanPrice + ", matSq=" + matSq + "]";
	}
	

	

}
