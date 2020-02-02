package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dto.MatVO;




public class MatSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String url = "/mat/matSelectName.jsp";
		
		String selectNm = request.getParameter("selectNm");
		
		System.out.println("selectNm : " + selectNm);
		
		MatDAO mDao = MatDAO.getInstance();
		
		List<MatVO> matList = mDao.selectNameList(selectNm);
		
		request.setAttribute("matList", matList);
		System.out.println("matList : " + matList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
	

}
