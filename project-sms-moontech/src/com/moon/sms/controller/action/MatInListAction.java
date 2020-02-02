package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;
import com.moon.sms.dao.MatInDAO;
import com.moon.sms.dto.MatInVO;
import com.moon.sms.dto.MatVO;




public class MatInListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-Start Action");
		
		String url = "/matIn/matList.jsp";
		MatInDAO mIDao = MatInDAO.getInstance();
		
		List<MatInVO> list = mIDao.inListAll();
		
		request.setAttribute("matInList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		System.out.println("-End Action");
	}
}
