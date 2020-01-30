package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.DeptDAO;
import com.moon.sms.dto.DeptVO;



public class DeptWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	DeptVO dVo = new DeptVO();
		
		dVo.setDeptNm(request.getParameter("deptNm"));
		
		System.out.println("deptNm : " + dVo.getDeptNm());
		
		DeptDAO dDao = DeptDAO.getInstance();

		dDao.regist(dVo);

		new DeptListAction().execute(request, response);

	}

}