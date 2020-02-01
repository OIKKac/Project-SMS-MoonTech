package com.moon.sms.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.EmpUpdateAction;
import com.moon.sms.controller.action.EmpWriteAction;
import com.moon.sms.dto.EmpVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		request.setAttribute("command", command);

		EmpActionFactory eaf = EmpActionFactory.getInstance();

		Action action = eaf.getAction(command);

		if (action != null) {
			action.execute(request, response);
		} else if(command.equals("emp_write")) {
			ServletContext context = getServletContext();
			System.out.println("command : " + command);
			System.out.println("context: " + context.getContextPath());
			
			String path = context.getRealPath("picture");
			
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			
			
			String empNo = multi.getParameter("empNo");
			String empNm = multi.getParameter("empNm");
			String deptSq = multi.getParameter("deptSq");
			
			String pwd = multi.getParameter("pwd");
			String hp = multi.getParameter("hp");
			String posi = multi.getParameter("posi");
			String address = multi.getParameter("address");
			String email = multi.getParameter("email");
			String picture = multi.getFilesystemName("picture");
			
			
			EmpVO eVo = new EmpVO();
			eVo.setEmpNo(Integer.parseInt(empNo));
			eVo.setEmpNm(empNm);
			eVo.setDeptSq(deptSq);
			eVo.setPwd(pwd);
			eVo.setHp(hp);
			eVo.setPosi(posi);
			eVo.setAddress(address);
			eVo.setEmail(email);
			eVo.setPicture(picture);

			System.out.println("eVo: " + eVo);
			
			request.setAttribute("eVo", eVo);
			
			new EmpWriteAction().execute(request, response);
			
		} else if(command.equals("emp_update")) {
			
			ServletContext context = getServletContext();
			System.out.println("command : " + command);
			System.out.println("context: " + context.getContextPath());
			
			String path = context.getRealPath("picture");
			
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			
			String empNo = multi.getParameter("empNo");
			String empNm = multi.getParameter("empNm");
			String deptSq = multi.getParameter("deptSq");
			
			String pwd = multi.getParameter("pwd");
			String hp = multi.getParameter("hp");
			String posi = multi.getParameter("posi");
			String address = multi.getParameter("address");
			String email = multi.getParameter("email");
			
			String prevPicture = multi.getParameter("prevPicture");
			System.out.println("prevPicture : " + prevPicture);
			String picture = multi.getFilesystemName("picture");
			System.out.println("picture : " + picture);
			
			EmpVO eVo = new EmpVO();
			eVo.setEmpNo(Integer.parseInt(empNo));
			eVo.setEmpNm(empNm);
			eVo.setDeptSq(deptSq);
			eVo.setPwd(pwd);
			eVo.setHp(hp);
			eVo.setPosi(posi);
			eVo.setAddress(address);
			eVo.setEmail(email);
			if(picture == null) {
				eVo.setPicture(prevPicture);
			} else if(picture != null) {
				eVo.setPicture(picture);
			}

			System.out.println("eVo: " + eVo);
			
			request.setAttribute("eVo", eVo);
			
			new EmpUpdateAction().execute(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

