package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.DeptDAO;
import com.moon.sms.dto.DeptVO;




public class DeptSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String url = "/dept/deptSelectName.jsp";
		
		String selectNm = request.getParameter("selectNm");
		
		System.out.println("selectNm : " + selectNm);
		
		DeptDAO dDao = DeptDAO.getInstance();
		List<DeptVO> deptList = dDao.selectNameList(selectNm);
		
		request.setAttribute("deptList", deptList);
		System.out.println("deptList : " + deptList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
	

}
