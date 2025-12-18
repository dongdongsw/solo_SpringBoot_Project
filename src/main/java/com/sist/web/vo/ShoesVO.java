package com.sist.web.vo;

import lombok.Data;

@Data
public class ShoesVO {

	private int goods_id, im_sell, hit, category_id;
	private String name_kor, name_eng, brand, img, sku, color, type, bookmark;
}
