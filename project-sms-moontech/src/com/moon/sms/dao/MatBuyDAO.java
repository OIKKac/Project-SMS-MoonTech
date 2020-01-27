package com.moon.sms.dao;

import com.moon.sms.dto.MatBuyVO;

public interface MatBuyDAO {

	public void regist(MatBuyVO mBVo) throws Exception;
	
	public MatBuyVO read(int buySq) throws Exception;
	
	public void delete(int buySq) throws Exception;
	
	
}
