package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatInDAO;
import com.moon.sms.dto.MatInVO;

public class MatInWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Start MatInWriteAction ----");
		
		String[] matSqValue = request.getParameterValues("sendValue");
		String[] inAmtValue = request.getParameterValues("inAmtValue");
		
		MatInVO mIVo = new MatInVO();
		MatInDAO mIDao = new MatInDAO();
		
		mIVo.setInSq(Integer.parseInt(request.getParameter("inSq")));
		mIVo.setEmpNo(Integer.parseInt(request.getParameter("empNo")));
		mIVo.setPurSq(Integer.parseInt(request.getParameter("purSq")));
		
		mIDao.registIn(mIVo);
		
		for(int i = 0; i < matSqValue.length; i++) {
			mIVo.setMatSq(Integer.parseInt(request.getParameter(matSqValue[i])));
			mIVo.setInAmt(Integer.parseInt(request.getParameter(inAmtValue[i])));
			
			mIDao.registDe(mIVo);
			
			new MatInWriteAction().execute(request, response);	
		}
	
		
		
		
		/*
		MatDAO mDao = MatDAO.getInstance();
		MatInDAO mIDao = MatInDAO.getInstance();
		
		
		mIdao.registIn(mVo);
		
		
		
		mDao.delete(matSq);
		
		
		
		MatVO mVo = new MatVO();
		mVo.setMatNm(request.getParameter("matNm"));
		mVo.setMatSize(request.getParameter("matSize"));
		mVo.setStanPrice(request.getParameter("stanPrice"));
		mVo.setWeight(request.getParameter("weight"));
		mVo.setPicture(request.getParameter("picture"));
		
		  
		MatDAO mDao = MatDAO.getInstance();	
		
		mDao.regist(mVo);
		  
		new MatListAction().execute(request, response);
*/
	}

}
