package com.moon.sms.dao;

import com.moon.sms.dto.EmpVO;



public interface EmpDAO {

	public void regist(EmpVO eVo) throws Exception;
	
	public EmpVO read(int empSq) throws Exception;
	
	public void modify(EmpVO dVo) throws Exception;
	
	public void delete(int empSq) throws Exception;
	
}