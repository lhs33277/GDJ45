package com.goodee.ex12.util;

public class SecurityUtils {
<<<<<<< HEAD

=======
	
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
	// new SecurityUtils 없이 메소드 호출하기 위해서 static 메소드로 구현
	
	public static String XSS(String s) {
		s = s.replaceAll("<", "&lt;");
		s = s.replaceAll(">", "&gt;");
		s = s.replaceAll("\"", "&quot;");
<<<<<<< HEAD
		s = s.replaceAll("\'", "&#x27");
		return s;
	}
	
	
=======
		s = s.replaceAll("\'", "&#x27;");
		return s;
	}

>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
}
