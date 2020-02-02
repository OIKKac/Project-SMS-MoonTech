package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartBuyInDAO;
import com.moon.sms.dto.PartVO;


public class PartBuyInViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START ACTION: PartBuyInViewAction ========");
		String url = "/partBuyIn/partBuyInView.jsp";
		PartBuyInDAO pBIDao = PartBuyInDAO.getInstance();
		
		int inSq = Integer.parseInt(request.getParameter("inSq"));
		
		List<PartVO> selectStockList = pBIDao.readDe(inSq);
		
		request.setAttribute("deList", selectStockList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}
}

