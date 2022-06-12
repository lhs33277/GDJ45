package com.goodee.ex12.service;

<<<<<<< HEAD
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ReplyService {
	public Map<String, Object> findReplies(Long boardNo);
	public Map<String, Object> saveReply(HttpServletRequest request);
	public Map<String, Object> removeReply(Long replyNo);
=======
import org.springframework.stereotype.Service;

@Service
public interface ReplyService {

>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
}
