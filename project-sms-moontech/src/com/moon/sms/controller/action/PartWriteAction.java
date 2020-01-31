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
		
		pVo.setPartSq(Integer.parseInt(request.getParameter("partSq")));
		pVo.setPartNm(request.getParameter("partNm"));
		pVo.setPartNm(request.getParameter("partSize"));
		pVo.setWeight(Integer.parseInt(request.getParameter("weight")));
		pVo.setPicture(request.getParameter("picture"));
		pVo.setStanPrice(Integer.parseInt(request.getParameter("stanPrice")));
		pVo.setMatSq(Integer.parseInt(request.getParameter("matSq")));
		
		  
		PartDAO pDao = PartDAO.getInstance();	
		
		pDao.regist(pVo);
		  
		new MatListAction().execute(request, response);

	}

}