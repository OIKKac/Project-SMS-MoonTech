package com.moon.sms.controller;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.PartDeleteAction;
import com.moon.sms.controller.action.PartListAction;
import com.moon.sms.controller.action.PartUpdateAction;
import com.moon.sms.controller.action.PartUpdateFormAction;
import com.moon.sms.controller.action.PartViewAction;
import com.moon.sms.controller.action.PartWriteAction;
import com.moon.sms.controller.action.PartWriteFormAction;

public class PartActionFactory {
	private static PartActionFactory instance = new PartActionFactory();

	private PartActionFactory() {
		super();
	}

	public static PartActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		
		if (command.equals("part_list")) {
			action = new PartListAction();
		} else if (command.equals("part_write_form")) {
			action = new PartWriteFormAction();
		} else if (command.equals("part_write")) {
			action = new PartWriteAction();
		} else if (command.equals("part_view")) {
			action = new PartViewAction();
		} else if (command.equals("part_update_form")) {
			action = new PartUpdateFormAction();
		} else if (command.equals("part_update")) {
			action = new PartUpdateAction();
		} else if (command.equals("part_delete")) {
			action = new PartDeleteAction();
		}
		
		return action;
		}
}

