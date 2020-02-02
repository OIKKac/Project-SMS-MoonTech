package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatBuyReqDAO;
import com.moon.sms.dao.MatDAO;
import com.moon.sms.dao.MatInDAO;
import com.moon.sms.dto.MatInVO;
import com.moon.sms.dto.MatVO;

public class MatBuyReqWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/matBuyReq/matBuyReqWrite.jsp";
		
		MatDAO matDao = MatDAO.getInstance();
		MatBuyReqDAO reqDao = MatBuyReqDAO.getInstance();
		
		int reqSq = reqDao.nextvalMatBuyReqSq();
		
		List<MatVO> stockList = matDao.stockList();
		
		request.setAttribute("stockList", stockList);
		request.setAttribute("reqSq", reqSq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
