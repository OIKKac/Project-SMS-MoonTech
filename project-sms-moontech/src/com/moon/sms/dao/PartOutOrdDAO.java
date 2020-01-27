package com.moon.sms.dao;

import com.moon.sms.dto.PartOutOrdVO;

public interface PartOutOrdDAO {

	public void regist(PartOutOrdVO pOOVo) throws Exception;
	
	public PartOutOrdVO read(int ordSq) throws Exception;

	public void delete(int ordSq) throws Exception;
	
			


	
}
