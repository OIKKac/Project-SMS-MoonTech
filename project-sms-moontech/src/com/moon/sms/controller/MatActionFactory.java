package com.moon.sms.controller;


import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.MatBuyReqWriteAction;
import com.moon.sms.controller.action.MatBuyReqWriteFormAction;
import com.moon.sms.controller.action.MatDeleteAction;
import com.moon.sms.controller.action.MatInListAction;
import com.moon.sms.controller.action.MatInViewAction;
import com.moon.sms.controller.action.MatInWriteAction;
import com.moon.sms.controller.action.MatInWriteFormAction;
import com.moon.sms.controller.action.MatListAction;
import com.moon.sms.controller.action.MatSelectAction;
import com.moon.sms.controller.action.MatSelectFormAction;
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
		
		else if (command.equals("mat_select_form")) {
			action = new MatSelectFormAction();
		} else if (command.equals("mat_select")) {
			action = new MatSelectAction();
		}
		else if (command.equals("mat_buy_req_write_form")) {
			action = new MatBuyReqWriteFormAction();
		}
		else if (command.equals("mat_buy_req_write")) {
			action = new MatBuyReqWriteAction();
		}
		
		
		//mat_in
		else if (command.equals("mat_in_write_form")) {
			action = new MatInWriteFormAction();
		}else if (command.equals("mat_in_write")) {
			action = new MatInWriteAction();
		}else if (command.equals("mat_in_list")) {
			action = new MatInListAction();
		}else if (command.equals("mat_in_view")) {
			action = new MatInViewAction();
		}else if (command.equals("mat_buy_list")) {
			action = new MatListAction();
		}
		
		return action;
	}
}
