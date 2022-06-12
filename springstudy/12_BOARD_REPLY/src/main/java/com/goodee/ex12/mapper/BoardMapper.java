package com.goodee.ex12.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.ex12.domain.BoardDTO;

@Mapper
public interface BoardMapper {
<<<<<<< HEAD
	
	public List<BoardDTO> selectBoardList(Map<String, Object> map);
	public int selectBoardCount();
	
	public BoardDTO selectBoardByNo(Long boardNo);
=======
	public List<BoardDTO> selectBoardList(Map<String, Object> map);
	public int selectBoardCount();
	
	public BoardDTO selectBoardByNo(Long BoardNo);
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
	public int updateBoardHit(Long boardNo);
	
	public int insertBoard(BoardDTO board);
	public int updateBoard(BoardDTO board);
	public int deleteBoard(Long boardNo);
<<<<<<< HEAD
=======
	
	
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675

}
