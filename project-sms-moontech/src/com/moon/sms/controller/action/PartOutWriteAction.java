package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.MatBuyReqDAO;
import com.moon.sms.dto.MatBuyReqVO;

public class PartOutWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MatBuyReqVO reqVo = new MatBuyReqVO();
		MatBuyReqDAO reqDao = MatBuyReqDAO.getInstance();
		
		String[] matSqValue = request.getParameterValues("sendValue");
		String[] inAmtValue = request.getParameterValues("inAmtValue");

		reqVo.setReqSq(Integer.parseInt(request.getParameter("reqSq")));
		reqVo.setEmpNo(Integer.parseInt(request.getParameter("empNo")));

		
		String splitMatSqValue = Arrays.toString(matSqValue).replace("[", "").replace("]", "");
		String splitInAmtValue = Arrays.toString(inAmtValue).replace("[", "").replace("]", "");


		String[] cutMatSqValue = splitMatSqValue.split(",");
		String[] cutInAmtValue = splitInAmtValue.split(",");
		
		reqDao.registIn(reqVo);
		
		for (int i = 0; i < cutMatSqValue.length; i++) {
			MatBuyReqVO reqVo2 = new MatBuyReqVO();
			
			int MatSq = Integer.parseInt(cutMatSqValue[i]);
			int inAmt = Integer.parseInt(cutInAmtValue[i]);
			int reqSq2 = Integer.parseInt(request.getParameter("reqSq"));
			
			reqVo2.setReqSq(reqSq2);
			reqVo2.setMatNo(MatSq);
			reqVo2.setReqAmt(inAmt);
			System.out.println("row :" + i + ", inAmt :" + inAmt);
			
			reqDao.registDe(reqVo2);
		}

		System.out.println("-END MatInWriteAction----");
		new MatBuyReqListAction().execute(request, response);
		
		
		
	}

}
