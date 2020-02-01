package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.DeptDAO;
import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.DeptVO;



public class EmpWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/emp/empWrite.jsp";

		
		EmpDAO eDao = EmpDAO.getInstance();
		int nextvalEmpNo = eDao.nextvalEmpNo();
		
		List<DeptVO> deptList = DeptDAO.getInstance().listAll();
		
		System.out.println(nextvalEmpNo);
		
		request.setAttribute("empNo", nextvalEmpNo);
		request.setAttribute("deptList", deptList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}