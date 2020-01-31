package com.moon.sms.controller;


import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.MatDeleteAction;
import com.moon.sms.controller.action.MatInWriteFormAction;
import com.moon.sms.controller.action.MatListAction;
import com.moon.sms.controller.action.MatUpdateAction;
import com.moon.sms.controller.action.MatUpdateFormAction;
import com.moon.sms.controller.action.MatViewAction;
import com.moon.sms.controller.action.MatWriteAction;
import com.moon.sms.controller.action.MatWriteFormAction;
import com.moon.sms.controller.action.SearchAction;

public class SearchActionFactory {
	private static SearchActionFactory instance = new SearchActionFactory();

	private SearchActionFactory() {
		super();
	}

	public static SearchActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		
		if (command.equals("search_ajax")) {
			action = new SearchAction();
		} 
		
		
		return action;
	}
}
