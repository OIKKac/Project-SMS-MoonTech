package com.moon.sms.dao;

import com.moon.sms.dto.PartOutVO;

public interface PartOutDAO {

	public void regist(PartOutVO pOVo) throws Exception;
	
	public PartOutVO read(int outSq) throws Exception;

	public void delete(int outSq) throws Exception;
	

	
}
