 package com.kedu.common.action;

import com.kedu.staff.action.StaffWriteAction;
import com.kedu.staff.action.StaffWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if (command.equals("staff_write")) {
			action = new StaffWriteAction();
		} else if (command.equals("staff_write_form")) {
			action = new StaffWriteFormAction();
		}
		return action;
	}
}
