package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.DeptDAO;
import com.moon.sms.dao.MatBuyReqDAO;
import com.moon.sms.dto.DeptVO;
import com.moon.sms.dto.MatBuyReqVO;
import com.oreilly.servlet.MultipartRequest;



public class MatBuyReqUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MatBuyReqDAO dao = MatBuyReqDAO.getInstance();
		
		
		String[] arrDeSq = request.getParameterValues("deSq");
		String[] arrReqAmt = request.getParameterValues("reqAmt");
		
		for (String string : arrReqAmt) {
			System.out.println(string);
		}
		
		
		String splitDeSqValue = Arrays.toString(arrDeSq).replace("[", "").replace("]", "");
		String splitReqAmtValue = Arrays.toString(arrReqAmt).replace("[", "").replace("]", ""); 
		
		String[] cutDeSqValue = splitDeSqValue.split(",");
		String[] cutReqAmtValue = splitReqAmtValue.split(",");
		
		for (int i = 0; i < cutDeSqValue.length; i++) {
			MatBuyReqVO buyReqVO = new MatBuyReqVO();
			int deSq = Integer.parseInt(cutDeSqValue[i]);
			int reqAmt = Integer.parseInt(cutReqAmtValue[i]);
			
			buyReqVO.setDeSq(deSq);
			buyReqVO.setReqAmt(reqAmt);
			
			dao.modify(buyReqVO);
			
		}
		
		
		
		new MatBuyReqListAction().execute(request, response);

	}

}