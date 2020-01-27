package com.moon.sms.dao;


import com.moon.sms.dto.PartBuyInVO;


public interface PartBuyInDAO {

	public void regist(PartBuyInVO pBIVo) throws Exception;
	
	public PartBuyInVO read(int inSq) throws Exception;

	public void delete(int inSq) throws Exception;
	

	
}
