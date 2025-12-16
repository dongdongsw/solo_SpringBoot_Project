package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.ExerciseVO;

@Mapper
@Repository
public interface ExerciseMapper {

	@Select("SELECT b_id, b_type, b_title, b_thumbnail, b_filter, b_status, b_createdat "
			+ "FROM board "
			+ "WHERE b_type='운동건강' "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ExerciseVO> exerciseListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM board")
	public int exerciseTotalPage();
}

