package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	
	@Select("SELECT b_id, b_title, rownum "
			+ "FROM (SELECT  b_id, b_title "
			+ "FROM board "
			+ "WHERE b_type='운동건강' "
			+ "ORDER BY b_view_count DESC) "
			+ "WHERE rownum <= 10")
	public List<ExerciseVO> exerciseTop10Data();
	
	@Update("UPDATE board SET "
			+ "b_view_count = b_view_count + 1 "
			+ "WHERE b_id = #{b_id}")
	public void exerciseHitIncrement(String b_id);
	

	public List<ExerciseVO> exerciseDetailData(String b_id);
}

