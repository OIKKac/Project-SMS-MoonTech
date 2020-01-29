package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dto.MatVO;


public class MatUpdateFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/mat/matUpdate.jsp";
		String i = request.getParameter("matSq");
		int matSq = Integer.parseInt(i);
		
		System.out.println("modify matSq :" + matSq);
		
		MatDAO mDao = MatDAO.getInstance();
		MatVO mVo = mDao.read(matSq);
		
		request.setAttribute("mat", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}

