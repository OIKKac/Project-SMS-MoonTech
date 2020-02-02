package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dao.MatInDAO;
import com.moon.sms.dto.MatVO;


public class MatInViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-Start Action: MatInViewAction");
		
		String url = "/matIn/matInView.jsp";
		MatInDAO mIDao = MatInDAO.getInstance();
		
		int inSq = Integer.parseInt(request.getParameter("inSq"));
		
		MatDAO mDao = MatDAO.getInstance();
		
		List<MatVO> selectStockList = mIDao.readDe(inSq);
		
		request.setAttribute("deList", selectStockList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}
}

