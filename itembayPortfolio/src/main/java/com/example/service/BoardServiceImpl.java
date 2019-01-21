package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Board;
import com.example.persistence.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

	/** Board 상세정보 조회 */
	public Board selectBoardDetail(int seq) {
		Board board = boardMapper.selectBoardDetail(seq);
		return board;
	}
    
}
