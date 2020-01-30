package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.EmpVO;


public class EmpListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/emp/empList.jsp";
		EmpDAO eDao = EmpDAO.getInstance();
		
		List<EmpVO> empList = eDao.listAll();
		
		request.setAttribute("empList", empList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
}