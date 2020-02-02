package com.moon.sms.controller.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dao.matOutDAO;
import com.moon.sms.dto.MatStockVO;
import com.moon.sms.dto.MatVO;

public class PartInWriteFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/matOut/matOutWrite.jsp";
		
		matOutDAO mIDao = matOutDAO.getInstance();
		MatDAO mDao = MatDAO.getInstance();
		
		int nextvalmatOutSq = mIDao.nextvalmatOutSq();
		List<MatVO> matStockList = mDao.stockList();
		

		System.out.println(nextvalmatOutSq);
		
		System.out.println("matStockList ==> " + matStockList.toString());
		
		request.setAttribute("matOutSq", nextvalmatOutSq);
		request.setAttribute("matStockList", matStockList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}




