package com.goodee.ex02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 	@Controller
 	
	안녕. 난 컨트롤러야.
	서블릿으로 만들지 않고, 클래스로 만들면 돼.
*/

@Controller
public class HomeController {
	
	// JSP처럼 *.do와 같이 공통 URLMapping을 가질 필요가 없어요.
	
	
	// 메소드 1개 = 요청 1개, 응답 1개
	
	/*
	 	@RequestMapping
	 	1. URLMapping을 처리하는 애너테이션
	 	2. 메소드마다 하나씩 가져야 한다.
	 	3. 속성
	 		1) value : URLMapping 작성
	 		2) method : 요청 메소드 작성(GET, POST)
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	// value="/" 의미
	// contextPath 매핑을 의미한다. http://localhost:9090/ex02
	// 프로젝트를 실행하면 가장 먼저 처리되는 메소드이다.
	// 일반적으로 index.jsp를 열어 주는 일을 한다. (welcome file 작업하기)
	
	
	// 반환타입 : String (열어 줄 jsp 이름 = View 이름)
	// 메소드명 : index  (아무 일도 안하니까 맘대로 지으면 된다.)
	// 매개변수 : 없음   (요청과 응답을 처리하는 request, response 선언)
	public String index(HttpServletRequest request) {

		// 미션. "hello" 텍스트를 index.jsp로 보내기.
		request.setAttribute("res", "hello");
		
		return "index";
		
		// return "index"는 servlet-context.xml에 정의된 ViewResolver에 의해서 아래와 같이 처리된다.
		// return "/WEB-INF/views/index.jsp"
		//        prefix + "index" + suffix
		
		// 어떻게 갈까요?
		// forward로 이동합니다.
	
	}
	
	
	// @RequestMapping은 메소드를 먼저 만들고 작성하는 것이 좋다.
	
	// @RequestMapping(value="imageView", method=RequestMethod.GET)
	
	// @RequestMapping(value="/imageView", method=RequestMethod.GET)  매핑은 슬래시(/)로 시작해도 된다.
	
	// @RequestMapping(value="imageView")  GET 방식은 안 적어도 된다.
	
	// @RequestMapping("imageView")	       속성 하나만 작성할 땐 속성이름을 안 적어도 된다.
	
	@RequestMapping(value="imageView", method=RequestMethod.GET)
	public String imageView() {
		
		return "gallery/detail";
		
		// return "/WEB-INF/views/  gallery/detail  .jsp"
	}
	
	@RequestMapping("imageView2")
	public String imageView2() {
		return "gallery/lion";
	}
	
}
