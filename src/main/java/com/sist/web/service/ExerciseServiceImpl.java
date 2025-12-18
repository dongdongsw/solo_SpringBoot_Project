package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ExerciseMapper;
import com.sist.web.vo.ExerciseVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{
	
	private final ExerciseMapper mapper;

	@Override
	public List<ExerciseVO> exerciseListData(int start) {
		// TODO Auto-generated method stub
		return mapper.exerciseListData(start);
	}

	@Override
	public int exerciseTotalPage() {
		// TODO Auto-generated method stub
		return mapper.exerciseTotalPage();
	}

	@Override
	public List<ExerciseVO> exerciseTop10Data() {
		// TODO Auto-generated method stub
		return mapper.exerciseTop10Data();
	}

	@Override
	public ExerciseVO exerciseDetailData(String b_id) {
		// TODO Auto-generated method stub
		mapper.exerciseHitIncrement(b_id);
		return mapper.exerciseDetailData(b_id);
	}
	
	
}
