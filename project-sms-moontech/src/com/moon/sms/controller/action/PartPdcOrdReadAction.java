package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartPdcOrdDAO;
import com.moon.sms.dto.PartPdcOrdVO;

public class PartPdcOrdReadAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=============PartPdcOrdReadAction");
		String url = "/part/partPdcOrdRead.jsp";
		
		PartPdcOrdDAO ordDao = PartPdcOrdDAO.getInstance();
		
		int ordSq = Integer.parseInt(request.getParameter("ordSq"));
		List<PartPdcOrdVO> ordList = ordDao.read(ordSq);
		
		request.setAttribute("ordList", ordList);
		System.out.println("ordList" + ordList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		System.out.println("END Action");		
	}

}
