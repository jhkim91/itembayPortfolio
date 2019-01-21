package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Board;
import com.example.model.Page;

public interface BoardService {
	public int boardItemCount(HashMap param);
	public List<Board> selectBoardList(HashMap hashMap, Page page);
	public Board selectBoardDetail(int seq);
}
