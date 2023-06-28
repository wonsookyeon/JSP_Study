package com.ezen.controller;

import com.ezen.action.AboutAction;
import com.ezen.action.Action;
import com.ezen.action.EventAction;
import com.ezen.action.FAQAction;
import com.ezen.action.IdCheckAction;
import com.ezen.action.IdCheckFormAction;
import com.ezen.action.MemberJoinAction;
import com.ezen.action.MainAction;
import com.ezen.action.MemberDeleteAction;
import com.ezen.action.MemberDeletePassFormAction;
import com.ezen.action.MemberJoinFormAction;
import com.ezen.action.MemberUpdateAction;
import com.ezen.action.MemberUpdateFormAction;
import com.ezen.action.ProductAction;
import com.ezen.action.ProductListAction;
import com.ezen.action.ReviewAction;
import com.ezen.action.UserCheckAction;
import com.ezen.action.UserCheckFormAction;
import com.ezen.action.UserPassCheckAction;
import com.ezen.action.UserPassCheckFormAction;

//Handler Mapping
public class ActionFactory {
	private  static ActionFactory instance = new ActionFactory();
	private ActionFactory(){}
	public static ActionFactory getInstance(){
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;

		if(command.equals("main")) {
			action = new MainAction();
		} else if(command.equals("product")){
			action = new ProductAction();
		} else if(command.equals("event")){
			action = new EventAction();
		}else if(command.equals("review")){
			action = new ReviewAction();
		}else if(command.equals("faq")){
			action = new FAQAction();
		}else if(command.equals("about")) {
			action = new AboutAction();
		}else if(command.equals("product_list")) {
            action = new ProductListAction();
		}else if(command.equals("login_form")) {
        	action = new UserCheckFormAction();
        }else if(command.equals("login")) {
        	action = new UserCheckAction();
        }else if(command.equals("join_form")) {
        	action = new MemberJoinFormAction();	
        }else if(command.equals("join")) {
        	action = new MemberJoinAction();
        }else if(command.equals("id_check_form")) {
        	action = new IdCheckFormAction();	
        }else if(command.equals("id_check")) {
        	action = new IdCheckAction();	
        }else if(command.equals("pass_check_form")) {
        	action = new UserPassCheckFormAction();
        }else if(command.equals("pass_check")) {
        	action = new UserPassCheckAction();
        }else if(command.equals("member_update_form")) {
        	action = new MemberUpdateFormAction();	
        }else if(command.equals("member_update")) {
        	action = new MemberUpdateAction();
        }else if(command.equals("member_delete_pass_form")) {
			action = new MemberDeletePassFormAction();
        }else if(command.equals("member_delete")) {
			action = new MemberDeleteAction();
		}
		
		return action;
	}
}
