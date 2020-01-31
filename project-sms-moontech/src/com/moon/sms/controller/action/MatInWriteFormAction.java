package com.moon.sms.controller.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dao.MatInDAO;
import com.moon.sms.dto.MatStockVO;
import com.moon.sms.dto.MatVO;

public class MatInWriteFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/matIn/matInWrite.jsp";
		
		MatInDAO mIDao = MatInDAO.getInstance();
		MatDAO mDao = MatDAO.getInstance();
		
		int nextvalMatInSq = mIDao.nextvalMatInSq();
		List<MatVO> matStockList = mDao.stockList();
		

		System.out.println(nextvalMatInSq);
		
		System.out.println("matStockList ==> " + matStockList.toString());
		
		request.setAttribute("matInSq", nextvalMatInSq);
		request.setAttribute("matStockList", matStockList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}




