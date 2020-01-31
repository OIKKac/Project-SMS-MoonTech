package com.moon.sms.controller;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.SellingListAction;


public class SellingActionFactory {
	private static SellingActionFactory instance = new SellingActionFactory();

	private SellingActionFactory() {
		super();
	}

	public static SellingActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		if (command.equals("selling_list")) {
			action = new SellingListAction();
		}
		return action;
	}
}

