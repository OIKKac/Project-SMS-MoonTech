package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartOutOrdDAO;
import com.moon.sms.dto.PartOutOrdVO;

public class PartOutOrdListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/part/partOutOrdList.jsp";
		PartOutOrdDAO pooDao = PartOutOrdDAO.getInstance();
		
		List<PartOutOrdVO> pooList = pooDao.listAll();
		
		request.setAttribute("pooList", pooList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
	

}
		
