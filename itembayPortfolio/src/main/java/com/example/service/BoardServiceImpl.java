package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Board;
import com.example.model.Page;
import com.example.persistence.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

	/** board 목록 카운트 조회 */
    public int boardItemCount(HashMap param) {
    	return boardMapper.boardItemCount(param);
    }

    /** Board 목록조회 */
	public List<Board> selectBoardList(HashMap param, Page page) {
		return boardMapper.selectBoardList(param, page);
	}
    
	/** Board 상세정보 조회 */
	public Board selectBoardDetail(int seq) {
		Board board = boardMapper.selectBoardDetail(seq);
		return board;
	}
}
