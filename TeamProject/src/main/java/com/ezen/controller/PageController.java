package com.ezen.controller;

import com.ezen.anno.RequestMapping;

public class PageController {

	
	@RequestMapping("/main")
	public String main() {  //void에서 String 바꾼 이유는 어떤 경로로 이동해야하기 때문에, //username,password,email필요
		System.out.println("main함수 호출");
		return "/";        // 
	}
}
