package com.goodee.ex12.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.goodee.ex12.domain.BoardDTO;
<<<<<<< HEAD
=======
import com.goodee.ex12.domain.ReplyDTO;
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
import com.goodee.ex12.mapper.BoardMapper;
import com.goodee.ex12.util.PageUtils;

@Service
public class BoardServiceImpl implements BoardService {
<<<<<<< HEAD

=======
	
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void findBoards(HttpServletRequest request, Model model) {
<<<<<<< HEAD
=======

		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		
//		int page = 1;
//		String strPage = request.getParameter("page");
//		if(strPage != null) {
//			page = Integer.parseInt(strPage);
<<<<<<< HEAD
//		}

		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
=======
//		}	// 파라미터는 전달이 안되면 null이다.
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		
		int totalRecord = boardMapper.selectBoardCount();
		
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
<<<<<<< HEAD
		Map<String, Object> map = new HashMap<>();
=======
		Map<String, Object> map = new HashMap<String, Object>();
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		List<BoardDTO> boards = boardMapper.selectBoardList(map);
		
		model.addAttribute("boards", boards);
		model.addAttribute("totalRecord", totalRecord);
<<<<<<< HEAD
		model.addAttribute("paging", pageUtils.getPaging1(request.getContextPath() + "/board/list"));
		
=======
		model.addAttribute("paging", pageUtils.getPaging(request.getContextPath() + "/board/list"));
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
	}
	
	@Override
	public void findBoardByNo(HttpServletRequest request, HttpServletResponse response, Model model) {
<<<<<<< HEAD
		
=======
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		Long boardNo = Long.parseLong(opt.orElse("0"));
		
		// 요청 주소
<<<<<<< HEAD
		// 상세보기 요청               : ${contextPath}/board/detail
=======
		// 상세보기 요청 			   : ${contextPath}/board/detail
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		// 수정화면으로 가기 위한 요청 : ${contextPath}/board/changePage
		String requestURI = request.getRequestURI();
		if(requestURI.endsWith("detail")) {
			boardMapper.updateBoardHit(boardNo);
		}
		
		// 게시글 가져 옴(원글)
		BoardDTO board = boardMapper.selectBoardByNo(boardNo);
		
<<<<<<< HEAD
		// 게시글이 존재하면 session에 두기(상세보기, 수정할 때 꺼내 보려고)
		if(board != null) {	
			request.getSession().setAttribute("board", board);
		} else {
			try {
				response.setContentType("text/html");
=======
		// 게시글이 존재하면, 댓글을 가져와야 한다.
		if(board != null) {
			
			// 게시글을 session에 올려두기(상세보기, 수정할 때 꺼내보려고)
			request.getSession().setAttribute("board", board);
			
			// 댓글 목록 가져오기
			List<ReplyDTO> replies = null;
			
			// detail.jsp로 보낼 정보
			// model.addAttribute("board", board);	 이 부분은 session에 올렸기 때문에 필요없어짐.
			model.addAttribute("replies", replies);
			
		} else {
			try {
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('일치하는 게시글이 없습니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
<<<<<<< HEAD
		
	}
	
	@Transactional  // save() 메소드에 있는 모든 쿼리문은 모두 성공해야 합니다. 하나라도 실패하면 전부 실패처리 합니다.
	@Override
	public int save(HttpServletRequest request) {
		
=======
	}
		
	
	
	@Transactional	// save() 메소드에 있는 모든 쿼리문은 모두 성공해야 한다. 
					// 하나라도 실패하면 전부 실패처리한다.
					// 여기선 insertNoard밖에 실행한게 없다.
	@Override
	public int save(HttpServletRequest request) {
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
<<<<<<< HEAD
		// 어딘가를 경유해서 작성된 게시글의 IP는 요청헤더 X-Forwarded-For에 저장된다.
		// 직접 전달된 게시글은 요청헤더 X-Forwarded-For값이 없다.
=======
		// 어딘가를 경유해서 작성된 게시글의 IP는 X-Forwarded-For에 저장된다.
		// 직접 전달된 게시글은 X-Forwarded-For 값이 없다.
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		
<<<<<<< HEAD
=======
		// Mapper한테 BoardDTO를 주기로 했다.
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		BoardDTO board = BoardDTO.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.ip(ip)
				.build();
<<<<<<< HEAD
		
		return boardMapper.insertBoard(board);
		
=======
		return boardMapper.insertBoard(board);
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
	}
	
	@Override
	public int change(BoardDTO board) {
		return boardMapper.updateBoard(board);
	}
	
	@Override
	public int remove(Long boardNo) {
		return boardMapper.deleteBoard(boardNo);
	}
<<<<<<< HEAD
	
=======

>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
}
