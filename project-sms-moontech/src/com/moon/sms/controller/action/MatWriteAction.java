package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dto.MatVO;

public class MatWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		MatVO mVo = new MatVO();
		mVo.setMatNm(request.getParameter("matNm"));
		mVo.setMatNm(request.getParameter("matNm"));
		mVo.setMatSize(request.getParameter("matSize"));
		mVo.setStanPrice(request.getParameter("stanPrice"));
		mVo.setWeight(request.getParameter("weight"));
		mVo.setPicture(request.getParameter("picture"));
		
		  
		MatDAO mDao = MatDAO.getInstance();	
		
		mDao.regist(mVo);
		  
		new MatListAction().execute(request, response);

	}

}
