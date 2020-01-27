package com.moon.sms.dao;

import com.moon.sms.dto.SellingVO;

//매입처
public interface SellingDAO {

	public void regist(SellingVO selVo) throws Exception;
	
	public SellingVO read(int selSq) throws Exception;
	
	public void modify(SellingVO selVo) throws Exception;
	
	public void delete(int selSq) throws Exception;
	
}
