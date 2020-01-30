package com.moon.sms.controller;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.DeptDeleteAction;
import com.moon.sms.controller.action.DeptListAction;
import com.moon.sms.controller.action.DeptUpdateAction;
import com.moon.sms.controller.action.DeptUpdateFormAction;
import com.moon.sms.controller.action.DeptViewAction;
import com.moon.sms.controller.action.DeptWriteAction;
import com.moon.sms.controller.action.DeptWriteFormAction;


public class DeptActionFactory {
	private static DeptActionFactory instance = new DeptActionFactory();

	private DeptActionFactory() {
		super();
	}

	public static DeptActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		if (command.equals("dept_list")) {
			action = new DeptListAction();
		} else if (command.equals("dept_write_form")) {
			action = new DeptWriteFormAction();
		} else if (command.equals("dept_write")) {
			action = new DeptWriteAction();
		} else if (command.equals("dept_view")) {
			action = new DeptViewAction();
		} else if (command.equals("dept_update_form")) {
			action = new DeptUpdateFormAction();
		} else if (command.equals("dept_update")) {
			action = new DeptUpdateAction();
		} else if (command.equals("dept_delete")) {
			action = new DeptDeleteAction();

		}
		return action;
		}
}
