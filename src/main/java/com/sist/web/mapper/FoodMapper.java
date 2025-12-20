package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.FoodVO;

@Mapper
@Repository
public interface FoodMapper {

	@Select("SELECT fno, name, type, price, poster, "
			+ "score, hit, likecount "
			+ "FROM food "
			+ "ORDER BY fno DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<FoodVO> foodListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food")
	public int foodTotalPage();
	
	@Update("UPDATE food SET "
			+ "hit = hit + 1 "
			+ "WHERE fno = #{fno}")
	public void foodHitIncrement(int fno);
	
	@Select("SELECT * FROM food WHERE fno = #{fno}")
	public FoodVO foodDetailData(int fno);
	
	
	@Select("SELECT fno, name, type, hit, price, poster, rownum "
			+ "FROM (SELECT fno, name, type, hit, price, poster "
			+ "FROM food "
			+ "ORDER BY hit DESC) "
			+ "WHERE rownum <= 5")
	public List<FoodVO> foodTop5();
	
}
