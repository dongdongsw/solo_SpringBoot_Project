package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.MusicVO;

@Mapper
@Repository
public interface MusicMapper {

	@Select("SELECT no, cno, hit, title, singer, poster "
			+ "FROM genie_music "
			+ "ORDER BY rank ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<MusicVO> musicListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM genie_music")
	public int musicTotalPage();
	
	@Update("UPDATE genie_music SET "
			+ "hit = hit + 1 "
			+ "WHERE no = #{no}")
	public void musicHitIncrement(int no);
	
	@Select("SELECT * FROM genie_music "
			+ "WHERE no = #{no}")
	public MusicVO musicDetailData(int no);
	
}
