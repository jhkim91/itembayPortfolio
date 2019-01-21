package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Comment;
import com.example.service.CommentServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentServiceImpl commentService;
	
	@RequestMapping(value = "/insert")
	public @ResponseBody String user(@RequestBody Map param) {

		commentService.insertComment(param);
		
		Map map = new HashMap();
		map.put("result", "비동기 통신 결과");
		map.put("item", "비동기 통신 아이템");

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(map);
	}
	
	@RequestMapping(value = "/list")
	public @ResponseBody String list(@RequestBody Map param) {
		List<HashMap> comment = commentService.selectCommentList(param);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(comment);
	}

}
