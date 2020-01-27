package com.moon.sms.dao;

import com.moon.sms.dto.PartBuyVO;

public interface PartBuyDao {
	
	  public void regist(PartBuyVO pBVo) throws Exception;
	  
	  public PartBuyVO read(int buySq) throws Exception;
	  
	  public void delete(int buySq) throws Exception;
 
}
