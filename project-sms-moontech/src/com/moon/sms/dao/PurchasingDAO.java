package com.moon.sms.dao;

import com.moon.sms.dto.PurchasingVO;

//매입처
public interface PurchasingDAO {

	public void regist(PurchasingVO purVO) throws Exception;
	
	public PurchasingVO read(int purSq) throws Exception;
	
	public void modify(PurchasingVO purVO) throws Exception;
	
	public void delete(int purSq) throws Exception;
	
}
