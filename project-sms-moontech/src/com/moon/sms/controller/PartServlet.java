package com.moon.sms.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.PartUpdateAction;
import com.moon.sms.controller.action.PartWriteAction;
import com.moon.sms.dto.PartVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class PartServlet
 */
@WebServlet("/part.do")
public class PartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		request.setAttribute("command", command);

		PartActionFactory eaf = PartActionFactory.getInstance();

		Action action = eaf.getAction(command);

		if (action != null) {
			action.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		ServletContext context = getServletContext();

		String path = context.getRealPath("picture");

		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType,
				new DefaultFileRenamePolicy());
		
		String command = multi.getParameter("command");

		 if (command.equals("part_write")) {
			 
			 System.out.println("====" + multi.getFilesystemName("picture"));

			PartVO pVo = new PartVO();

			pVo.setPartSq(Integer.parseInt(multi.getParameter("partSq")));
			pVo.setPartNm(multi.getParameter("partNm"));
			pVo.setPartSize(multi.getParameter("partSize"));
			pVo.setWeight(Integer.parseInt(multi.getParameter("weight")));
			pVo.setPicture(multi.getFilesystemName("picture"));
			pVo.setStanPrice(Integer.parseInt(multi.getParameter("stanPrice")));
			pVo.setMatSq(Integer.parseInt(multi.getParameter("matSq")));

			request.setAttribute("pVo", pVo);

			new PartWriteAction().execute(request, response);
			
		} else if (command.equals("part_update")) {

			 System.out.println("====" + multi.getFilesystemName("picture"));
			
			PartVO pVo = new PartVO();

			pVo.setPartSq(Integer.parseInt(multi.getParameter("partSq")));
			pVo.setPartNm(multi.getParameter("partNm"));
			pVo.setPartSize(multi.getParameter("partSize"));
			pVo.setWeight(Integer.parseInt(multi.getParameter("weight")));
			pVo.setPicture(multi.getFilesystemName("picture"));
			pVo.setStanPrice(Integer.parseInt(multi.getParameter("stanPrice")));
			pVo.setMatSq(Integer.parseInt(multi.getParameter("matSq")));

			request.setAttribute("pVo", pVo);

			new PartUpdateAction().execute(request, response);

		}
		
	}

}
