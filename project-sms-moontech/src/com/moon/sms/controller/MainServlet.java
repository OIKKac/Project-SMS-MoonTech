package com.moon.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatBuyReqDAO;
import com.moon.sms.dao.MatDAO;
import com.moon.sms.dao.PartBuyReqDAO;
import com.moon.sms.dao.PartOutOrdDAO;
import com.moon.sms.dao.PartPdcOrdDAO;
import com.moon.sms.dto.MatVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "main.jsp";
		System.out.println("===========MainServlet");

		// Get MatBuyReq Count
		MatBuyReqDAO mbrDao = MatBuyReqDAO.getInstance();
		int matBuyReqCount = mbrDao.countMatBuyReqSq();
		request.setAttribute("matBuyReqCount", matBuyReqCount);

		
		// GET PartBuyReq Count 
		PartBuyReqDAO pbrDao = PartBuyReqDAO.getInstance();
		int partBuyReqCount = pbrDao.countPartBuyReq();
		request.setAttribute("partBuyReqCount", partBuyReqCount);
		  
		// GET PartPdcOrd Count 
		PartPdcOrdDAO pdoDao = PartPdcOrdDAO.getInstance();
		int partPdcOrdCount = pdoDao.countPartPdcOrd();
		request.setAttribute("partPdcOrdCount", partPdcOrdCount);
		  
		// GET PartOutOrd Count 
		PartOutOrdDAO pooDao = PartOutOrdDAO.getInstance();
		int partOutOrdCount = pooDao.countPartOutOrd();
		request.setAttribute("partOutOrdCount", partOutOrdCount);
		 

		MatDAO mDao = MatDAO.getInstance();
		List<MatVO> matList = mDao.listAll();

		request.setAttribute("matList", matList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
