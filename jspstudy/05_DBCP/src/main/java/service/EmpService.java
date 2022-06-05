package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface EmpService {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response);	// 왜 execute메소드는 번환타입이없지
}
