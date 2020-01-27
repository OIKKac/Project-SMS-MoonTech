package com.moon.sms.dto;
/*
 * CREATE TABLE `t_part_rel` (
	`REL_SQ` INT(11) NOT NULL AUTO_INCREMENT COMMENT '출고SQ',
	`REL_DT` DATE NOT NULL COMMENT '출고DT',
	`EMP_NO` INT(11) NOT NULL COMMENT '직원NO',
	`ORD_SQ` INT(11) NOT NULL COMMENT '요청SQ',
	PRIMARY KEY (`REL_SQ`),
	INDEX `REL_ORD_SQ` (`ORD_SQ`),
	INDEX `T-PART_REL-EMP_NO` (`EMP_NO`),
	CONSTRAINT `T-PART_REL-EMP_NO` FOREIGN KEY (`EMP_NO`) REFERENCES `m_emp` (`EMP_NO`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `T-PART_REL-ORD_SQ` FOREIGN KEY (`ORD_SQ`) REFERENCES `t_part_rel_ord` (`ORD_SQ`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='부품 출고'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

 * CREATE TABLE `t_part_rel_de` (
	`REL_DE_SQ` INT(11) NOT NULL AUTO_INCREMENT COMMENT '출고내역SQ',
	`REL_DE_AMT` INT(11) NOT NULL COMMENT '출고내역AMT',
	`PART_SQ` INT(11) NOT NULL COMMENT '부품NO',
	`REL_SQ` INT(11) NOT NULL COMMENT '출고SQ',
	PRIMARY KEY (`REL_DE_SQ`),
	INDEX `PART_NO` (`PART_NO`),
	INDEX `REL_SQ` (`REL_SQ`),
	CONSTRAINT `T_PART_REL_DE-PART_NO` FOREIGN KEY (`PART_NO`) REFERENCES `m_part` (`PART_SQ`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `T_PART_REL_DE-REL_SQ` FOREIGN KEY (`REL_SQ`) REFERENCES `t_part_rel` (`REL_SQ`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='부품 구매 내역'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

 */

import java.util.Date;

public class PartOutVO {
	
	private int outSq;
	private Date outDt;
	private int empNo;
	private int selSq;
	
	private int deSq;
	private int outAmt;
	private int partSq;
	public int getOutSq() {
		return outSq;
	}
	public void setOutSq(int outSq) {
		this.outSq = outSq;
	}
	public Date getOutDt() {
		return outDt;
	}
	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getSelSq() {
		return selSq;
	}
	public void setSelSq(int selSq) {
		this.selSq = selSq;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getOutAmt() {
		return outAmt;
	}
	public void setOutAmt(int outAmt) {
		this.outAmt = outAmt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	
	@Override
	public String toString() {
		return "PartRelVO [outSq=" + outSq + ", outDt=" + outDt + ", empNo=" + empNo + ", selSq=" + selSq + ", deSq="
				+ deSq + ", outAmt=" + outAmt + ", partSq=" + partSq + "]";
	}
	
	
	
	
}
