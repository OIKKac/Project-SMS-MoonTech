package com.moon.sms.dto;

/*
 * CREATE TABLE `t_part_pdc` (
	`PDC_SQ` INT(11) NOT NULL COMMENT '생산SQ',
	`PDC_DT` DATE NULL DEFAULT NULL COMMENT '생산DT',
	`EMP_NO` INT(11) NULL DEFAULT NULL COMMENT '직원NO',
	PRIMARY KEY (`PDC_SQ`),
	INDEX `EMP_NO` (`EMP_NO`),
	CONSTRAINT `T_PART_PDC-EMP_NO` FOREIGN KEY (`EMP_NO`) REFERENCES `m_emp` (`EMP_NO`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='부품 생산'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

 * CREATE TABLE `t_part_pdc_de` (
	`PDC_DE_SQ` INT(11) NOT NULL AUTO_INCREMENT COMMENT '생산내역SQ',
	`PDC_DE_AMT` INT(11) NOT NULL COMMENT '생산내역AMT',
	`PART_SQ` INT(11) NOT NULL COMMENT '부품SQ',
	`PDC_SQ` INT(11) NOT NULL COMMENT '생산SQ',
	PRIMARY KEY (`PDC_DE_SQ`),
	INDEX `PART_NO` (`PART_SQ`),
	INDEX `PDC_SQ` (`PDC_SQ`),
	CONSTRAINT `T_PART_PDC_DE-PART_SQ` FOREIGN KEY (`PART_SQ`) REFERENCES `m_part` (`PART_SQ`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `T_PART_PDC_DE-PDC_SQ` FOREIGN KEY (`PDC_SQ`) REFERENCES `t_part_pdc` (`PDC_SQ`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='부품 생산 내역'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

 */
import java.util.Date;

/**
 * @author ACJ_NOTEBOOK1
 *
 */
public class PartPdcVO {
	
	private int pdcSq;
	private Date pdcDt;
	private int empNo;
	
	private int deSq;
	private int pdcAmt;
	private int partSq;
	
	public int getPdcSq() {
		return pdcSq;
	}
	public void setPdcSq(int pdcSq) {
		this.pdcSq = pdcSq;
	}
	public Date getPdcDt() {
		return pdcDt;
	}
	public void setPdcDt(Date pdcDt) {
		this.pdcDt = pdcDt;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getDeSq() {
		return deSq;
	}
	public void setDeSq(int deSq) {
		this.deSq = deSq;
	}
	public int getPdcAmt() {
		return pdcAmt;
	}
	public void setPdcAmt(int pdcAmt) {
		this.pdcAmt = pdcAmt;
	}
	public int getPartSq() {
		return partSq;
	}
	public void setPartSq(int partSq) {
		this.partSq = partSq;
	}
	@Override
	public String toString() {
		return "PartPdcVO [pdcSq=" + pdcSq + ", pdcDt=" + pdcDt + ", empNo=" + empNo + ", deSq=" + deSq + ", pdcAmt="
				+ pdcAmt + ", partSq=" + partSq + "]";
	}
	
	
	
	
}
