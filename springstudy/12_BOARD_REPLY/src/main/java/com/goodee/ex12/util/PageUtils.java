package com.goodee.ex12.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageUtils {
	
	
	/************************************************************************
	 - 전체 11개 레코드를
	 - 한 페이지에 3개씩 표시한다면
	 - 전체 페이지는 4페이지가 된다.
	 ************************************************************************/
	private int totalRecord;		// DB에서 구해온다.
	private int recordPerPage = 5;	// 여기서 마음대로 정한다.
	private int totalPage;			// totalRecord와 recordPerPage로 계산한다.
	
	
	/*************************************************************************
	 - 전체 11개 레코드를
	 - 한 페이지에 3개씩 표시한다면
	 - 각 페이지에 표시되는 레코드의 번호는 다음과 같다.
	 page = 1, beginRecord = 1, endRecord = 3
	 page = 2, beginRecord = 4, endRecord = 6
	 page = 3, beginRecord = 7, endRecord = 9
	 page = 4, beginRecord = 10, endRecord = 11 (endRecord = 12가 아님을 주의)
	 
	 *************************************************************************/
	private int page;			// 파라미터로 받아온다.
	private int beginRecord;	// page와 recordPerPage로 계산한다.
	private int endRecord;		// beginRecord와 recordPerPage와 totalPage로 계산한다.
	
	
	/*************************************************************************
	 - 전체 12개 페이지를
	 - 한 블록에 5개씩 표시한다면
	 - 각 블록에 표시되는 페이지의 번호는 다음과 같다.
	 block = 1,  1  2  3  4  5, beginPage = 1, endPage = 5
	 black = 2,  6, 7, 8  9, 10	beginPage = 6, endPage = 10
	 black = 3, 11, 12
	 * *************************************************************************/
	
	private int pagePerBlock = 5;	// 여기서 마음대로 정한다.
	private int beginPage;			// page와 pagePerBlck으로 계산한다.
	private int endPage;			// beginPage, totalPage로 계산한다.
	
	
	// 매개변수 2개
	// tatalRecord : DB에서 가져온다.
	// page : 파라미터로 가져온다.
	public void setPageEntity(int totalRecord, int page) {
		
		// totalRecord, page 필드 값 저장
		this.totalRecord = totalRecord;
		this.page = page;
		
		// totalPage 계산
		totalPage = totalRecord / recordPerPage;
		if(totalRecord % recordPerPage != 0) {
			totalPage++;
		}
		
		// beginRecord, endRecord 필드 값 계산
		beginRecord = (page - 1) * recordPerPage + 1;
		endRecord = beginRecord + recordPerPage - 1;
		if(endRecord > totalRecord) {
			endRecord = totalRecord;
		}
		
		// beginPage, endPage 필드 값 계산
		// beginPage = (pagePerBlock * (page - 1) / pagePerBlock) + 1;
		beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}


	// 매개변수 1개
	// path : "/employee/list", "/board/list" 등이 각 ServiceImpl에서 전달된다.
	public String getPaging(String path) {
		
		StringBuilder sb = new StringBuilder();
		
		// 전달되는 path의 종류
		// 1. 파라미터가 없는 경우
		//	  /employee/list
		//    /employee/list ?page=1	(? 사용)
		
		// 2. 파라미터가 있는 경우(path에 ?가 포함되어 있다.)
		//	  /employee/search?column=값&query=값
		//	  /employee/search?column=값&query=값 &page=1	(& 사용)
		
		String concat = path.contains("?") ? "&" : "?"; 
		path += concat;
		
		// 1페이지로 이동, 1페이지는 <a>태그가 없다.
		if(page == 1) {
			sb.append("1페이지로이동");
		} else {
			sb.append("<a href=\"" + path + "page=1\">1페이지로 이동</a>");
		}
		
		// 이전 블록으로 이동, 1블록은 <a>태그가 없다.
		if(page <= pagePerBlock) {
			sb.append("이전블록");
		} else {
			sb.append("<a href=\"" + path + "page=" + (beginPage - 1) + "\">이전블록</a>");
		}
		
		
		// 이전 페이지 (prev), 1페이지는 <a> 태그가 없다.
		if(page == 1) {
			sb.append("prev");
		} else {
			sb.append("<a href=\"" + path + "page=" + (page - 1) + "\">prev</a>");
		}
		
		// 페이지 번호 ( 1 2 3 4 5), 현재 페이지는 <a> 태그가 없다.
		for(int p = beginPage; p <= endPage; p++) {
			if(p == page) {
				sb.append(p);
			} else {
				sb.append("<a href=\"" + path + "page=" + p + "\">" + p + "</a>");
			}
		}
		
		// 다음 페이지 (next), 마지막 페이지는 <a> 태그가 없다.
		if(page == totalPage) {
			sb.append("next");
		} else {
			sb.append("<a href=\"" + path + "page=" + (page + 1) + "\">next</a>");
		}
		
		// 다음 블록으로 이동, 마지막 블록은 <a>태그가 없다.
		if(endPage == totalPage) {
			sb.append("다음 블록");
		} else {
			sb.append("<a href=\"" + path + "page=" + (endPage + 1) + "\">다음 블록</a>");
		}
		
		// 마지막 페이지로 이동
		if(page == totalPage) {
			sb.append("마지막페이지로이동");
		} else {
			sb.append("<a href=\"" + path + "page=" + totalPage + "\">마지막 페이지로 이동</a>");
		}
		
		return sb.toString();
	}
	

}
