package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.DeptDAO;
import com.moon.sms.dto.DeptVO;



public class DeptViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dept/dpetView.jsp";
		String i = request.getParameter("deptSq");
		int deptSq = Integer.parseInt(i);
		
		DeptDAO dDao = DeptDAO.getInstance();
		DeptVO dVo = dDao.read(deptSq);

		request.setAttribute("dept", dVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}
}

