package com.saeyan.javabeans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@ToString 
//@AllArgsConstructor //생성자
//@NoArgsConstructor //빈 생성자
//@Data //전체, 가급적 사용x
public class MemberBean {
	
	private String name;
	private String userid;
	private String nickname;
	private String pwd;
	private String email;
	private String phone;

}
