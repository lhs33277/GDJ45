package com.goodee.ex05.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.goodee.ex05.domain.MemberDTO;


// 기능별로 메소드를 사용한다. 인터페이스는 작업지시서.

public interface MemberService {
	public String detail1(HttpServletRequest request);
	public MemberDTO detail2(String id, String pw);
	public Map<String, Object> detail3(MemberDTO member);	// 이거랑
	public MemberDTO detail4(Map<String, Object> map);		// 이거 위치 바뀌어도 상관없름 MemberDTO랑 Map
}
