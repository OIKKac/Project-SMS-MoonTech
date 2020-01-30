package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.DeptDAO;



public class DeptDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptSq = request.getParameter("deptSq");
		System.out.println("deptSq : " + deptSq);

		DeptDAO dDao = DeptDAO.getInstance();

		dDao.delete(deptSq);
		
		System.out.println("deptSq : " + deptSq);
		new DeptListAction().execute(request, response);
	}

}
