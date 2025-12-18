package com.sist.web.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;



@Data
public class ExerciseVO {
	private int b_view_count, u_s_id;
	private String b_id, b_filter, b_title, b_content, b_thumbnail, b_prod_on_off, b_status, b_type;
	private Date b_createdat, b_updatedat;
	
	List<Exercise_OptionVO> eovo;
	SellerVO usvo = new SellerVO();
}
