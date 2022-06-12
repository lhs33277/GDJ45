package com.goodee.ex05.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex05.domain.MemberDTO;
import com.goodee.ex05.service.MemberService;

@Controller
public class MemberController {
	
	// 컨트롤러는 언제나 Service를 호출.
	// 그래서 Service를 field로 등록.
	
	// DI를 사용 안 하는 경우
	// 개발자가 직접 필요한 Bean을 생성하는 방법
	// private MemberService memberService = new MemberServiceImpl();
	
	// DI를 사용하는 경우
	// root-context.xml에 등록한 Bean을 스프링이 가져오는 방법
	
	// 필드, 생성자, setter 방식 중 필드 주입 방식 사용해보자.
	@Autowired
	private MemberService memberService;
	
	
	
	
	// 컨트롤러의 메소드는 기본적으로 JSP이름을 반환한다.
	
	// Ajax는 JSP이름을 반환하는 것이 아니라
	// 자신을 호출한 JSP로 값을 반환하는 구조이다.
	
	// 값을 반환하기 위해서는
	// @ResponseBody 애너테이션이 필요하다.
	
	
	
	@GetMapping(value="/member/detail1", // member.jsp에 ajax url
			produces="text/plain; charset=UTF-8" )	// 내가 반환하는 건 텍스트이다.(응답 타입 response.setContentType)
	@ResponseBody  // 내가 반환하는 건 JSP 이름이 아니라 어떤 값(텍스트, XML, JSON 등)이다.  ResponseBody가 붙어있으면 값처리, 안붙어있으면 JSP처리
	public String detail1(HttpServletRequest request) {	// 파라미터 id와 pw를 request로 받는다.
		String res = memberService.detail1(request);
		return res;	 // MemberService의 detail1() 메소드에서 만든 텍스트를 member.jsp로 반환한다.
	}
	
	
	
	@GetMapping(value="/member/detail2",
			produces="application/json; charset=UTF-8" )	//	// 내가 반환하는 건 JSON이다. jackson이 알아서 JSON으로 바꿔준다.
	@ResponseBody	// 이게 없으면 jsp처리. 아니면 ajax
	
	// 반환타입 memberDTO는 jackson에 의해서 JSON 데이터로 자동 변환된다.
	public MemberDTO detail2(@RequestParam(value="id") String id,	// 파라미터 id는 String id에 저장해 주세요.
							@RequestParam(value="pw") String pw) {	// 파라미터 pw는 String pw에 저장해 주세요.
		MemberDTO member =  memberService.detail2(id, pw);
		
		// Jackson이 하는 일
		// 자바 객체 member를 자동으로 {"id": 아이디, "pw": 비밀번호} 로 만들어 준다.
		
		return member;	// 자바 객체를 member.jsp로 반환하는데, 이 때 jackson이 개입해서 member를 {"id": 아이디, "pw": 비밀번호} 로 바꿔준다.
						// 물론, JSON으로 바꿔서 보내라고 말은 해 줘야 하는데 그건 produces에서 처리한다.
		
		// 실제 return은
		// return {"id": 아이디, "pw": 비밀번호}; 인 것이다.
		
	}
	
	
	
	@GetMapping(value="/member/detail3",
			produces="application/json; charset=UTF-8")	 // 내가 반환하는 값은 JSON이다.
	
	@ResponseBody	// 내가 반환하는 건 JSP이름이 아니다. 값을 반환한다.
	// 반환타입 Map은 jackson에 의해서 JSON 데이터로 자동 변환된다.
	
	public Map<String, Object> detail3(MemberDTO member) {	// MemberDTO의 setId와 setPw가 파라미터 id와 pw를 받아준다.
		
		Map<String, Object> res = memberService.detail3(member);
		
		return res;	 // Map을 반환하고 있지만 produces에서 반환타입이 JSON이라고 했기 때문에,
					 // jackson이 개입해서 Map을 JSON 데이터로 바꿔준다.*
	}
	
	
	@PostMapping(value="/member/detail4",
			produces="application/json; charset=UTF-8")
	
	@ResponseBody
	
	// JSON 데이터가 요청의 본문에 포함된 상태로 컨트롤러로 왔습니다.
	// 컨트롤러에선 이런 데이터를 파라미터(parameter)로 처리할 수 없습니다.
	// 새로운 방법이 필요하다.
	// @RequestBody 애너테이션을 이용하면 요청의 본문에 포함된 데이터를 받을 수 있다.
	// jackson을 사용하고 있기 때문에
	// 컨트롤러로 전달된 JSON 데이터는 MemberDTO 또는 Map으로 받으면 됩니다.  상호변환
	
	public MemberDTO detail4(@RequestBody Map<String, Object> map){
		
		MemberDTO member = memberService.detail4(map);
		
		return member;		// Map이 JSON으로 변환되서 반환되려면 아래 2가지가 필요.
						// @ResponseBody : 내가 반환하는 건 JSP이름이 아니라 어떤 값이다.
						// produces="application/json" : 내가 반환하는건 JSON 데이터이다.
		
	}
	
	
}
