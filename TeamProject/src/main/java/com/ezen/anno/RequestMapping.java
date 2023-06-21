package com.ezen.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* 1. Life cycle 결정 @Retention
 *   - RUNTIME : 
 *   - ClASS : 
 * 2. 타겟 설정
 */


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
	String value();
}
