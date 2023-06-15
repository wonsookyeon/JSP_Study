package com.ezen.reflect.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.reflect.ano.RequestMapping;
import com.ezen.reflect.controller.UserController;

public class Dispatcher implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("이쪽으로 오니?");
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;  //형변환
		
		//요청확인
//		System.out.println("컨텍츠 패스 : " + request.getContextPath());
//		System.out.println("식별자 주소 : " + request.getRequestURI());
//		System.out.println("전체 주소 : " + request.getRequestURL());
		
		//user파싱하기
		String endPoint = request.getRequestURI().replaceAll(request.getContextPath(), "");
													// 컨텍츠 패스를 ""(공백)으로 바꾼다
		System.out.println("endPoint : " + endPoint);
		
		//무식하지만 쉬운 방법
/*		UserController userController = new UserController();
		if(endPoint.equals("/join")) {
			userController.join();
		}else if(endPoint.equals("/login")) {
			userController.login();
		}
*/		
		
		//많은 메소드들이 있을 때
		UserController userController = new UserController();
		
		Method[] methods = userController.getClass().getDeclaredMethods();  //userController 클래스에 있는 메소드를 method 에 넣어준다.
/*		
		for(Method m : methods) {
//			System.out.println(m);  // method 에 있는 값들을 출력
//			System.out.println(m.getName());  // method 에 있는 함수명들을 출력
			
			if(endPoint.equals("/"+m.getName())) {
				try {
					m.invoke(userController); // 호출함수 안의 메세지 출력
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	*/		
			//어노테이션으로
		for(Method m : methods) {
			Annotation annotation = m.getDeclaredAnnotation(RequestMapping.class);
			RequestMapping mapping = (RequestMapping)annotation;
//			System.out.println(mapping.value());
			
			if(mapping.value().equals(endPoint)) {
				try {
					String path = (String)m.invoke(userController); // @RequestMapping("/user2") user2 입력하면 함수 user()안의 메세지 출력
					
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		
	}
}
