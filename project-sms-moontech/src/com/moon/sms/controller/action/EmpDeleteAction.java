package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.EmpDAO;

public class EmpDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			System.out.println("EmpDeleteAction//////////");
			String empNo = request.getParameter("empNo");
			System.out.println("empNo : " + empNo);
			
			
			EmpDAO eDao = EmpDAO.getInstance();
			
			eDao.delete(empNo);
			
			new EmpListAction().execute(request, response);
		}



	}
