package com.moon.sms.dao;

import com.moon.sms.dto.MatInVO;


public interface MatInDAO {

	public void regist(MatInVO mIVo) throws Exception;
	
	public MatInVO read(int inSq) throws Exception;

	public void delete(int inSq) throws Exception;
	
   



	
}
