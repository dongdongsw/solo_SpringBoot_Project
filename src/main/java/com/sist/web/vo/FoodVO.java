package com.sist.web.vo;

import lombok.Data;

@Data
public class FoodVO {

	private int fno, score, hit, likecount, replycount, jjimcount;
	private String name, type, phone, address, theme, price, time, parking, poster, images, content;
}
