package com.kedu.member.controller;

import com.kedu.common.action.Action;
import com.kedu.common.action.MemberListAction;
import com.kedu.common.action.MemberWriteAction;

public class ActionFactory {
private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if (command.equals("member_list")) {
			action = new MemberListAction();
		} else if (command.equals("member_write")) {
			action = new MemberWriteAction();
		}
		return action;
	}
}
