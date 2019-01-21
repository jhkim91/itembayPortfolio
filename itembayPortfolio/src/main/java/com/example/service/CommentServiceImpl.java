package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Comment;
import com.example.model.Page;
import com.example.persistence.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

	/** comment 등록 */
	public void insertComment(Map param) {
		commentMapper.commentCreate(param);
	}
	
	/** comment 리스트 */
	public List<HashMap> selectCommentList(Map param) {
		return commentMapper.selectCommentList(param);
	}
    
}
