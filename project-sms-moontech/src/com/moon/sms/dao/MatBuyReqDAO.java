package com.moon.sms.dao;

import com.moon.sms.dto.MatBuyReqVO;

public interface MatBuyReqDAO {

	public void regist(MatBuyReqVO mBRVo) throws Exception;
	
	public MatBuyReqVO read(int reqSq) throws Exception;

	public void delete(int reqSq) throws Exception;
	
}
