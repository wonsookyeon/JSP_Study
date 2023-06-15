package com.ezen.reflect.controller;

import com.ezen.reflect.ano.RequestMapping;

public class UserController {
	
	@RequestMapping("/user/join2")
//	public void join() {
	public String join() {
		System.out.println("join()함수 호출");
		return "/join.jsp";
	}
	
	@RequestMapping("/user/login2")
//	public void login() {
	public String login() {
		System.out.println("login()함수 호출");
		return "/"; // index.jsp 화면으로
	}
	
	@RequestMapping("/user/user2")
//	public void user() {
	public String user() {
		System.out.println("user()함수 호출");
		return "/";
	}
}
