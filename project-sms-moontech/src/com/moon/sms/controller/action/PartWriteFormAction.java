package com.moon.sms.controller.action;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartDAO;

public class PartWriteFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/part/partWrite.jsp";
		
		PartDAO pDao = PartDAO.getInstance();
		int nextvalPartSq = pDao.nextvalPartSq();
		
		System.out.println(nextvalPartSq);
		
		request.setAttribute("partSq", nextvalPartSq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
/*

String url = "/part/partUpdate.jsp";
String i = request.getParameter("partSq");
int partSq = Integer.parseInt(i);

System.out.println("modify partSq :" + partSq);

PartDAO mDao = PartDAO.getInstance();
PartVO mVo = mDao.read(partSq);

request.setAttribute("part", mVo);

RequestDispatcher dispatcher = request.getRequestDispatcher(url);
dispatcher.forward(request, response);
*/