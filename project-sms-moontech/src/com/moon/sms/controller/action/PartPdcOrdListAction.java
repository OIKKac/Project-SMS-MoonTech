package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartDAO;
import com.moon.sms.dao.PartPdcOrdDAO;
import com.moon.sms.dto.PartPdcOrdVO;
import com.moon.sms.dto.PartVO;



public class PartPdcOrdListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/part/partPdcOrdList.jsp";
		PartPdcOrdDAO ppoDao = PartPdcOrdDAO.getInstance();
		
		List<PartPdcOrdVO> ppoList = ppoDao.listAll();
		
		request.setAttribute("ppoList", ppoList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
	

}
		
