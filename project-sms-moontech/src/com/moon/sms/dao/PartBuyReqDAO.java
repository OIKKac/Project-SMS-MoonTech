package com.moon.sms.dao;


import com.moon.sms.dto.PartBuyReqVO;



public interface PartBuyReqDAO {

	public void regist(PartBuyReqVO pBRVo) throws Exception;
	
	public PartBuyReqVO read(int reqSq) throws Exception;

	public void delete(int reqSq) throws Exception;
	


	
}
