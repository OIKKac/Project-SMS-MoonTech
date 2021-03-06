package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.controller.action.Action;
import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.EmpVO;


public class EmpUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/emp/empUpdate.jsp";
		String i = request.getParameter("empNo");
		int empNo = Integer.parseInt(i);
		
		System.out.println("modify empNo :" + empNo);
		
		EmpDAO eDao = EmpDAO.getInstance();
		EmpVO eVo = eDao.read(empNo);
		
		request.setAttribute("emp", eVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
