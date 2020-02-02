package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatBuyReqDAO;
import com.moon.sms.dto.MatBuyReqVO;

public class MatBuyReqListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=============MatBuyReqListAction");
		String url = "/mat/matBuyReqList.jsp";
		MatBuyReqDAO mbrDao = MatBuyReqDAO.getInstance();
		
		List<MatBuyReqVO> mbrList = mbrDao.listAll();
		
		request.setAttribute("mbrList", mbrList);
		System.out.println("mbrList" + mbrList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}

}
