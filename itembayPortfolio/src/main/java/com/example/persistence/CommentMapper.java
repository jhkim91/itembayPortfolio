package com.example.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.Comment;
import com.example.model.Page;

@Mapper
public interface CommentMapper {
	void commentCreate(@Param("param") Map param);
	List<HashMap> selectCommentList(@Param("param") Map param);
}
