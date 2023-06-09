package com.saeyan.dto;
// Value Object
// DB 값을 얻어오거나 VO자바에 저장된 값을 DB로 추가하기 위해
// 데이터 교환이 이루어 질수 있도록 하는 객체
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;

}
