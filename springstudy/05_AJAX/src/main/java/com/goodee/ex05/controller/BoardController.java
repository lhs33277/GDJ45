package com.goodee.ex05.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodee.ex05.domain.BoardDTO;
import com.goodee.ex05.service.BoardService;

/*
	@RestController
	
	안녕. 난 Ajax 처리를 위한 컨트롤러야.
	날 선언하면 모든 메소드에 @ResponseBody 애너테이션을 자동으로 붙여줄게.
	너희는 붙이지 마.

 */

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	

	
	
	@GetMapping(value="board/detail1",
			produces="application/json; charset=UTF-8" )
	// @ResponseBody
	public Map<String, Object> detail1(BoardDTO board){
		Map<String, Object> map = boardService.detail1(board);
		return map;
	}

}
