package ex01_variable;

public class Ex02_variable {

	public static void main(String[] args) {

		// 변수(variable)
		// 1. 컴퓨터의 메모리(램)에 확보되는 데이터 저장 공간
		// 2. 메모리(램)는 1바이트마다 고유번호(0부터 시작하는 16진수)를 부여
		// 3. 주소(address) : 1바이트마다 부여된 메모리의 고유번호
		
		// 1. byte타입
		//  1) 1바이트
		//  2) 정수
		//  3) 모든 데이터의 최소단위를 의미
		
		// 2. short타입
		//  1) 2바이트
		//  2) 정수
		//  3) 과거용
	
		// 3. int타입
		//  1) 4바이트
		//  2) 정수 (기본 단위)
		//  3) 가용범위 : 약 -21억4700만 ~ 21억4700만

		
		int myAge = 30;
		System.out.println(myAge);
		
		// 4. long타입
		//  1) 8바이트
		//  2) 정수
		//  3) suffix(접미사)가 L
		
		long myMoney = 50000L;
		System.out.println(myMoney);
		
		// 1바이트 = 8비트
		//             갯수                  범위
		// 1비트        2              
		// 2비트        4              
		// 3비트        8              
		// ...
		// n비트      2의n승     -(2의 n-1승) ~ (2의 n-1제곱)-1
		
		
		// 5. float타입
		//  1) 4바이트
		//  2) 실수
		//  3) suffix(접미사)가 F
		//  4) 과거용
		
		// 6. double타입
		//  1) 8바이트
		//  2) 실수 (기본단위)
		
		double myWeight = 60.8;
		System.out.println(myWeight);
		
		
		
		
		// 7. char타입
		//  1) 2바이트
		//  2) 문자''
		//  3) 정수(실제로 저장될 때는 문자의 코드값)
		//  4) '0' : 48 , 'A' : 65 , 'a' : 97
		
		char myGender = 'A';
		System.out.println(myGender);
		
		
		// 8. boolean타입
		//  1) true , false 중 하나만 저장
        //  2) 논리
		//  3) boolean타입의 변수는 is로 시작하는 경우가 많음. 관습.
		
		boolean isKorean = true;
		System.out.println(isKorean);
		
		
		// 9. String 클래스 타입
		//  1) 기본타입(primitive type)이 아님.
		//  2) 문자열
		//  3) 참조타입(reference) : 데이터가 아닌 데이터의 참조값(번지값)을 저장
		
		String myName = "이형식";
		System.out.println(myName);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
