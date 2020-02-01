package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.EmpVO;



public class EmpWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpVO eVo = (EmpVO)request.getAttribute("eVo");
		System.out.println(eVo);
		EmpDAO eDao = EmpDAO.getInstance();
		eDao.regist(eVo);

		new EmpListAction().execute(request, response);

	}

}