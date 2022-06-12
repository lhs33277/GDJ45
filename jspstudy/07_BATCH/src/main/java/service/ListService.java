package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.StudentDAO;

public class ListService implements StudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("list", StudentDAO.getInstance().selectStudentList());	//오른쪽꺼 디비에서 가져온 학생목록 구현해서 list에저장
		request.setAttribute("totalCount", StudentDAO.getInstance().getTotalCount());
		request.setAttribute("totalAverage", StudentDAO.getInstance().getTotalAverage());
		
		return new ActionForward("student/list.jsp", false);
	}

}
