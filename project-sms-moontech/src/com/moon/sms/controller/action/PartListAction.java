package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartDAO;
import com.moon.sms.dto.PartVO;



public class PartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/part/partList.jsp";
		PartDAO pDao = PartDAO.getInstance();
		
		List<PartVO> partList = pDao.listAll();
		
		request.setAttribute("partList", partList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
	

}
		
