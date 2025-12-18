package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.ExerciseVO;

public interface ExerciseService {

	public List<ExerciseVO> exerciseListData(int start);
	public int exerciseTotalPage();
	public List<ExerciseVO> exerciseTop10Data();
	public List<ExerciseVO> exerciseDetailData(String b_id);

}
