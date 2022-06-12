package ex02_loop;

public class Ex02_while {

	public static void main(String[] args) {
		
		
		// while
		// 1. 특정 실행문을 여러 번 반복하는 경우에 사용한다.
		// 2. 언제 끝나는지 강조되는 경우에 사용한다.
		// 3. 반복의 횟수가 정해지지 않은 경우에 사용한다.
		// 4. 몇번 해야하는지 예측어려울 때, 종료가 강조될 때 while문
		// 5. 형식
		//    while(조건식)
		//        실행문
		
		
		// 통장에서 돈 빼기
		// 한 번에 300원씩 뺄 수 있을때까지 빼기
		// 잔고 출력하기
		
		int bank = 3500;
		int money = 300;
		
		while(bank >= money)
			bank -= money;
		
		System.out.println("최종잔액: " + bank + "원");
		
	}

}