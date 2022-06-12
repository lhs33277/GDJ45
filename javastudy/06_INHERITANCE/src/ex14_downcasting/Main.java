package ex14_downcasting;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Alba();
		
		p.eat();
		
		((Alba)p).study();
		((Alba)p).work();
		
		if(p instanceof Alba) {// p는 Alba 인스턴스인가?
			((Alba) p).study();
			((Alba) p).work();
		}
		
	}

}


	// 다운캐스팅
	// 1. downcasting
	// 2. 부모 클래스 타입의 인스턴스를 자식 클래스 타입으로 변환하는 것이다.
	// 3. 부모 클래스 타입으로 저장된 자식 클래스의 메소드 호출 문제를 해결한다.
	// 4. instanceof 연산자를 이용해서 안전하게 캐스팅하는 것이 좋다.