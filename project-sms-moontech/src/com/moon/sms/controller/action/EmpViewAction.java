package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.EmpVO;



public class EmpViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/emp/empView.jsp";
		String i = request.getParameter("empNo");
		int empNo = Integer.parseInt(i);
		
		EmpDAO eDao = EmpDAO.getInstance();
		EmpVO eVo = eDao.read(empNo);

		request.setAttribute("emp", eVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}
}
