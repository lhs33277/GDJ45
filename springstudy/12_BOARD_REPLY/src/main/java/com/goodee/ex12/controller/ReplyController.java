package com.goodee.ex12.controller;

<<<<<<< HEAD
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex12.service.ReplyService;
=======
import org.springframework.stereotype.Controller;
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675

@Controller
public class ReplyController {

<<<<<<< HEAD
	@Autowired
	private ReplyService replyService;
	
	@ResponseBody
	@GetMapping(value="/reply/list", produces="application/json; charset=UTF-8")
	public Map<String, Object> list(@RequestParam Long boardNo) {
		return replyService.findReplies(boardNo);
	}
	
	@ResponseBody
	@PostMapping(value="/reply/save", produces="application/json; charset=UTF-8")
	public Map<String, Object> save(HttpServletRequest request) {
		return replyService.saveReply(request);
	}
	
	@ResponseBody
	@GetMapping(value="/reply/remove", produces="application/json; charset=UTF-8")
	public Map<String, Object> remove(@RequestParam Long replyNo) {
		return replyService.removeReply(replyNo);
	}
=======
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
	
}
