package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.DeptDAO;
import com.moon.sms.dto.DeptVO;



public class DeptListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dept/deptList.jsp";
		DeptDAO dDao = DeptDAO.getInstance();
		
		List<DeptVO> deptList = dDao.listAll();
		System.out.println("deptList : " + deptList);
		
		request.setAttribute("deptList", deptList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
}