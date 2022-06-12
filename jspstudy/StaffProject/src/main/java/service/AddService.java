package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import domain.Staff;
import repository.StaffDAO;

public class AddService implements StaffService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String sNo = request.getParameter("sNo");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		
		
		Staff staff = Staff.builder()
				.sNo(sNo)
				.name(name)
				.dept(dept)
				.build();
		
		PrintWriter out = null;
		
		try {
			int res = StaffDAO.getInstance().insertStaff(staff);
			response.setContentType("application/json; charset=UTF-8");
			
			JSONObject obj = new JSONObject();
			obj.put("res", res);
			String responseText = obj.toString();
			
			out = response.getWriter();
			out.write(responseText); 
			out.flush();
			out.close();
			
		} catch (PersistenceException e) {
			response.setContentType("text/plain; charset=UTF-8");
			
			response.setStatus(1818);
			
			out = response.getWriter();
			out.write("데이터베이스에 등록되지 않았습니다.");
			out.flush();
			out.close();
			
		}

	}

}
