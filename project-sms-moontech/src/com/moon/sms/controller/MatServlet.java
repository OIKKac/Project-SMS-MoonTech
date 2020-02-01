package com.moon.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.controller.action.Action;

/**
 * Servlet implementation class MatServlet
 */
@WebServlet("/mat.do")
public class MatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");    
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		
		MatActionFactory maf = MatActionFactory.getInstance();
		Action action = maf.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");    
		response.setContentType("text/html;charset=utf-8");     
		doGet(request, response);
	}

}
