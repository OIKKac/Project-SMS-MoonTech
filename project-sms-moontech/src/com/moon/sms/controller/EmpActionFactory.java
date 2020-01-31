package com.moon.sms.controller;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.EmpDeleteAction;
import com.moon.sms.controller.action.EmpListAction;
import com.moon.sms.controller.action.EmpUpdateAction;
import com.moon.sms.controller.action.EmpUpdateFormAction;
import com.moon.sms.controller.action.EmpViewAction;
import com.moon.sms.controller.action.EmpWriteAction;
import com.moon.sms.controller.action.EmpWriteFormAction;


public class EmpActionFactory {
	private static EmpActionFactory instance = new EmpActionFactory();

	private EmpActionFactory() {
		super();
	}

	public static EmpActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		if (command.equals("emp_list")) {
			action = new EmpListAction();
		} else if (command.equals("emp_write_form")) {
			action = new EmpWriteFormAction();
		} else if (command.equals("emp_write")) {
			action = new EmpWriteAction();
		} else if (command.equals("emp_view")) {
			action = new EmpViewAction();
		} else if (command.equals("emp_update_form")) {
			action = new EmpUpdateFormAction();
		} else if (command.equals("emp_update")) {
			action = new EmpUpdateAction();
		} else if (command.equals("emp_delete")) {
			action = new EmpDeleteAction();
		}
		
		return action;
	}
}
