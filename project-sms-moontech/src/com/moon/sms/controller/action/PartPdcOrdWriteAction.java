package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartPdcOrdDAO;
import com.moon.sms.dto.PartPdcInVO;
import com.moon.sms.dto.PartPdcOrdVO;

public class PartPdcOrdWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START Action: PartPdcOrdWriteAction  ========");
		
		PartPdcOrdVO ordVo = new PartPdcOrdVO();
		PartPdcOrdDAO ordDao = new PartPdcOrdDAO();
		
		String[] matSqValue = request.getParameterValues("sendValue");
		String[] inAmtValue = request.getParameterValues("inAmtValue");

		ordVo.setOrdSq(Integer.parseInt(request.getParameter("ordSq")));
		ordVo.setEmpNo(Integer.parseInt(request.getParameter("empNo")));

		
		String splitMatSqValue = Arrays.toString(matSqValue).replace("[", "").replace("]", "");
		String splitInAmtValue = Arrays.toString(inAmtValue).replace("[", "").replace("]", "");


		String[] cutMatSqValue = splitMatSqValue.split(",");
		String[] cutInAmtValue = splitInAmtValue.split(",");
		
		ordDao.registIn(ordVo);
		
		for (int i = 0; i < cutMatSqValue.length; i++) {
			PartPdcOrdVO ordVo2 = new PartPdcOrdVO();
			
			int PartSq = Integer.parseInt(cutMatSqValue[i]);
			int OrdAmt = Integer.parseInt(cutInAmtValue[i]);
			int ordSq2 = Integer.parseInt(request.getParameter("ordSq"));
			
			ordVo2.setOrdSq(ordSq2);
			ordVo2.setPartSq(PartSq);
			ordVo2.setOrdAmt(OrdAmt);
			System.out.println("row :" + i + ", inAmt :" + OrdAmt);
			
			ordDao.registDe(ordVo2);
		}

		System.out.println("-END PartPdcOrdWriteAction----");
		new PartPdcOrdListAction().execute(request, response);
	}	
}

