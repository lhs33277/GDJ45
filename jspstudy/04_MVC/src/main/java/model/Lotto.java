package model;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lotto implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 응답
		Set<Integer> lotto = new HashSet<>();
		while(lotto.size() != 6) {
			lotto.add( (int)(Math.random() * 45) + 1 );
		}
		
		// 응답 결과는 request에 속성(attribute)으로 저장한다.
		request.setAttribute("result", lotto.toString());
		
		ActionForward af = new ActionForward();
		af.setView("views/output.jsp");
		af.setRedirect(false);
		
		return af;
		
	}
	
}