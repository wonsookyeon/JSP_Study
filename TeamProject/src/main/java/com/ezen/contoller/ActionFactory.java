package com.ezen.contoller;

import com.ezen.contoller.action.Action;
import com.ezen.contoller.action.userCheckAction;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {}

	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		
		Action action = null;
		
		if(command.equals("login")) {
			action = new userCheckAction();
		}
		
		return action;
	}
	
}
