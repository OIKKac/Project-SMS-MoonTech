package com.moon.sms.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date 2020.01.22
 * @page 634~
 * @author ACJ_NOTEBOOK1
 *
 */
public interface Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
	
	
}
