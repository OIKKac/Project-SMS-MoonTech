package com.moon.sms.dao;

import com.moon.sms.dto.PartPdcOrdVO;

public interface PartPdcOrdDAO {

	public void regist(PartPdcOrdVO pPOVo) throws Exception;

	public PartPdcOrdVO read(int ordSq) throws Exception;

	public void delete(int ordSq) throws Exception;
	
	
}
