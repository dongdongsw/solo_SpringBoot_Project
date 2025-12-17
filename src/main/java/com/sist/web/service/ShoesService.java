package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.ShoesVO;

public interface ShoesService {
	
	public List<ShoesVO> shoesTop3Data();
	public List<ShoesVO> shoesListData(int start);
	public int shoesTotalPage();
}
