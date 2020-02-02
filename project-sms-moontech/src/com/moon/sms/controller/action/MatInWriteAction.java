package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatInDAO;
import com.moon.sms.dto.MatInVO;

public class MatInWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-START MatInWriteAction----");
		
		MatInVO mIVo = new MatInVO();
		MatInDAO mIDao = new MatInDAO();
		
		String[] matSqValue = request.getParameterValues("sendValue");
		String[] inAmtValue = request.getParameterValues("inAmtValue");

		mIVo.setInSq(Integer.parseInt(request.getParameter("inSq")));
		mIVo.setEmpNo(Integer.parseInt(request.getParameter("empNo")));
		mIVo.setPurSq(Integer.parseInt(request.getParameter("purSq")));

		
		String splitMatSqValue = Arrays.toString(matSqValue).replace("[", "").replace("]", "");
		String splitInAmtValue = Arrays.toString(inAmtValue).replace("[", "").replace("]", "");


		String[] cutMatSqValue = splitMatSqValue.split(",");
		String[] cutInAmtValue = splitInAmtValue.split(",");
		
		mIDao.registIn(mIVo);
		
		for (int i = 0; i < cutMatSqValue.length; i++) {
			MatInVO mIVo2 = new MatInVO();
			
			int MatSq = Integer.parseInt(cutMatSqValue[i]);
			int inAmt = Integer.parseInt(cutInAmtValue[i]);
			int inSq2 = Integer.parseInt(request.getParameter("inSq"));
			
			mIVo2.setInSq(inSq2);
			mIVo2.setMatSq(MatSq);
			mIVo2.setInAmt(inAmt);
			System.out.println("row :" + i + ", inAmt :" + inAmt);
			
			mIDao.registDe(mIVo2);
		}

		System.out.println("-END MatInWriteAction----");
		new MatInWriteFormAction().execute(request, response);
	}	
}
		/*
		 * MatDAO mDao = MatDAO.getInstance(); MatInDAO mIDao = MatInDAO.getInstance();
		 * 
		 * 
		 * mIdao.registIn(mVo);
		 * 
		 * 
		 * 
		 * mDao.delete(matSq);
		 * 
		 * 
		 * 
		 * MatVO mVo = new MatVO(); mVo.setMatNm(request.getParameter("matNm"));
		 * mVo.setMatSize(request.getParameter("matSize"));
		 * mVo.setStanPrice(request.getParameter("stanPrice"));
		 * mVo.setWeight(request.getParameter("weight"));
		 * mVo.setPicture(request.getParameter("picture"));
		 * 
		 * 
		 * MatDAO mDao = MatDAO.getInstance();
		 * 
		 * mDao.regist(mVo);
		 * 
		 * new MatListAction().execute(request, response);
		 */
	


