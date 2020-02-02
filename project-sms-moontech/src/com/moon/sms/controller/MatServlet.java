package com.moon.sms.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.MatUpdateAction;
import com.moon.sms.controller.action.MatWriteAction;
import com.moon.sms.dto.MatVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		ServletContext context = getServletContext();

		String path = context.getRealPath("picture");

		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType,
				new DefaultFileRenamePolicy());
		
		String command = multi.getParameter("command");

		 if (command.equals("mat_write")) {
			 
			 System.out.println("====" + multi.getFilesystemName("picture"));

			MatVO mVo = new MatVO();

			mVo.setMatSq(Integer.parseInt(multi.getParameter("matSq")));
			mVo.setMatNm(multi.getParameter("matNm"));
			mVo.setMatSize(multi.getParameter("matSize"));
			mVo.setStanPrice(multi.getParameter("stanPrice"));
			mVo.setWeight(multi.getParameter("weight"));
			mVo.setPicture(multi.getFilesystemName("picture"));
			
			request.setAttribute("mVo", mVo);

			new MatWriteAction().execute(request, response);
			
		} else if (command.equals("mat_update")) {

			 System.out.println("====" + multi.getFilesystemName("picture"));
			
			 MatVO mVo = new MatVO();

			 String fileName = multi.getParameter("fileName");
			 String picture = multi.getFilesystemName("picture");
			 System.out.println("fileName : " + fileName);
			 System.out.println("picture : " + picture);
			 
			mVo.setMatSq(Integer.parseInt(multi.getParameter("matSq")));
			mVo.setMatNm(multi.getParameter("matNm"));
			mVo.setMatSize(multi.getParameter("matSize"));
			mVo.setStanPrice(multi.getParameter("stanPrice"));
			mVo.setWeight(multi.getParameter("weight"));
			if(picture == null) {
				mVo.setPicture(fileName);
			} else {
				mVo.setPicture(picture);
			}
			
			request.setAttribute("mVo", mVo);

			new MatUpdateAction().execute(request, response);

		}
	}

}
