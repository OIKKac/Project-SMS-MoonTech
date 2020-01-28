package com.moon.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.EmpVO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")!=null) {
			url= "main.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		
		String id = request.getParameter("empNo");
		String pwd = request.getParameter("pwd");
		int empNo= Integer.parseInt(id) ;
		
		EmpDAO eDao = EmpDAO.getInstance();
		int result = eDao.userCheck(empNo, pwd);
		
		System.out.println("empNo : " + empNo );
		System.out.println("pwd : " + pwd );
		
		if(result == 1) {
			EmpVO eVo = eDao.getEmp(empNo);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", eVo);
			request.setAttribute("message", "로그인에 성공했습니다.");
			url = "main.jsp";
		} else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if(result == -1) {
			request.setAttribute("message", "존재하지 않은 회원입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
