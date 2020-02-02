package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatBuyReqDAO;
import com.moon.sms.dto.MatBuyReqVO;

public class MatBuyReqReadAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=============MatBuyReqReadAction");
		String url = "/mat/matBuyReqRead.jsp";
		MatBuyReqDAO mbrDao = MatBuyReqDAO.getInstance();
		
		int reqSq = Integer.parseInt(request.getParameter("reqSq"));
		
		List<MatBuyReqVO> mbrList = mbrDao.read(reqSq);
		
		request.setAttribute("mbrList", mbrList);
		System.out.println("mbrList" + mbrList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}

}
