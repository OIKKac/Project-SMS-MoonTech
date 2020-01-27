package com.moon.sms.dao;


import com.moon.sms.dto.DeptVO;



public interface DeptDAO {

	public void regist(DeptVO dVo) throws Exception;
	
	public DeptVO read(int deptSq) throws Exception;
	
	public void modify(DeptVO dVo) throws Exception;
	
	public void delete(int deptSq) throws Exception;
	

}