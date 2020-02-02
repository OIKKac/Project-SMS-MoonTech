package com.moon.sms.controller;

import com.moon.sms.controller.action.Action;
import com.moon.sms.controller.action.PartDeleteAction;
import com.moon.sms.controller.action.PartListAction;
import com.moon.sms.controller.action.PartOutListAction;
import com.moon.sms.controller.action.PartOutOrdListAction;
import com.moon.sms.controller.action.PartOutOrdReadAction;
import com.moon.sms.controller.action.PartOutOrdWriteAction;
import com.moon.sms.controller.action.PartOutReadAction;
import com.moon.sms.controller.action.PartOutWriteAction;
import com.moon.sms.controller.action.PartPdcInListAction;
import com.moon.sms.controller.action.PartPdcInReadAction;
import com.moon.sms.controller.action.PartPdcInWriteAction;
import com.moon.sms.controller.action.PartPdcOrdListAction;
import com.moon.sms.controller.action.PartPdcOrdReadAction;
import com.moon.sms.controller.action.PartPdcOrdWriteAction;
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

		// part_pdc_ord
		else if (command.equals("part_pdc_ord_write")) {
			action = new PartPdcOrdWriteAction();
		} else if (command.equals("part_pdc_ord_list")) {
			action = new PartPdcOrdListAction();
		} else if (command.equals("part_pdc_ord_read")) {
			action = new PartPdcOrdReadAction();
		}
		// part_pdc
		else if (command.equals("part_pdc_ord_write")) {
			action = new PartPdcOrdWriteAction();
		} else if (command.equals("part_pdc_ord_list")) {
			action = new PartPdcOrdListAction();
		} else if (command.equals("part_pdc_ord_read")) {
			action = new PartPdcOrdReadAction();
		}
		// part_pdc_in
		else if (command.equals("part_pdc_in_write")) {
			action = new PartPdcInWriteAction();
		} else if (command.equals("part_pdc_in_list")) {
			action = new PartPdcInListAction();
		} else if (command.equals("part_pdc_in_read")) {
			action = new PartPdcInReadAction();
		}

		// part_out_ord
		else if (command.equals("part_out_ord_write")) {
			action = new PartOutOrdWriteAction();
		} else if (command.equals("part_out_ord_list")) {	
			action = new PartOutOrdListAction();
		} else if (command.equals("part_out_ord_read")) {
			action = new PartOutOrdReadAction();
		}
		// part_out
		else if (command.equals("part_out_write")) {
			action = new PartOutWriteAction();
		} else if (command.equals("part_out_list")) {
			action = new PartOutListAction();
		} else if (command.equals("part_out_read")) {
			action = new PartOutReadAction();
		}

		return action;
	}
}
