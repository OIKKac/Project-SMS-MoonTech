package com.moon.sms.dto;


/*
 * CREATE TABLE `t_mat_ins` (
	`INS_SQ` INT(11) NOT NULL AUTO_INCREMENT COMMENT '입고SQ',
	`INS_DT` DATE NOT NULL COMMENT '입고DATE',
	`EMP_NO` INT(11) NOT NULL COMMENT '직원NO',
	`PUR_SQ` INT(11) NOT NULL COMMENT '거래처SQ',
	PRIMARY KEY (`INS_SQ`),
	INDEX `EMP_NO` (`EMP_NO`),
	INDEX `PUR_SQ` (`PUR_SQ`)
)
COMMENT='재료 입고'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
 * CREATE TABLE `t_mat_ins_de` (
	`INS_DE_SQ` INT(11) NOT NULL AUTO_INCREMENT COMMENT '거래내역SQ',
	`INS_DE_AMT` INT(11) NOT NULL COMMENT '거래내역AMT',
	`MAT_SQ` INT(11) NOT NULL COMMENT '재료SQ',
	`INS_SQ` INT(11) NOT NULL COMMENT '입고SQ',
	PRIMARY KEY (`INS_DE_SQ`),
	INDEX `INS_SQ` (`INS_SQ`),
	INDEX `MAT_SQ` (`MAT_SQ`),
	CONSTRAINT `FK_t_mat_ins_de_m_mat` FOREIGN KEY (`MAT_SQ`) REFERENCES `m_mat` (`MAT_SQ`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK_t_mat_ins_de_t_mat_ins` FOREIGN KEY (`INS_SQ`) REFERENCES `t_mat_ins` (`INS_SQ`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='재료 구매 내역'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

 
*/

import java.util.Date;

public class PartBuyInVO {
	
	private int inSq;
	private Date inDt;
	private int empNo;
	private int purSq;
	
	private int deSq;
	private int inAmt;
	private int partSq;
	
	private String empNm;
	private String purNm;
	private String CntDe;
	public int getInSq() {
		return inSq;
	}
	public void setInSq(int inSq) {
		this.inSq = inSq;
	}
	public Date getInDt() {
		return inDt;
	}
	public void setInDt(Date inDt) {
		this.inDt = inDt;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getPurSq() {
		return purSq;
	}
	public void setPurSq(int purSq) {
		this.purSq = purSq;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getInAmt() {
		return inAmt;
	}
	public void setInAmt(int inAmt) {
		this.inAmt = inAmt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public String getPurNm() {
		return purNm;
	}
	public void setPurNm(String purNm) {
		this.purNm = purNm;
	}
	public String getCntDe() {
		return CntDe;
	}
	public void setCntDe(String cntDe) {
		CntDe = cntDe;
	}
	@Override
	public String toString() {
		return "PartBuyInVO [inSq=" + inSq + ", inDt=" + inDt + ", empNo=" + empNo + ", purSq=" + purSq + ", deSq="
				+ deSq + ", inAmt=" + inAmt + ", partSq=" + partSq + ", empNm=" + empNm + ", purNm=" + purNm
				+ ", CntDe=" + CntDe + "]";
	}
	
	
	
}
