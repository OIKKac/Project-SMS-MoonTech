package com.moon.sms.dao;

import com.moon.sms.dto.PartVO;

public interface PartDAO {

	public void create(PartVO pVO) throws Exception;

	public PartVO read(int pSq) throws Exception;

	public void update(PartVO pVO) throws Exception;

	public void delete(int pSq) throws Exception;


}
