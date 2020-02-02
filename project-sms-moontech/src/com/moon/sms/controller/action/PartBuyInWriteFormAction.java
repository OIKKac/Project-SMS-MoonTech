package com.moon.sms.controller.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartBuyInDAO;
import com.moon.sms.dao.PartDAO;
import com.moon.sms.dto.MatVO;
import com.moon.sms.dto.PartVO;

public class PartBuyInWriteFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Start Action: PartBuyInWriteFormAction ========");
		
		String url = "/partBuyIn/partBuyInWrite.jsp";
		
		PartBuyInDAO pBIDao = PartBuyInDAO.getInstance();
		PartDAO pDao = PartDAO.getInstance();
		
		int nextvalpartBuyInSq = pBIDao.nextvalPartBuyInSq();
		List<PartVO> partStockList = pDao.stockList();
		

		System.out.println(nextvalpartBuyInSq);
		
		System.out.println("partStockList ==> " + partStockList.toString());
		
		request.setAttribute("partBuyInSq", nextvalpartBuyInSq);
		request.setAttribute("partStockList", partStockList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}




