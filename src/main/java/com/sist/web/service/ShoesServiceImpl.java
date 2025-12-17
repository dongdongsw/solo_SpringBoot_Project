package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ShoesMapper;
import com.sist.web.vo.ShoesVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShoesServiceImpl implements ShoesService{
	
	private final ShoesMapper mapper;

	@Override
	public List<ShoesVO> shoesTop3Data() {
		// TODO Auto-generated method stub
		return mapper.shoesTop3Data();
	}

	@Override
	public List<ShoesVO> shoesListData(int start) {
		// TODO Auto-generated method stub
		return mapper.shoesListData(start);
	}

	@Override
	public int shoesTotalPage() {
		// TODO Auto-generated method stub
		return mapper.shoesTotalPage();
	}
	
	
}
