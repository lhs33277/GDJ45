package com.goodee.ex12.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.ex12.domain.ReplyDTO;

@Mapper
public interface ReplyMapper {
<<<<<<< HEAD
	
	public List<ReplyDTO> selectReplyList(Long boardNo);
	public int selectReplyCount(Long boardNo);
	
	public int insertReply(ReplyDTO reply);
	public int deleteReply(Long replyNo);
	
=======
	public List<ReplyDTO> selectReplyList(Long boardNo);
	public int selectReplyCount(Long boardNo);
	public int insertReply(ReplyDTO reply);
	public int deleteReply(Long replyNo);

>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
}
