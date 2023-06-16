// 핸들러 맵핑
package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardListAction;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) { //command = board_list
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		// 4. command(board_list) 랑 ("board_list") 같다면 BoardListAction.java 에 있는 BoardListAction 실행
		if(command.equals("board_list")) {
			action = new BoardListAction();  //BoardListAction()을 action에 담아줌 //객체생성

		}
		
		return action; // 5. BoardServlet.java 26 줄로 return
	}

}
