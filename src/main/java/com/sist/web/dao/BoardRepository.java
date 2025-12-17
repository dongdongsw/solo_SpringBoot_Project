package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.BoardVO;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

	public BoardEntity findByNo(int no);
	
	@Query(value="SELECT no, name, subject, hit, TO_CHAR(regdate, 'yyyy-mm-dd') as dbday, num "
			+ "FROM (SELECT no, name, subject, hit, regdate, rownum as num "
			+ "FROM (SELECT no, name, subject, hit, regdate "
			+ "FROM board_1 ORDER BY no DESC)) "
			+ "WHERE num BETWEEN :start AND :end", nativeQuery=true)
	public List<BoardVO> boardListData(@Param("start") Integer start,@Param("end") Integer end);
	
	@Query(value = "SELECT NVL(MAX(no)+1,1) FROM board_1", nativeQuery = true)
	public int getMax();
	
	
}
