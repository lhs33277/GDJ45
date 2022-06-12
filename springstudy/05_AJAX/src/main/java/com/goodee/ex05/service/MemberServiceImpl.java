package com.goodee.ex05.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.goodee.ex05.domain.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Override
	public String detail1(HttpServletRequest request) {		// 컨트롤러에서 받아온 request에는 파라미터 id와 pw가 들어있다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		return "입력 아이디: " + id + " / 입력 비밀번호: " + pw;	// 컨트롤러에 반환하는 텍스트
	}
	
	@Override
	public MemberDTO detail2(String id, String pw) {	// 컨트롤러에서 받아온 id와 pw
		// 컨트롤 space 누르면 알아서 오류 나지 않게 오버라이드 메소드 나옴.
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPw(pw);
		
		return member;									// 컨트롤러에 반환하는 객체(bean)
	}
	
	@Override
	public Map<String, Object> detail3(MemberDTO member) {	// 컨트롤러에서 받아온 객체
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", member.getId());
		map.put("pw", member.getPw());
		return map;											// 컨트롤러로 반환하는 Map
	}
	
	@Override
	public MemberDTO detail4 (Map<String, Object> map) {
		MemberDTO member = new MemberDTO();
		member.setId(map.get("id").toString());
		member.setPw((String)map.get("pw"));
		return member;	
	}

}
