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
		EmpVO eVo = new EmpVO();
		
		eVo.setEmpNo(Integer.parseInt(request.getParameter("empNo")));
		eVo.setEmpNm(request.getParameter("empNm"));
		eVo.setHp(request.getParameter("hp"));
		eVo.setDeptSq(Integer.parseInt(request.getParameter("deptSq")));
		eVo.setPosi(request.getParameter("posi"));
		eVo.setAddress(request.getParameter("address"));
		eVo.setPicture(request.getParameter("picture"));
		eVo.setEmail(request.getParameter("email"));
		eVo.setPwd(request.getParameter("pwd"));
		
		System.out.println("empNo : " + eVo.getEmpNo());
		System.out.println("empNm : " + eVo.getEmpNm());
		System.out.println("hp : " + eVo.getHp());
		System.out.println("deptSq : " + eVo.getDeptSq());
		System.out.println("posi : " + eVo.getPosi());
		System.out.println("address : " + eVo.getAddress());
		System.out.println("picture : " + eVo.getPicture());
		System.out.println("email : " + eVo.getEmail());
		System.out.println("pwd : " + eVo.getPwd());
		
		EmpDAO eDao = EmpDAO.getInstance();

		eDao.regist(eVo);

		new EmpListAction().execute(request, response);

	}

}