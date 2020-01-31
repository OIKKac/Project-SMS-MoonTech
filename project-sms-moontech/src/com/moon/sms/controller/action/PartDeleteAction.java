package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.moon.sms.dao.PartDAO;

public class PartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String partSq =request.getParameter("partSq");		
		PartDAO pDao = PartDAO.getInstance();
		
		System.out.println("Delete partSq : " + partSq);
		
		pDao.delete(partSq);
		
		new PartListAction().execute(request, response);
	}



}

