package com.goodee.ex05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {		// ${contextPath}로 요청이 오면, ${contextPath}/index 요청이 오면
	@GetMapping(value={"/", "/index"})
	public String index() {
		return "index";				// index.jsp로 이동하자.
	}
	
	@GetMapping("/member")			// 원래 value="/member"인데 value 생략가능. 다른 속성을 추가할 땐 붙여야 함.
	public String member() {
		return "member"; 			// member.jsp로 이동하자.
	}
	
	@GetMapping("/board")			// ${contextPath}/board 요청이 오면..
	public String board() {
		return "board";				// board.jsp로 이동하자.
	}
	
	@GetMapping(value="/product")	// ${contextPath}/product 요청이 오면,
	public String product() {		// product.jsp로 이동하자.
		return "product";
	}
	
	@GetMapping(value="/reservation")	// ${contextPath}/reservation 요청이 오면,
	public String reservation() {		// reservation.jsp로 이동하자
		return "reservation";
	}
	

}
