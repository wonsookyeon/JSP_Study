package com.ezen.vo;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class ProductVO {
	private int code;
	private String image, name, price;
}
