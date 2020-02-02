package com.moon.sms.controller.action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.sms.dao.PartBuyInDAO;
import com.moon.sms.dto.PartBuyInVO;

public class PartBuyInWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START ACTION: PartBuyInWriteAction  ========");
		
		PartBuyInVO mIVo = new PartBuyInVO();
		PartBuyInDAO mIDao = new PartBuyInDAO();
		
		String[] partSqValue = request.getParameterValues("sendValue");
		String[] inAmtValue = request.getParameterValues("inAmtValue");

		mIVo.setInSq(Integer.parseInt(request.getParameter("inSq")));
		mIVo.setEmpNo(Integer.parseInt(request.getParameter("empNo")));
		mIVo.setPurSq(Integer.parseInt(request.getParameter("purSq")));

		
		String splitPartSqValue = Arrays.toString(partSqValue).replace("[", "").replace("]", "");
		String splitInAmtValue = Arrays.toString(inAmtValue).replace("[", "").replace("]", "");


		String[] cutPartSqValue = splitPartSqValue.split(",");
		String[] cutInAmtValue = splitInAmtValue.split(",");
		
		mIDao.registIn(mIVo);
		
		for (int i = 0; i < cutPartSqValue.length; i++) {
			PartBuyInVO mIVo2 = new PartBuyInVO();
			
			int PartSq = Integer.parseInt(cutPartSqValue[i]);
			int inAmt = Integer.parseInt(cutInAmtValue[i]);
			int inSq2 = Integer.parseInt(request.getParameter("inSq"));
			
			mIVo2.setInSq(inSq2);
			mIVo2.setPartSq(PartSq);
			mIVo2.setInAmt(inAmt);
			System.out.println("row :" + i + ", inAmt :" + inAmt);
			
			mIDao.registDe(mIVo2);
		}

		System.out.println("-END PartBuyInWriteAction----");
		new PartBuyInListAction().execute(request, response);
	}	
}

