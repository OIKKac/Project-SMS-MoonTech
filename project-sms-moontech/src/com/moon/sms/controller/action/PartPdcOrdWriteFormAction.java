package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartDAO;
import com.moon.sms.dao.PartPdcOrdDAO;
import com.moon.sms.dto.PartVO;

public class PartPdcOrdWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/partPdcOrd/partPdcOrdWrite.jsp";
		
		PartDAO pDao = PartDAO.getInstance();
		PartPdcOrdDAO ordDao = PartPdcOrdDAO.getInstance();
		
		int ordSq = ordDao.nextvalPartPdcOrdSq();
		
		List<PartVO> stockList = pDao.stockList();
		
		request.setAttribute("stockList", stockList);
		request.setAttribute("ordSq", ordSq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
}
