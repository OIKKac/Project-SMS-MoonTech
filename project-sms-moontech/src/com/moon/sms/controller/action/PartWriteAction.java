package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartDAO;
import com.moon.sms.dto.PartVO;



public class PartWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartVO pVo = new PartVO();
		pVo = (PartVO)request.getAttribute("pVo");
		  
		PartDAO pDao = PartDAO.getInstance();	
		
		pDao.regist(pVo);
		  
		new PartListAction().execute(request, response);

	}

}