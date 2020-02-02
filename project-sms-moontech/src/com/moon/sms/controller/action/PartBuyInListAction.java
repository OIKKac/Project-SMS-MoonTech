package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartBuyInDAO;
import com.moon.sms.dto.PartBuyInVO;

public class PartBuyInListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Start ACTION: PartBuyInListAction ========");
		
		String url = "/PartBuyIn/PartBuyInList.jsp";
		PartBuyInDAO pBIDao = PartBuyInDAO.getInstance();
		
		List<PartBuyInVO> list = pBIDao.inListAll();
		
		request.setAttribute("PartBuyInList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		System.out.println("-End Action");
	}
}
