package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.ShoesVO;

@Mapper
@Repository
public interface ShoesMapper {

	@Select("SELECT im_sell, name_kor, brand, img, sku, color, type, bookmark, rownum "
			+ "FROM (SELECT im_sell, name_kor, brand, img, sku, color, type, bookmark, rownum as num "
			+ "FROM shoes "
			+ "ORDER BY bookmark DESC) "
			+ "WHERE rownum <= 3")
	public List<ShoesVO> shoesTop3Data();
	
	@Select("SELECT goods_id, im_sell, name_kor, brand, img, sku, color, "
			+ "type, bookmark "
			+ "FROM shoes "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ShoesVO> shoesListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM shoes")
	public int shoesTotalPage();
	
	@Update("UPDATE shoes SET "
			+ "hit = hit + 1 "
			+ "WHERE goods_id = #{goods_id}")
	public void shoesHitIncrement(int goods_id);
	
	@Select("SELECT * FROM shoes WHERE goods_id = #{goods_id}")
	public ShoesVO shoesDetailData(int goods_id);
}
