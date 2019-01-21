package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Board;
import com.example.model.Page;
import com.example.service.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping
	public String boardList(
			Model model,
	   		@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
	   		@RequestParam(value = "searchWrd", defaultValue = "") String searchWrd,
	   		@RequestParam(value = "searchCnd", defaultValue = "") String searchCnd) {
		
		Page page = new Page(currentPage);

		HashMap<String,Object> hashMap  = new HashMap<String,Object>();
		hashMap.put("searchWrd",searchWrd);
		hashMap.put("searchCnd",searchCnd);
		
		int boardItemCount = boardService.boardItemCount(hashMap);
		model.addAttribute("boardItemCount", boardItemCount);
		
		List<Board> list = boardService.selectBoardList(hashMap, page);
		model.addAttribute("list", list);

        return "/view/board/boardList";
	}
	
	@RequestMapping(value = "/{bno}")
	public String boardView(@PathVariable("bno") int bno, Model model) {

		Board board = boardService.selectBoardDetail(bno);
		model.addAttribute("board", board);
		
		return "/view/board/boardView";
	}
}
