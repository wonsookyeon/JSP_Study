package com.ezen.reflect.ano;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //런타임에 실행
@Target({ElementType.METHOD}) //메소드만 target으로

public @interface RequestMapping {
	String value();
	

}
