package com.example.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Board;

//@Repository
@Mapper
public interface BoardMapper {
	
	/** Board view select */
	public Board selectBoardDetail(@Param("seq") int seq);
}
