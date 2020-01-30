package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.EmpVO;

public class EmpUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpVO eVo = new EmpVO();

		String i = request.getParameter("empNo");
		int empNo = Integer.parseInt(i);

		
		
		eVo.setEmpNo(empNo);
		eVo.setEmpNm(request.getParameter("empNm"));
		eVo.setHp(request.getParameter("hp"));
		eVo.setDeptSq(Integer.parseInt(request.getParameter("deptSq")));
		eVo.setPosi(request.getParameter("posi"));
		eVo.setAddress(request.getParameter("address"));
		eVo.setPicture(request.getParameter("picture"));
		eVo.setEmail(request.getParameter("email"));
		eVo.setPwd(request.getParameter("pwd"));
		
		EmpDAO eDao = EmpDAO.getInstance();
		eDao.modify(eVo);

		new EmpListAction().execute(request, response);
	}
}