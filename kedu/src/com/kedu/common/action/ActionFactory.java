 package com.kedu.common.action;

import com.kedu.notice.action.NoticeDeleteAction;
import com.kedu.notice.action.NoticeDetailAction;
import com.kedu.notice.action.NoticeListAction;
import com.kedu.notice.action.NoticeUpdateAction;
import com.kedu.notice.action.NoticeUpdateFormAction;
import com.kedu.notice.action.NoticeWriteAction;
import com.kedu.notice.action.NoticeWriteFormAction;
import com.kedu.project.action.ProjectDetailAction;
import com.kedu.project.action.ProjectListAction;
import com.kedu.project.action.ProjectUpdateAction;
import com.kedu.project.action.ProjectUpdateFormAction;
import com.kedu.project.action.ProjectWriteAction;
import com.kedu.project.action.ProjectWriteFormAction;
import com.kedu.reply.action.ReplyWriteAction;
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
		} else if (command.equals("notice_write")) {
			action = new NoticeWriteAction();
		} else if (command.equals("notice_list")) {
			action = new NoticeListAction();
		} else if (command.equals("notice_detail")) {
			action = new NoticeDetailAction();
		} else if (command.equals("notice_update_form")) {
			action = new NoticeUpdateFormAction();
		} else if (command.equals("notice_update")) {
			action = new NoticeUpdateAction();
		} else if (command.equals("notice_delete")) {
			action = new NoticeDeleteAction();
		} else if (command.equals("project_write_form")) {  // 프로젝트
			action = new ProjectWriteFormAction();
		} else if (command.equals("project_write")) {
			action = new ProjectWriteAction();
		} else if (command.equals("project_list")) {
			action = new ProjectListAction();
		} else if (command.equals("project_detail")) {
			action = new ProjectDetailAction();
		} else if (command.equals("project_update_form")) {
			action = new ProjectUpdateFormAction();
		} else if (command.equals("project_update")) {
			action = new ProjectUpdateAction();
		} else if (command.equals("reply_write")) {
			action = new ReplyWriteAction();
		}
		return action;
	}
}
