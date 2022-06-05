package com.goodee.ex12.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodee.ex12.domain.BoardDTO;
import com.goodee.ex12.service.BoardService;

@Controller
// @AllArgsConstructor   입력하면 생성자 주입으로 @AutoWired 안적어도 bean생성.
public class BoardController {
	
	@Autowired
	private BoardService boardService;	// 필드주입
	
	@GetMapping("/board/list")
	public String list(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("board");	// list로 돌아가는 타이밍에 session을 지워줌.
		boardService.findBoards(request, model);	// 이걸 findBoards로 넘긴다.
		return "/board/list";
	}
	
	@GetMapping("/board/savePage")
	public String savePage() {
		return "/board/save";
	}
	
	@PostMapping("/board/save")

	 public String save(HttpServletRequest request ,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("insRes", boardService.save(request));
		redirectAttributes.addFlashAttribute("type", "insert");
		return "redirect:/board/result";	// 매핑 /board/result로 redirect 하겠다.	// 아래 @GetMapping으로
	 }
	
	@GetMapping("/board/result")
	public String result() {
		return "/board/result";	 // board/result.jsp로 이동하겠다.(forward)
	}
	
	@GetMapping("/board/detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		boardService.findBoardByNo(request, response, model);
		return "/board/detail";
	}
	
	@GetMapping("/board/changePage")
	public String chanePage() {
		return "/board/change";
	}
	
	
	@PostMapping("/board/change")
	public String change(BoardDTO board, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("updRes", boardService.change(board));
		redirectAttributes.addFlashAttribute("type", "update");
		return "redirect:/board/result";
	}
	/* 이렇게 해도 됨. 하나만 외워서 쓸꺼면 이렇게 해도됨.비추
	@PostMapping("/board/change")
	public String change(HttpServletRequest request) {
		BoardDTO board = BoardDTO.builder()
				.boardNo(Long.parseLong(request.getParameter("boardNo")))
				.title(request.getParameter("title"))
				.content(request.getParameter("content"))
				.build();
		
		return "/board/list";
	}
	*/
	
	@GetMapping("/board/remove")
	public String remove(@RequestParam(value="boardNo", required=false, defaultValue="0L") Long boardNo
			, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("delRes", boardService.remove(boardNo));
		redirectAttributes.addFlashAttribute("type", "delete");
		return "redirect:/board/result";
	}
	
	
	
	
	
	
}
