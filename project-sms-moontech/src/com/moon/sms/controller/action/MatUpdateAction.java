package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dto.MatVO;

public class MatUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========MatUpdateAction");
		MatVO mVo = new MatVO();
		
		mVo = (MatVO)request.getAttribute("mVo");
		
		MatDAO mDao = MatDAO.getInstance();
		mDao.modify(mVo);
		
		new MatListAction().execute(request, response);
	}
}
