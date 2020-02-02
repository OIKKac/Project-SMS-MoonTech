package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartBuyReqDAO;
import com.moon.sms.dto.PartBuyReqVO;



public class PartBuyReqListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/part/partBuyReqList.jsp";
		PartBuyReqDAO pbrDao = PartBuyReqDAO.getInstance();
		
		List<PartBuyReqVO> pbrList = pbrDao.listAll();
		
		request.setAttribute("pbrList", pbrList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
	

}
		
