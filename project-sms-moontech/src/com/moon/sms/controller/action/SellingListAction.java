package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.SellingDAO;
import com.moon.sms.dto.SellingVO;



public class SellingListAction  implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/selling/sellingList.jsp";
		SellingDAO selDao = SellingDAO.getInstance();
		
		List<SellingVO> sellingList = selDao.listAll();
		
		request.setAttribute("sellingList", sellingList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
}