package com.example.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.Board;
import com.example.model.Page;

@Mapper
public interface BoardMapper {
	/** Board list total count */
	int boardItemCount(@Param("param") HashMap<String, Object> param);
	
	/** Board list total count */
	List<Board> selectBoardList(@Param("param") HashMap param, @Param("page") Page page);
	
	/** Board view select */
	Board selectBoardDetail(@Param("seq") int seq);
}
