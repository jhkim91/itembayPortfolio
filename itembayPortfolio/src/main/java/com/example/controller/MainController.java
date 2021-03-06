package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Board;
import com.example.service.BoardService;

@Controller
public class MainController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/")
	public String main(Model model) {
		
		Board board = boardService.selectBoardDetail(1);
		
		return "index";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
		return "view/member/login";
	}
	
}
