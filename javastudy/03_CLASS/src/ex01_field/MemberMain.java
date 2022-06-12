package ex01_field;

public class MemberMain {

	public static void main(String[] args) {
		
		// Member : 클래스(타입)		
		// M	  : 인스턴스(객체)    변수x
		
		
		Member m = new Member();      // 객체 생성         // m은 다섯개의 필드를 가진다.
		
		//인스턴스(객체)가 가지고 있는 필드값은 마침표(.) 표기법으로 확인
		System.out.println(m);          // 클래스명@참조값(주소)
		System.out.println(m.userId);
		System.out.println(m.name);
		System.out.println(m.age);
		System.out.println(m.height);
		System.out.println(m.isVIP);
		
		// 인스턴스에 값을 전달하기
		m.userId = "manager";
		m.name = "관리자";
		m.age = 45;
		m.height = 180.5;
		m.isVIP = true;
		
		
		
		
		
		
		
		
		System.out.println(m.userId);
		System.out.println(m.name);
		System.out.println(m.age);
		System.out.println(m.height);
		System.out.println(m.isVIP);
		
		//클래스를 쓰면 여러개의 데이터를 하나의 데이터로 관리
		//패키지명바꾸기 f2
		
		
	}

}
