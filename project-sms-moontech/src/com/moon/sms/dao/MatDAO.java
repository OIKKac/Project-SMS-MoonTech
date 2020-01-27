package com.moon.sms.dao;


import com.moon.sms.dto.MatVO;


public interface MatDAO {

	public void regist(MatVO mVo) throws Exception;
	
	public MatVO read(int matSq) throws Exception;
	
	public void modify(MatVO mVo) throws Exception;
	
	public void delete(int matSq) throws Exception;
	
}
