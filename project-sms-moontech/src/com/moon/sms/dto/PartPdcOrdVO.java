package com.moon.sms.dto;

/*
 *CREATE TABLE `t_part_pdc_ord` (
	`ORD_SQ` INT(11) NOT NULL AUTO_INCREMENT COMMENT '지시SQ',
	`ORD_DT` DATE NOT NULL COMMENT '지시DT',
	`EMP_NO` INT(11) NOT NULL COMMENT '직원NO',
	PRIMARY KEY (`ORD_SQ`),
	INDEX `EMP_NO` (`EMP_NO`),
	CONSTRAINT `T_PART_PDC_ORD-EMP_NO` FOREIGN KEY (`EMP_NO`) REFERENCES `m_emp` (`EMP_NO`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='부품 생산 지시'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
 * CREATE TABLE `t_part_pdc_ord_de` (
	`ORD_DE_SQ` INT(11) NOT NULL AUTO_INCREMENT COMMENT '지시내역SQ',
	`ORD_DE_AMT` INT(11) NOT NULL COMMENT '지시내역AMT',
	`PART_SQ` INT(11) NOT NULL COMMENT '부품SQ',
	`ORD_SQ` INT(11) NOT NULL COMMENT '생산SQ',
	PRIMARY KEY (`ORD_DE_SQ`),
	INDEX `PART_SQ` (`PART_SQ`),
	INDEX `PDC_SQ` (`ORD_SQ`),
	CONSTRAINT `T_PART_PDC_ORD_DE-PART_SQ` FOREIGN KEY (`PART_SQ`) REFERENCES `m_part` (`PART_SQ`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `T_PART_PDC_ORD_DE_ORD_SQ` FOREIGN KEY (`ORD_SQ`) REFERENCES `t_part_pdc_ord` (`ORD_SQ`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='부품 생산 지시 내역'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
 */


import java.util.Date;

public class PartPdcOrdVO {
	private int ordSq;
	private Date ordDt;
	private int empNo;
	private boolean ordFl;
	
	private int deSq;
	private int ordAmt;
	private int partSq;
	public int getOrdSq() {
		return ordSq;
	}
	public void setOrdSq(int ordSq) {
		this.ordSq = ordSq;
	}
	public Date getOrdDt() {
		return ordDt;
	}
	public void setOrdDt(Date ordDt) {
		this.ordDt = ordDt;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public boolean isOrdFl() {
		return ordFl;
	}
	public void setOrdFl(boolean ordFl) {
		this.ordFl = ordFl;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getOrdAmt() {
		return ordAmt;
	}
	public void setOrdAmt(int ordAmt) {
		this.ordAmt = ordAmt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	@Override
	public String toString() {
		return "PartPdcOrdVO [ordSq=" + ordSq + ", ordDt=" + ordDt + ", empNo=" + empNo + ", ordFl=" + ordFl + ", deSq="
				+ deSq + ", ordAmt=" + ordAmt + ", partSq=" + partSq + "]";
	}
	
	
	
}
