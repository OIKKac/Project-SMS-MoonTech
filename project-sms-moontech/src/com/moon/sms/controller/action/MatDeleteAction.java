package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatDAO;


public class MatDeleteAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int matSq = Integer.parseInt(request.getParameter("matSq"));
		MatDAO mDao = MatDAO.getInstance();
		
		System.out.println("Delete matSq : " + matSq);
		
		mDao.delete(matSq);
		
		new MatListAction().execute(request, response);
	}



}
