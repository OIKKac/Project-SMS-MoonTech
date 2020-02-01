package com.moon.sms.controller;


import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.MatDeleteAction;
import com.moon.sms.controller.action.MatInWriteAction;
import com.moon.sms.controller.action.MatInWriteFormAction;
import com.moon.sms.controller.action.MatListAction;
import com.moon.sms.controller.action.MatUpdateAction;
import com.moon.sms.controller.action.MatUpdateFormAction;
import com.moon.sms.controller.action.MatViewAction;
import com.moon.sms.controller.action.MatWriteAction;
import com.moon.sms.controller.action.MatWriteFormAction;

public class MatActionFactory {
	private static MatActionFactory instance = new MatActionFactory();

	private MatActionFactory() {
		super();
	}

	public static MatActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		
		if (command.equals("mat_list")) {
			action = new MatListAction();
		} else if (command.equals("mat_write_form")) {
			action = new MatWriteFormAction();
		} else if (command.equals("mat_write")) {
			action = new MatWriteAction();
		} else if (command.equals("mat_view")) {
			action = new MatViewAction();
		} else if (command.equals("mat_update_form")) {
			action = new MatUpdateFormAction();
		} else if (command.equals("mat_update")) {
			action = new MatUpdateAction();
		} else if (command.equals("mat_delete")) {
			action = new MatDeleteAction();
		}
		
		else if (command.equals("mat_in_write_form")) {
			action = new MatInWriteFormAction();
		}
		else if (command.equals("mat_in_write")) {
			action = new MatInWriteAction();
		}
		
		
		return action;
	}
}
