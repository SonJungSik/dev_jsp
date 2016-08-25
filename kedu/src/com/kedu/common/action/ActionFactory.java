 package com.kedu.common.action;

import com.kedu.notice.action.NoticeWriteFormAction;
import com.kedu.staff.action.LoginAction;
import com.kedu.staff.action.LoginFormAction;
import com.kedu.staff.action.MainAction;
import com.kedu.staff.action.StaffListAction;
import com.kedu.staff.action.StaffUpdateAction;
import com.kedu.staff.action.StaffUpdateFormAction;
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
		} else if (command.equals("main_view")){
			action = new MainAction();
		} else if (command.equals("staff_list")) {
			action = new StaffListAction();
		} else if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("staff_update_form")) {
			action = new StaffUpdateFormAction();
		} else if (command.equals("staff_update")) {
			action = new StaffUpdateAction();
		} else if (command.equals("notice_write_form")) {	// notice임
			action = new NoticeWriteFormAction();	
		}
		return action;
	}
}
