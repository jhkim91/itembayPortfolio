package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommentService {
	public void insertComment(Map param);
	public List<HashMap> selectCommentList(Map param);
}
