package com.goodee.ex05.service;

import java.util.HashMap;
import java.util.Map;


import com.goodee.ex05.domain.BoardDTO;

public class BoardServiceImpl implements BoardService {

@Override
public Map<String, Object> detail1(BoardDTO board) {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("title", board.getTitle());
	map.put("hit", board.getHit());
	return map;
}

}
